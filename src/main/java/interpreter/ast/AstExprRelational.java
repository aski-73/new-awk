package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

/**
 * Handles >, >=, <, <=
 */
public class AstExprRelational extends AstExpr {
    public Token op;
    AstExpr left;
    AstExpr right;

    public AstExprRelational(AstExpr left, AstExpr right, Token op, Type baseType) {
        super(left.start, right.end, baseType);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    /**
     * Comparison is only allowed between numerical values
     *
     * @return {@link ValueBoolean}
     */
    @Override
    public Value run() {
        if (type == Type.ERROR || type == Type.STRING || type == Type.BOOLEAN) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
            return null;
        }

        Value left = this.left.run();
        Value right = this.right.run();

        // interpret every numerical value as double to reduce if-statements
        switch (op.image) {
            case ">":
                return new ValueBoolean((Double) left.value > (Double) right.value);
            case "<":
                return new ValueBoolean((Double) left.value < (Double) right.value);
            case ">=":
                return new ValueBoolean((Double) left.value >= (Double) right.value);
            default: // <=
                return new ValueBoolean((Double) left.value <= (Double) right.value);
        }
    }
}
