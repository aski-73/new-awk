package interpreter.ast;

public class AstEasyChar extends AstEasyRegex {
    public AstEasyChar(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
    }

    @Override
    public Value run() {
        return null;
    }
}
