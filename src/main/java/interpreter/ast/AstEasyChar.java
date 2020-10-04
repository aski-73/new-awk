package interpreter.ast;

public class AstEasyChar extends AstEasyRegex {
    public AstEasyChar(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
    }

    @Override
    public Object run() {
        return null;
    }
}
