package interpreter;

import interpreter.ast.AstNode;

public class Array {
    public int length;
    public int dimensions;
    public Object array;
    public Array() {
        array = new int[]{1, 2};
    }
}
