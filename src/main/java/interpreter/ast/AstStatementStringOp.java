package interpreter.ast;

import interpreter.Token;

import java.util.List;

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

    @Override
    public Value run() {
        return null;
    }
}
