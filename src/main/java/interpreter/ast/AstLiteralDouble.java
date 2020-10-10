package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstLiteralDouble extends AstExpr {

    public AstLiteralDouble(Token t) {
        super(t, t);
        type = Type.DOUBLE;
    }

    public Value run() {
        return new ValueDouble(Double.parseDouble(start.image));
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
