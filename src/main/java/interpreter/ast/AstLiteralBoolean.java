package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstLiteralBoolean extends AstExpr {

    public AstLiteralBoolean(Token t) {
        super(t, t);
        type = Type.BOOLEAN;
    }

    public Value run() {
        return new ValueBoolean(Boolean.parseBoolean(start.image));
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {

    }

    @Override
    public String toString() {
        return  type.name();
    }

    @Override
    public int length() {
        return run().length();
    }
}
