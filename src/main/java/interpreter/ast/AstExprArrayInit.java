package interpreter.ast;

import interpreter.Token;

import java.util.List;

public class AstExprArrayInit extends AstExpr {
    public List<AstExpr> elements;
    public int dimensions = 1;

    public AstExprArrayInit(Token start, Token end, List<AstExpr> elements) {
        super(start, end);
        this.elements = elements;
    }

    @Override
    public Value run() {
        return null;
    }
}
