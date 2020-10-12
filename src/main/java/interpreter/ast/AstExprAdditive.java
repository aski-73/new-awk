package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

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
            if (type == Type.INT) {
                return new ValueInteger((Integer) left.value - (Integer) right.value);
            } else { // Double
                return new ValueDouble((Double) left.value - (Double) right.value);
            }
        }
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        left.checkSemantic(errors);
        right.checkSemantic(errors);
        type = Helper.determineTypeBase(left.type, right.type);
        if (type == Type.ERROR || type == Type.BOOLEAN)
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));

        if (op.image.equals("-") && type == Type.STRING)
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
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
