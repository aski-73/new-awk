package interpreter.ast;


import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstStatementVariableDeclaration extends AstStatement {

    public Token type;
    public Token identifier;
    public AstExpr val;
    public int dimensions;
    public SymbolTable st;

    public AstStatementVariableDeclaration(Token start, Token end, Token type, Token identifier, AstExpr val, int dimensions, SymbolTable st) {
        super(start, end);
        this.type = type;
        this.identifier = identifier;
        this.val = val;
        this.dimensions = dimensions;
        this.st = st;
    }

    @Override
    public Value run() {
        if (val != null)
            val = val.run();

        // normally a statement returns nothing, but anyway
        return (Value) val;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (val != null) {
            val.checkSemantic(errors);

            // first check if invalid types
            Type typeBase = Helper.determineTypeBase(Type.parseType(type.image), val.type);

            // all types can implicitly be assigned to a type whose ordinal value is higher or equal, but not lower
            if (typeBase == Type.ERROR || Type.parseType(type.image).ordinal() < val.type.ordinal()) {
                val.type = Type.ERROR;
                String msg = String.format("invalid types between '%s' and '%s'. Make sure that your variable is initialized.", Type.parseType(type.image).name(), val.type);
                errors.add(new SemanticError(msg, type, val.end));
            }
        }

        if (st.find(identifier.image) != null)
            errors.add(new SemanticError(String.format("Variable '%s' is already declared.%n", identifier.image), type, end));
        else {
            AstVariable var = new AstVariable(type, identifier, identifier);
            var.value = val;
            st.add(identifier.image, var);
        }
    }
}
