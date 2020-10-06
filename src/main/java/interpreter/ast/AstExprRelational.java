package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

/**
 * Handles >, >=, <, <=
 */
public class AstExprRelational extends AstExpr {
    public Token op;
    public AstExpr left;
    public AstExpr right;

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

        // relational expr has always a boolean type after running
        type = Type.BOOLEAN;

        // interpret every numerical value as double to reduce if-statements
        switch (op.image) {
            case ">":
                return new ValueBoolean(((Number) left.value).doubleValue() > ((Number) right.value).doubleValue());
            case "<":
                return new ValueBoolean(((Number) left.value).doubleValue() < ((Number) right.value).doubleValue());
            case ">=":
                return new ValueBoolean(((Number) left.value).doubleValue() >= ((Number) right.value).doubleValue());
            default: // <=
                return new ValueBoolean(((Number) left.value).doubleValue() <= ((Number) right.value).doubleValue());
        }
    }
}
