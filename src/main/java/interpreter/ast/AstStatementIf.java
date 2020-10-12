package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

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
    public Value run() {
        Value s = condition.run();
        // type of a condition should be a boolean
        if (s.value instanceof Boolean && (Boolean) s.value) {
            this.ifStatement.run();
        } else {
            this.elseStatement.run();
        }

        // Statements does not return values
        return new ValueInteger(0);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (condition.type != Type.BOOLEAN) {
            errors.add(new SemanticError("invalid condition type for if statement."));
        }
    }
}
