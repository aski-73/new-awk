package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstStatementPrint  extends AstStatement {
    public AstExpr value;
    public AstStatementPrint(Token start, Token end, AstExpr value) {
        super(start, end);
        this.value = value;
    }
    @Override
    public Value run() {
        System.out.println(value.run().toString());
        return new ValueString(value.run().toString());
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        value.checkSemantic(errors);
    }
}
