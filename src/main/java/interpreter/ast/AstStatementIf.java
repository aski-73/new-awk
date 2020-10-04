package interpreter.ast;

import interpreter.Token;

public class AstStatementIf extends AstStatement {
    public AstExpr condition;
    public AstStatement ifStatement;
    public AstStatement elseStatement;

    // PARSER

    public AstStatementIf(Token st, AstExpr expr, AstStatement ifStatement, AstStatement elseStatement) {
        super(st, elseStatement != null ? elseStatement.end : ifStatement.end);
        condition = expr;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }


    // INTERPRETER

    @Override
    public Object run() {
        Value s = condition.run();
        // type of a condition should be a boolean
        if (s.value instanceof Boolean && (Boolean) s.value) {
            this.ifStatement.run();
        } else {
            this.elseStatement.run();
        }

        // Statements does not return values
        return null;
    }
}