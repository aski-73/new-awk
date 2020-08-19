import ast.Node;

public class Atom extends Node {
    Token content;

    public Atom(Token t) {
        content = t;
    }
}
