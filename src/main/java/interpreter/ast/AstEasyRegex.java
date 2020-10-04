package interpreter.ast;

public abstract class AstEasyRegex extends AstNode {
    public AstFunctionBlock astFunctionBlock;

    public AstEasyRegex(AstFunctionBlock astFunctionBlock) {
        super();
        this.astFunctionBlock = astFunctionBlock;
    }
}
