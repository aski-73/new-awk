package interpreter.ast;

import interpreter.Token;

public class AstExprUnary extends AstExpr {
    public Token unaryOp;
    public AstExpr expr;

    public AstExprUnary(Token unaryOp, AstExpr expr) {
        super(unaryOp, expr.end);
        this.unaryOp = unaryOp;
        this.expr = expr;
    }

    // Interpreter

    @Override
    public Value run() {
        if (unaryOp == null)
            return expr.run();

        Value v = expr.run();
        switch (unaryOp.image) {
            case "++":  // Pre increment
                v.preIncrement();
                break;
            case "--":  // Pre decrement
                v.preDecrement();
                break;
            case "+":  // basically does nothing
                v.unaryPlus();
                break;
            default:  // "-" => change sign on numeric values
                v.unaryMinus();
                break;
        }
        return v;
    }
}
