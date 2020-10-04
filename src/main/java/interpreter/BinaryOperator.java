package interpreter;

import interpreter.ast.AstNode;

public class BinaryOperator {
    AstNode left, right;
    Token operator;

    public BinaryOperator(AstNode left, AstNode right, Token operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}
