package interpreter.ast;

import interpreter.lexer.SimpleTokenType;

public abstract class AstEasyRegex extends AstNode {
    public AstFunctionBlock astFunctionBlock;
    public String regex;
    public boolean isNegation = false;
    /**
     * Regex expressions need a name for referencing the found token(s)
     *
     * name is random generated
     */
    public String name;

    public AstEasyRegex(AstFunctionBlock astFunctionBlock) {
        super();
        this.astFunctionBlock = astFunctionBlock;
    }

    public abstract String negation();
}
