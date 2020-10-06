package interpreter.ast;

import interpreter.Token;

public class AstLiteralChar extends AstExpr {

    public AstLiteralChar(Token t) {
        super(t, t);
        type = Type.CHAR;
    }

    public Value run() {
        // char is always just one character. An image contains therefore the chars, e.g 'A' => take the middle one
        return new ValueChar(start.image.charAt(1));
    }
}
