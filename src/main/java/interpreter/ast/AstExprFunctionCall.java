package interpreter.ast;

import interpreter.Helper;
import interpreter.NawkParserConstants;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.Collections;
import java.util.List;

public class AstExprFunctionCall extends AstExpr {
    public AstExpr identifier;
    public AstFunctionDeclaration declaration;
    /**
     * Function parameters. Can be variables, can be expressions
     */
    public List<AstExpr> params;

    public AstExprFunctionCall(Token start, Token end, AstExpr identifier, AstFunctionDeclaration declaration, List<AstExpr> params, SymbolTable st) {
        super(start, end);
        this.identifier = identifier;
        this.declaration = declaration;
        this.params = params;
        this.symbolTable = st;
    }

    @Override
    public Value run() {
        // if declaration is null it is probably a predefined function. they only have 1 param
        if (declaration == null) {
            String id =  ((AstLiteralIdent) identifier).identifier.image;
            AstExpr param = params.get(0).run();

            if (id.equals("len")) { // len accepts all types
                return new ValueInteger(param.length());
            }

            // other functions only accept string
            String value = (String) ((ValueString) param).value;

            switch (id) {
                // toX Functions convert a string to type X
                // isX Function check if a string is of type x
                case "toDouble":
                    return new ValueDouble(Double.parseDouble(value));
                case "toInteger":
                    return new ValueInteger(Integer.parseInt(value));
                case "toChar":
                    return new ValueChar((char) Integer.parseInt(value));
                case "toBoolean":
                    return new ValueBoolean(Boolean.parseBoolean(value));
                case "isDouble":
                    return new ValueBoolean(isDouble(value));
                case "isInt":
                    return new ValueBoolean(isInt(value));
                case "isBoolean":
                    return new ValueBoolean(isBoolean(value));
                case "isChar":
                    return new ValueBoolean(isChar(value));
                default: // unknown
                    return null;
            }
        } else {
            if (params.size() == declaration.params.size()) {
                for (int i = 0; i < params.size(); i++) {
                    Token type = new Token(NawkParserConstants.Ident, declaration.params.get(i).type.name());
                    AstVariable var = new AstVariable(type, declaration.params.get(i).identifier, end);
                    var.value = params.get(i).run();
                    if (declaration.symbolTable.find(declaration.params.get(i).identifier.image) != null) {
                        // delete it to replace it
                        declaration.symbolTable.removeValue(declaration.params.get(i).identifier.image);
                    }
                    declaration.symbolTable.add(declaration.params.get(i).identifier.image, var);
                }
            }
        }


        return declaration.astFunctionBlock.run();
    }

    public boolean isChar(String s) {
        try {
            int i = Integer.parseInt(s);
            return i >= 0 && i < 65536; // char is max 2byte (2^16 - 1) and always positive
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String s) {
        try {
            double i = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isBoolean(String s) {
        try {
            boolean i = Boolean.parseBoolean(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        // Function name must be type of AstLiteralIdent since no other literal makes sense for function name
        if (!(identifier instanceof AstLiteralIdent)) {
            String msg = String.format("'%s' is not an function identifier", identifier.toString());
            errors.add(new SemanticError(msg, start, end));
        } else {
            String i =  ((AstLiteralIdent) identifier).identifier.image;
            if (symbolTable.find(i) instanceof AstFunctionDeclaration) {
                declaration = (AstFunctionDeclaration) symbolTable.find(i);
            } else {
                if (!Helper.isPredefined(i)) {
                    String msg = String.format("function '%s' is not declared or a function", i);
                    errors.add(new SemanticError(msg, start, end));
                } else { // only for pre defined functions like toDouble etc.
                    // if declaration is null it is probably a predefined function. they only have 1 param
                    if (params.size() != 1)  {
                        String msg = String.format("invalid number of parameters for function '%s'", identifier);
                        errors.add(new SemanticError(msg, start, end));
                    }
                }
            }

            for (AstExpr param: params) {
                if (param.type == Type.VOID) {
                    String msg = String.format("invalid parameter type void of '%s' for function '%s'", param.toString(), identifier);
                    errors.add(new SemanticError(msg, start, end));
                }
            }
        }

        // Check params
        if (declaration != null && declaration.params.size() != params.size()) {
            String msg = String.format("invalid number of parameters for function '%s'", identifier);
            errors.add(new SemanticError(msg, start, end));
        }
    }

    @Override
    public String toString() {
        return identifier + "(..)";
    }

    @Override
    public int length() {
        return run().length();
    }
}
