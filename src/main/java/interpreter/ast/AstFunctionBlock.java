package interpreter.ast;

import interpreter.Token;

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
        for (AstStatement st: statements) {
            st.run();
        }

        return returnValue.run();
    }
}
