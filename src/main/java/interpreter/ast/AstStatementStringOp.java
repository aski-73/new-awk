package interpreter.ast;

import interpreter.NawkParserConstants;
import interpreter.Token;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AstStatementStringOp extends AstStatement {
    /**
     * String that gets checked against the easy-regex expressions inside the block
     */
    public String stringLiteral;
    /**
     * List of easy-regex expression that are executed on the string literal
     */
    public List<AstEasyRegex> easyRegexList;

    public AstStatementStringOp(Token start, Token end, String stringLiteral, List<AstEasyRegex> easyRegexList) {
        super(start, end);
        this.stringLiteral = stringLiteral;
        this.easyRegexList = easyRegexList;
    }

    /**
     * Valid Regex expressions:
     * - single characters, e.g "a" => matches a's, "cd" => matches cd's
     * - ranges: "a-d" => matches a, b, c and d
     * - line begin: ^a: matches a's if they are at line begin
     * - line end: a$: matches a's if they are at line end
     *
     * @return Array with elements returned from the actions of the expression
     */
    @Override
    public Value run() {
        // Result
        List<AstExpr> elements = new LinkedList<>();
        AstExprArrayInit result = new AstExprArrayInit(null, null, Type.STRING, elements);

        // Creating a Lexer with Java Pattern API and named group feature

        // joined regex of all single regex's => regex1 regex2 => regex1 | regex2
        StringBuilder masterRegex = new StringBuilder();
        easyRegexList.forEach(easyRegex -> {
                    if (easyRegex.isNegation)
                        masterRegex.append(String.format("(?<%s>%s)|", easyRegex.name, easyRegex.negation()));
                    else
                        masterRegex.append(String.format("(?<%s>%s)|", easyRegex.name, easyRegex.regex));
                }
        );

        Pattern p = Pattern.compile(masterRegex.substring(masterRegex.toString().length()));

        // Begin matching tokens
        Matcher matcher = p.matcher(stringLiteral);
        while (matcher.find()) {
            // check which regex did the match
            for (AstEasyRegex ar : easyRegexList) {
                String token = matcher.group(ar.name);
                if (token != null) {
                    if (ar.astFunctionBlock != null) {
                        // assign matched token to "this" variable
                        Token type = Token.newToken(NawkParserConstants.STRING, "string");
                        Token id = Token.newToken(NawkParserConstants.Ident, "this");
                        AstVariable thisVar = new AstVariable(type, id, id);
                        thisVar.value = new AstLiteralString(Token.newToken(NawkParserConstants.STRING, token));
                        ar.astFunctionBlock.symbolTable.add("this", thisVar);
                        // run block statement of easy regex
                        ar.astFunctionBlock.run();


                        if (ar.astFunctionBlock.returnValue == null) { // no return value => just add matched token to result
                            elements.add(new AstLiteralString(Token.newToken(NawkParserConstants.STRING, token)));
                        } else { // return value => run the return expression and add its value to result
                            elements.add(new AstLiteralString(Token.newToken(NawkParserConstants.STRING, ar.astFunctionBlock.returnValue.run().value.toString())));
                        }
                    }
                }
            }
        }

        return result;
    }
}
