package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstLiteralIdent extends AstExpr {

    public Token identifier;

    public AstLiteralIdent(Token identifier, SymbolTable st) {
        super(identifier, identifier);
        this.identifier = identifier;
        this.symbolTable = st;
        type = Type.VOID;
    }

    public Value run() {
        AstVariable literal = new AstVariable(identifier, identifier, identifier);
        if (!Helper.isPredefined(identifier.image)) {
            // already declared. assign
            literal = symbolTable.find(identifier.image);
        } else {
            // if predefined just return its identifier as a string
            literal.value = new ValueString(identifier.image);
        }
        return literal.run();
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (symbolTable.find(identifier.image) != null)
            type = symbolTable.find(identifier.image).type;

        if (!Helper.isPredefined(identifier.image)) {
            // check for variable in symbol table since the variable could change in runtime
            if (symbolTable.find(identifier.image) == null) { // not set
                errors.add(new SemanticError(String.format("Variable '%s' is not defined yet.%n", identifier.image), start, end));
            }
        }
    }

    @Override
    public String toString() {
        return identifier.image;
    }

    @Override
    public int length() {
        return run().length();
    }
}
