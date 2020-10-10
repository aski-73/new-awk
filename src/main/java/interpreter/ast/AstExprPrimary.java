package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

public class AstExprPrimary extends AstExpr {
    /**
     * Value of the expression. May be an identifier
     */
    public AstExpr literal;
    /**
     * If not null, then this is an array or a function call
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

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (suffix != null)
            suffix.checkSemantic(errors);
        literal.checkSemantic(errors);

        type = literal.type;
    }

    @Override
    public String toString() {
        if (suffix != null)
            return literal.toString() + " " + suffix.toString();
        else
            return literal.toString();
    }

    @Override
    public int length() {
        return run().length();
    }
}
