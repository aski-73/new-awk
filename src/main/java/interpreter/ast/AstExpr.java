package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstExpr extends AstStatement {
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

    @Override
    public void checkSemantic(List<CompilerError> errors) {    }
}
