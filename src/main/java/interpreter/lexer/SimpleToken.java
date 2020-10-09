package interpreter.lexer;
public class SimpleToken {
    public SimpleTokenType type;
    public String data;

    public SimpleToken(SimpleTokenType type, String data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("(%s %s)", type.name(), data);
    }
}