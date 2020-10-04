package interpreter.errors;

import interpreter.Token;

public class SyntaxError extends CompilerError {
    public SyntaxError(String msg, Token start, Token end) {
        super(msg,start,end);
    }
}
