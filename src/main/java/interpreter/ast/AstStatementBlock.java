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
    public Value run() {
        for (AstStatement statement: statementList) {
            // call all kinds of statements in this block. Each statement have access to their own symbol table. That's
            // way no further work with the symbol table is needed (all variables in all  statements evaluate to "literal()"
            // and therefore know what values is behind an identifier)
            statement.run();
        }

        // a statement block does not have a return value
        return null;
    }
}
