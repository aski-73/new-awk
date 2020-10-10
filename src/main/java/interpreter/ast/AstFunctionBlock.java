package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstFunctionBlock extends AstNode {
    public List<AstStatement> statements;
    public AstExpr returnValue;

    public AstFunctionBlock(Token start, Token end, List<AstStatement> statements, AstExpr returnValue) {
        super(start, end);
        this.statements = statements;
        this.returnValue = returnValue;
    }

    @Override
    public Value run() {
        for (AstStatement st : statements) {
            st.run();
        }

        if (returnValue == null)
            return new ValueString("");

        return returnValue.run();
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        for (AstStatement statement : statements)
            statement.checkSemantic(errors);

        if (returnValue != null)
            returnValue.checkSemantic(errors);
    }
}
