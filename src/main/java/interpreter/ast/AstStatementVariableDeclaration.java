package interpreter.ast;


import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstStatementVariableDeclaration extends AstStatement {

    private Token type;
    private AstVariable var;
    private int dimensions;
    private SymbolTable st;

    public AstStatementVariableDeclaration(Token start, Token end, Token type, AstVariable var, int dimensions, SymbolTable st) {
        super(start, end);

        this.type = type;
        this.var = var;
        this.dimensions = dimensions;
        this.st = st;
    }
    @Override
    public Value run() {
        var.value = var.run();
        return (Value) var.value;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        var.checkSemantic(errors);

        if (var.value != null) { // value is set => guess type
            var.type = var.value.type;
        }

        // first check if invalid types
        Type typeBase = Helper.determineTypeBase(Type.parseType(type.image), var.type);

        // all types can implicitly be assigned to a type whose ordinal value is higher or equal, but not lower
        if (typeBase == Type.ERROR || Type.parseType(type.image).ordinal() < var.type.ordinal()) {
            var.type = Type.ERROR;
            String msg = String.format("invalid types between '%s' and '%s'. Make sure that your variable is initialized.", Type.parseType(type.image).name(), var.type);
            errors.add(new SemanticError(msg, type, var.end));
        }

        if (st.find(var.identifier.image) != null)
            errors.add(new SemanticError(String.format("Variable '%s' is already declared.%n", var.identifier.image), type, var.end));
        else
            st.add(var.identifier.image, var);
    }
}
