package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

/**
 * Handles Addition and Subtraction
 */
public class AstExprAdditive extends AstExpr {
    public Token op;
    public AstExpr left;
    public AstExpr right;

    public AstExprAdditive(AstExpr left, AstExpr right, Token op, Type baseType) {
        super(left.start, right.end, baseType);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    // INTERPRETER

    @Override
    public Value run() {
        if (type == Type.ERROR || type == Type.BOOLEAN) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
            return null;
        }

        Value left = this.left.run();
        Value right = this.right.run();

        if (op.image.equals("+")) {
            if (type == Type.STRING) {
                return new ValueString(left.value.toString() + right.value.toString());
            } else if (type == Type.INT) {
                return new ValueInteger((Integer) left.value + (Integer) right.value);
            } else { // Double
                return new ValueDouble((Double) left.value + (Double) right.value);
            }
        } else { // "-"
            if (type == Type.STRING) {
                errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
                return null;
            } else if (type == Type.INT) {
                return new ValueInteger((Integer) left.value - (Integer) right.value);
            } else { // Double
                return new ValueDouble((Double) left.value - (Double) right.value);
            }
        }
    }
}
