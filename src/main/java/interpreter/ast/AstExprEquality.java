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

        // equality expr has always a boolean type after running
        type = Type.BOOLEAN;

        // to keep it simple types are compared as strings, since it is possible to compare implicit types
        if (op.image.equals("=="))
            return new ValueBoolean(left.value.toString().equals(right.value.toString()));
        else
            return new ValueBoolean(!left.value.toString().equals(right.value.toString()));
    }
}
