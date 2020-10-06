package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

/**
 * Handles &&
 */
public class AstExprConditionalAnd extends AstExpr {
    public Token op;
    AstExpr left;
    AstExpr right;

    public AstExprConditionalAnd(AstExpr left, AstExpr right, Token op, Type baseType) {
        super(left.start, right.end, baseType);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    // INTERPRETER

    @Override
    public Value run() {
        if (type == Type.ERROR) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
            return null;
        }
        Value left = this.left.run();
        Value right = this.right.run();

        // "OR" expr has always a boolean type after running
        type = Type.BOOLEAN;

        return new ValueBoolean((Boolean) left.value && (Boolean) right.value);
    }
}
