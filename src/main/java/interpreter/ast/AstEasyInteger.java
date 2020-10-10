package interpreter.ast;

import interpreter.errors.CompilerError;
import interpreter.lexer.SimpleTokenType;

import java.util.List;

public class AstEasyInteger extends AstEasyRegex {

    public AstEasyInteger(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
        regex = "[0-9]";
        name = AstEasyRegexCustom.generateName();
    }

    @Override
    public String negation() {
        return "[^0-9]";
    }

    @Override
    public Value run() {
        return null;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        // function block is optional
        if (astFunctionBlock != null) {
            astFunctionBlock.checkSemantic(errors);
        }
    }
}
