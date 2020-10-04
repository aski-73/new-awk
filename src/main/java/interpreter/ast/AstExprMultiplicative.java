package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

/**
 * Handles Multiplication, Division and Modulo
 */
public class AstExprMultiplicative extends AstExpr {
    public Token op;
    AstExpr left;
    AstExpr right;

    public AstExprMultiplicative(AstExpr left, AstExpr right, Token op, Type baseType) {
        super(left.start, right.end, baseType);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    // INTERPRETER

    /**
     * Parser makes sure that only numeric values are in this expression
     */
    @Override
    public Value run() {
        // only numeric values can be multiplied
        if (type == Type.ERROR || type == Type.BOOLEAN || type == Type.STRING) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
            return null;
        }

        // AST handles that right value exists. If right value is not given, it would be of type unary expression
        Value left = this.left.run();
        Value right = this.right.run();
        // The result type is the base/common type of the operands. Therefore the operands are casted to their common type
        // since it does not change the result
        switch (op.image) {
            case "*":
                if (type == Type.INT) { // base type is int => handle both operands as integer
                    return new ValueInteger(((Integer) left.value * (Integer) right.value));
                } else { // base type is double => handle both as double
                    return new ValueDouble((Double) left.value * (Double) right.value);
                }
            case "/":
                if (type == Type.INT) { // base type is int => handle both operands as integer
                    return new ValueInteger(((Integer) left.value / (Integer) right.value));
                } else { // base type is double => handle both as double
                    return new ValueDouble((Double) left.value / (Double) right.value);
                }
            default: // modulo
                if (type == Type.INT) { // base type is int => handle both operands as integer
                    return new ValueInteger(((Integer) left.value % (Integer) right.value));
                } else { // base type is double => handle both as double
                    return new ValueDouble((Double) left.value % (Double) right.value);
                }
        }
    }
}
