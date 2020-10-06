package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstExprFunctionCall extends AstExpr {
    private String identifier;
    public AstFunctionDeclaration declaration;
    /**
     * Function parameters. Can be variables, can be expressions
     */
    private List<AstExpr> params;

    public AstExprFunctionCall(Token start, Token end, String identifier, AstFunctionDeclaration declaration, List<AstExpr> params) {
        super(start, end);
        this.identifier = identifier;
        this.declaration = declaration;
        this.params = params;
    }

    @Override
    public Value run() {
        if (declaration == null) {
            // if declaration is null it is probably a predefined function. they only have 1 param
            if (params.size() != 1)  {
                String msg = String.format("invalid number of parameters for function '%s'", identifier);
                errors.add(new SemanticError(msg, start, end));
                return null;
            }
            Object param = params.get(0).run();
            if (!(param instanceof ValueString)) {
                String msg = String.format("parameter for function '%s' is not a string", identifier);
                errors.add(new SemanticError(msg, start, end));
                return null;
            }
            String value = (String) ((ValueString) param).value;

            switch (identifier) {
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
        }

        if (errors.size() > 0) {
            errors.add(new SemanticError("can not run function. check out other errors."));
            return null;
        }

        // Check params
        if (declaration.st.table.size() != params.size()) {
            String msg = String.format("invalid number of parameters for function '%s'", identifier);
            errors.add(new SemanticError(msg, start, end));
            return null;
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
}
