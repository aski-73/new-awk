package interpreter.ast;

import interpreter.Token;

public class AstLiteralString extends AstExpr {

    public AstLiteralString(Token t) {
        super(t, t);
        type = Type.STRING;
    }

    public Value run() {
        // remove leading and trailing quotation marks of the token (otherwise we would have quotation marks in
        // quotation marks)
        return new ValueString(start.image.substring(1, start.image.length() - 1));
    }
}
