package interpreter.ast;

import interpreter.Token;

public class AstLiteralBoolean extends AstExpr {

    public AstLiteralBoolean(Token t) {
        super(t, t);
        type = Type.BOOLEAN;
    }

    public Value run() {
        return new ValueBoolean(Boolean.parseBoolean(start.image));
    }
}
