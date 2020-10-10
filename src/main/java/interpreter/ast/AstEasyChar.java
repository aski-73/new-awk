package interpreter.ast;

import interpreter.errors.CompilerError;
import interpreter.lexer.SimpleTokenType;

import java.util.List;

public class AstEasyChar extends AstEasyRegex {

    public AstEasyChar(AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
        regex = "[a-zA-Z]";
        name = AstEasyRegexCustom.generateName();
    }

    @Override
    public String negation() {
        return "[^a-zA-Z]";
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
