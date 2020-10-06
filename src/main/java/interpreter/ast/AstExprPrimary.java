package interpreter.ast;

public class AstExprPrimary extends AstExpr {
    /**
     * Value of the expression. May be an identifier
     */
    public AstExpr literal;
    /**
     * If not null, then this is an array
     */
    public AstExpr suffix;

    public AstExprPrimary(AstExpr literal, AstExpr suffix) {
        super(literal.start, literal.end, literal.type);
        this.literal = literal;
        this.suffix = suffix;
    }

    @Override
    public Value run() {
        if (suffix != null) { // Array or function call
           return suffix.run();
        } else {
            return literal.run();
        }
    }
}
