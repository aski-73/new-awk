package interpreter.ast;

import interpreter.Token;

public abstract class AstExpr extends AstStatement {
    public Type type = Type.ERROR;

    public AstExpr(Token start, Token end) {
        super(start, end);
    }
    public AstExpr(Token start, Token end, Type type) {
        super(start, end);
        this.type = type;
    }

    @Override
    public Value run() {
        return null;
    }

    /**
     * Returns size of an element
     */
    public abstract int length();
}
