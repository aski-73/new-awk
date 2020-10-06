package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.LinkedList;
import java.util.List;

public abstract class AstNode {
    public Token start, end;

    public AstNode() {}

    /**
     * semantic and syntactic error;
     */
    public List<CompilerError> errors = new LinkedList<>();

    public AstNode(Token start, Token end) {
        this.start = start;
        this.end = end;
    }

    public abstract Value run();

    public void setStart(Token start) {
        this.start = start;
    }

    public void setEnd(Token end) {
        this.end = end;
    }
}
