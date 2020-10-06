package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstExprArrayCall extends AstExpr {
    public AstExprArrayInit declaration;
    /**
     * Function parameters. Can be variables, can be expressions
     */
    private List<AstExpr> indices;

    public AstExprArrayCall(Token start, Token end, AstExprArrayInit declaration, List<AstExpr> indices) {
        super(start, end);
        this.declaration = declaration;
        this.indices = indices;
    }

    @Override
    public Value run() {
        if (declaration == null) {
            return new ValueInteger(0);
        }

        AstExpr  temp = declaration;
        AstExpr finalValue = new ValueInteger(0);
        for (int dim = 0; dim < indices.size(); dim++) {
            if (!(temp instanceof AstExprArrayInit)) {
                finalValue = temp.run();
                break;
            }

            Value index = indices.get(dim).run();
            if (!(index instanceof ValueInteger)) {
                String msg = String.format("invalid index '%s'", index.toString());
                errors.add(new SemanticError(msg, start, end));
                type = Type.ERROR;
                return new ValueInteger(0);
            }

            temp = ((AstExprArrayInit) temp).run((Integer) index.value);
        }

        return finalValue.run();
    }
}
