public class BinaryOperator extends Node {
    Node left, right;
    Token operator;

    public BinaryOperator(Node left, Node right, Token operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}
