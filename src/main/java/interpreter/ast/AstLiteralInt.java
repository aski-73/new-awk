package interpreter.ast;

import interpreter.Token;

public class AstLiteralInt extends AstExpr {

    public AstLiteralInt(Token t) {
        super(t, t);
        type = Type.INT;
    }

    public Value run() {
        return new ValueInteger(Integer.parseInt(start.image));
    }
}
