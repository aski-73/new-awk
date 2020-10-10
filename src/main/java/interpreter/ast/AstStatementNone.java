package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

public class AstStatementNone extends AstStatement {
    public AstStatementNone() {
        super(null, null);
    }

    @Override
    public Value run() {
        // return some value to avoid null pointer
        return new ValueInteger(0);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {

    }
}
