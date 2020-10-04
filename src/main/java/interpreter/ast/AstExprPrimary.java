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
        super(literal.start, literal.end);
        this.literal = literal;
        this.suffix = suffix;
    }

    @Override
    public Value run() {
        if (suffix != null) { // Array
            // TODO
            return null;
        } else {
            return literal.run();
        }
    }
}
