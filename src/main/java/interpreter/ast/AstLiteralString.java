package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstLiteralString extends AstExpr {

    public AstLiteralString(Token t) {
        super(t, t);
        type = Type.STRING;
    }

    public Value run() {
        // remove leading and trailing quotation marks of the token (otherwise we would have quotation marks in
        // quotation marks)
        if (start.image.startsWith("\""))
            return new ValueString(start.image.substring(1, start.image.length() - 1));
        else
            return new ValueString(start.image);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {

    }

    @Override
    public String toString() {
        // quotation marks)
        if (start.image.startsWith("\""))
            return start.image.substring(1, start.image.length() - 1);
        else
            return start.image;
    }

    @Override
    public int length() {
        return run().length();
    }
}
