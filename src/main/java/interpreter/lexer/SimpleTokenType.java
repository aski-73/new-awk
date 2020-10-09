package interpreter.lexer;

public enum SimpleTokenType {
    // Token types cannot have underscores
    NUMBER("[0-9]+"),
    CHARACTER("[a-z]+");

    public final String pattern;

    private SimpleTokenType(String pattern) {
        this.pattern = pattern;
    }
}
