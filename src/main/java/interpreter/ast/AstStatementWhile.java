package interpreter.ast;


import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstStatementWhile extends AstStatement {
    private AstExpr condition;
    private AstStatement statement;

    public AstStatementWhile(Token start, AstExpr condition, AstStatement statement, SymbolTable symbolTable) {
        super(start, statement.end);
        this.condition = condition;
        this.statement = statement;
        this.symbolTable = symbolTable;
    }

    public void checkSemantic(List<CompilerError> errors) {
        condition.checkSemantic(errors);
        if (condition.type != Type.BOOLEAN) {
            errors.add(new SemanticError("while expression must be of type boolean", condition.start, condition.end));
        }
        statement.checkSemantic(errors);
    }

    public Value run() {
        ValueBoolean value;
        do {
            value = (ValueBoolean) condition.run();
            if ((Boolean) value.value)
                statement.run();
        } while ((Boolean) value.value);

        return new ValueInteger(0);
    }
}
