package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

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
        AstVariable v = (AstVariable) left;
        v.value = right.run();
        return (Value) v.value;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (left instanceof AstVariable) {
            AstVariable v = (AstVariable) left;
            if (symbolTable.find(v.identifier.image) == null) {
                errors.add(new SemanticError(String.format("variable '%s' is not defined;", v.identifier)));
            }
        } else if (left instanceof AstLiteralIdent) {
            AstLiteralIdent v = (AstLiteralIdent) left;
            if (symbolTable.find(v.identifier.image) == null) {
                errors.add(new SemanticError(String.format("variable '%s' is not defined;", v.identifier)));
            }
        } else {
            errors.add(new SemanticError(String.format("can't assign to a literal value '%s'.", left.toString())));
        }

        left.checkSemantic(errors);
        right.checkSemantic(errors);
    }

    @Override
    public int length() {
        return run().length();
    }
}
