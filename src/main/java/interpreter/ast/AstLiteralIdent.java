package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.SemanticError;

public class AstLiteralIdent extends AstExpr {

    public Token identifier;

    public AstLiteralIdent(Token identifier, SymbolTable st) {
        super(identifier, identifier);
        this.identifier = identifier;
        this.symbolTable = st;
        if (symbolTable.find(identifier.image) != null)
            type = symbolTable.find(identifier.image).type;
        else
            type = Type.VOID;
    }

    public Value run() {
        AstVariable literal = new AstVariable(identifier, identifier, identifier);
        if (!Helper.isPredefined(identifier.image)) {
            // check for variable in symbol table since the variable could change in runtime
            if (symbolTable.find(identifier.image) == null) { // not set
                literal.errors.add(new SemanticError(String.format("Variable '%s' is not defined yet.%n", identifier.image), start, end));
            } else { // already declared. assign
                literal = symbolTable.find(identifier.image);
            }
        } else {
            // if predefined just return its identifier as a string
            literal.value = new ValueString(identifier.image);
        }
        return literal.run();
    }
}
