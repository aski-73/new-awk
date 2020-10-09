package interpreter.ast;

import java.util.UUID;

public class AstEasyRegexCustom extends AstEasyRegex {

    public AstEasyRegexCustom(String regex, AstFunctionBlock astFunctionBlock) {
        super(astFunctionBlock);
        this.regex = regex;
        name = generateName();
    }

    public static String generateName() {
        String s = UUID.randomUUID().toString();
        return "name" + UUID.randomUUID().toString().substring(s.length() - 12, s.length());
    }

    @Override
    public String negation() {
        // Cant negate since its custom
        return regex;
    }

    @Override
    public Value run() {
//        if (astFunctionBlock.returnValue instanceof )
        return null;
    }
}
