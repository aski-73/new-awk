package interpreter.ast;

import interpreter.Token;

public class AstLiteralChar extends AstExpr {

    public AstLiteralChar(Token t) {
        super(t, t);
        type = Type.CHAR;
    }

    public Value run() {
        return new ValueChar((char) Integer.parseInt(start.image));
    }
}
