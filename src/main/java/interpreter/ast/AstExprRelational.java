package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

/**
 * Handles >, >=, <, <=
 */
public class AstExprRelational extends AstExpr {
    public Token op;
    public AstExpr left;
    public AstExpr right;

    public AstExprRelational(AstExpr left, AstExpr right, Token op) {
        super(left.start, right.end);
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

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        left.checkSemantic(errors);
        right.checkSemantic(errors);
        Type baseType = Helper.determineTypeBase(left.type, right.type);
        if (baseType == Type.ERROR) {
            errors.add(new SemanticError(String.format("bad operand types for binary operator '%s'", op.image), start, end));
        }

        type = Type.BOOLEAN;
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
