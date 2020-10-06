package interpreter.ast;

import interpreter.Token;

public class AstExprUnary extends AstExpr {
    public Token unaryOp;
    public AstExpr expr;

    public AstExprUnary(Token unaryOp, AstExpr expr) {
        super(unaryOp, expr.end, expr.type);
        if (unaryOp == null)
            start = expr.start;

        this.unaryOp = unaryOp;
        this.expr = expr;
    }

    // Interpreter

    @Override
    public Value run() {
        Value v = expr.run();

        // copy in order to keep original value behind the reference
        Value copy = v.selfCopy();

        if (unaryOp == null)
            return copy;

        switch (unaryOp.image) {
            case "++":  // Pre increment
                copy.preIncrement();
                break;
            case "--":  // Pre decrement
                copy.preDecrement();
                break;
            case "+":  // basically does nothing
                copy.unaryPlus();
                break;
            case "-":  // "-" => change sign on numeric values
                copy.unaryMinus();
                break;
            default: // ! (bang, negation)
                copy.unaryBang();
        }
        return copy;
    }
}
