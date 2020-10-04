package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

public class AstAssigment extends AstExpr {
    public AstExpr left;
    public AstExpr right;
    private SymbolTable symbolTable;

    // PARSER

    public AstAssigment(Token start, Token end, AstExpr astVariable, AstExpr astExpr, SymbolTable symbolTable) {
        super(start, end);
        this.left = astVariable;
        this.right = astExpr;
        this.symbolTable = symbolTable;
    }

    // INTERPRETER

    public Value run() {
        if (!(left instanceof AstVariable)) {
            errors.add(new SemanticError("can't assign to a literal value."));
            return null;
        }

        AstVariable v = (AstVariable) left;
        if (symbolTable.find(v.identifier) == null) {
            errors.add(new SemanticError(String.format("variable '%s' is not defined;", v.identifier)));
            return null;
        }

        v.value = right;
        return right.run();
    }
}
