package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

/**
 * Handles &&
 */
public class AstExprConditionalAnd extends AstExpr {
    public Token op;
    AstExpr left;
    AstExpr right;

    public AstExprConditionalAnd(AstExpr left, AstExpr right, Token op) {
        super(left.start, right.end);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    // INTERPRETER

    @Override
    public Value run() {
        Value left = this.left.run();
        Value right = this.right.run();

        return new ValueBoolean((Boolean) left.value && (Boolean) right.value);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        left.checkSemantic(errors);
        right.checkSemantic(errors);

        type = Helper.validateTypesForConditionalOp(left.type, right.type, op);

        if (type == Type.ERROR) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
        }
    }

    @Override
    public String toString() {
        return left.toString() + " " + op.image + " " + right.toString();
    }

    @Override
    public int length() {
        return run().length();
    }
}
