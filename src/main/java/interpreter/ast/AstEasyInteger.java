package interpreter.ast;

public class AstEasyInteger extends AstEasyRegex {
    public AstEasyInteger(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
    }

    @Override
    public Value run() {
        return null;
    }
}
