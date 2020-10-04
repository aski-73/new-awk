package interpreter.ast;

import interpreter.Token;

public class AstLiteralDouble extends AstExpr {

    public AstLiteralDouble(Token t) {
        super(t, t);
        type = Type.DOUBLE;
    }

    public Value run() {
        return new ValueDouble(Double.parseDouble(start.image));
    }
}
