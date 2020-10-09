package interpreter.ast;

import interpreter.lexer.SimpleTokenType;

public class AstEasyInteger extends AstEasyRegex {

    public AstEasyInteger(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
        regex = "[0-9]";
        name = SimpleTokenType.NUMBER.name();
    }

    @Override
    public String negation() {
        return "[^0-9]";
    }

    @Override
    public Value run() {
        return null;
    }
}
