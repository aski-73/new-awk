package interpreter.ast;

import interpreter.lexer.SimpleTokenType;

public class AstEasyChar extends AstEasyRegex {
    public AstEasyChar(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
        regex = "[a-zA-Z]";
        name = SimpleTokenType.CHARACTER.name();
    }

    @Override
    public String negation() {
        return "[^a-zA-Z]";
    }
    @Override
    public Value run() {
        return null;
    }
}
