package interpreter;

import interpreter.ast.AstNode;

public class Atom  {
    Token content;

    public Atom(Token t) {
        content = t;
    }
}
