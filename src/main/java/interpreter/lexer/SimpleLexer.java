package interpreter.lexer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleLexer {
    public ArrayList<SimpleToken> lex(String input) {
        // The tokens to return
        ArrayList<SimpleToken> tokens = new ArrayList<>();

        // Lexer logic begins here.
        StringBuilder tokenPatternsBuffer = new StringBuilder();

        //  Usage of named capturing groups: (?<name>X) 	X, as a named-capturing group
        for (SimpleTokenType tokenType : SimpleTokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));

        Pattern tokenPatterns = Pattern.compile(tokenPatternsBuffer.substring(1));

        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            if (matcher.group(SimpleTokenType.NUMBER.name()) != null) {
                tokens.add(new SimpleToken(SimpleTokenType.NUMBER, matcher.group(SimpleTokenType.NUMBER.name())));
            } else if (matcher.group(SimpleTokenType.CHARACTER.name()) != null) {
                tokens.add(new SimpleToken(SimpleTokenType.CHARACTER, matcher.group(SimpleTokenType.CHARACTER.name())));
            }
        }

        return tokens;
    }
}
