package interpreter.ast;

import interpreter.Token;

public abstract class AstStatement extends AstNode {
    public AstStatement(Token start, Token end) {
        super(start, end);
    }
}
