package interpreter.ast;

public class AstStatementEmpty extends AstStatement {
    public AstStatementEmpty() {
        super(null, null);
    }

    @Override
    public Value run() { return null; }
}
