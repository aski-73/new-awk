package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

/**
 * Handles ==, !=
 */
public class AstExprEquality extends AstExpr {
    public Token op;
    AstExpr left;
    AstExpr right;

    public AstExprEquality(AstExpr left, AstExpr right, Token op, Type baseType) {
        super(left.start, right.end, baseType);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public Value run() {
        if (type == Type.ERROR) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
            return null;
        }

        Value left = this.left.run();
        Value right = this.right.run();

        if (op.image.equals("=="))
            return new ValueBoolean(left.equals(right));
        else
            return new ValueBoolean(!left.equals(right));
    }
}
