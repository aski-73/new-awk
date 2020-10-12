package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

/**
 * Handles ==, !=
 */
public class AstExprEquality extends AstExpr {
    public Token op;
    AstExpr left;
    AstExpr right;

    public AstExprEquality(AstExpr left, AstExpr right, Token op) {
        super(left.start, right.end);
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public Value run() {
        Value left = this.left.run();
        Value right = this.right.run();

        // to keep it simple types are compared as strings, since it is possible to compare implicit types
        if (op.image.equals("=="))
            return new ValueBoolean(left.value.toString().equals(right.value.toString()));
        else
            return new ValueBoolean(!left.value.toString().equals(right.value.toString()));
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
