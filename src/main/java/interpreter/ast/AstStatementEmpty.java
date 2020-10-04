package interpreter.ast;

import interpreter.Token;

public class AstStatementEmpty extends AstStatement {
    public AstStatementEmpty() {
        super(null, null);
    }

    @Override
    public Object run() { return null; }
}
