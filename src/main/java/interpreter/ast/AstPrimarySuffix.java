package interpreter.ast;

/**
 * For Array Brackets
 * Using reference of Token t to get next token (next Array Bracket)
 */
public class AstPrimarySuffix extends AstExpr {
    public AstPrimarySuffix(AstExpr a) {
        super(a.start, a.end);
    }
}
