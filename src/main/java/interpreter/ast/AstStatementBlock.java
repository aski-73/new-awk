package interpreter.ast;

import interpreter.Token;

import java.util.List;

public class AstStatementBlock extends AstStatement {
    public List<AstStatement> statementList;

    public AstStatementBlock(Token start, Token end, List<AstStatement> statementList) {
        super(start, end);
        this.statementList = statementList;
    }

    @Override
    public Object run() {
        return null;
    }
}
