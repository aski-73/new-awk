package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstLiteralInt extends AstExpr {

    public AstLiteralInt(Token t) {
        super(t, t);
        type = Type.INT;
    }

    public Value run() {
        return new ValueInteger(Integer.parseInt(start.image));
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
