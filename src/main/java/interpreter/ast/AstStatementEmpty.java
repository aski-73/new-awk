package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

public class AstStatementEmpty extends AstStatement {
    public AstStatementEmpty() {
        super(null, null);
    }

    @Override
    public Value run() { return null; }

    @Override
    public void checkSemantic(List<CompilerError> errors) {

    }
}
