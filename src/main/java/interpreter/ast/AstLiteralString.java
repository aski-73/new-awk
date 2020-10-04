package interpreter.ast;

import interpreter.Token;

public class AstLiteralString extends AstExpr {

    public AstLiteralString(Token t) {
        super(t, t);
        type = Type.STRING;
    }

    public Value run() {
        return new ValueString(start.image);
    }
}
