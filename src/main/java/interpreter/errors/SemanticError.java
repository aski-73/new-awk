package interpreter.errors;

import interpreter.Token;

public class SemanticError extends CompilerError {

    public SemanticError(String msg) {
        super("semantic error: "+msg);
    }
    public SemanticError(String msg, Token start, Token end) {
        super("semantic error: "+msg, start, end);
    }
}
