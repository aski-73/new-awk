package interpreter.ast;

import interpreter.Token;
import interpreter.errors.SemanticError;

import java.util.LinkedList;
import java.util.List;

public class AstExprArrayInit extends Value {
    /**
     * Elements can be more array init expressions xor primitive types
     */
    public List<AstExpr> elements;

    public int dimensions = 1;

    public AstExprArrayInit(Token start, Token end, Type type, List<AstExpr> elements) {
        super(type, null);
        this.start = start;
        this.end = end;
        this.elements = elements;
    }

    public Value run(int index) {
        if (index > elements.size() || index < 0)
            errors.add(new SemanticError("index out of bound", start, end));

        return elements.get(index).run();
    }

    @Override
    public Value run() {
        return this;
    }

    @Override
    public Object copy() {
        // deep copy
        List<AstExpr> copiedElements = new LinkedList<>();
        for (AstExpr e: elements) {
            copiedElements.add(e.run().selfCopy());
        }

        return new AstExprArrayInit(start, end, type, copiedElements);
    }

    @Override
    public Value selfCopy() {
        return (Value) copy();
    }

    @Override
    public void preIncrement() {

    }

    @Override
    public void preDecrement() {

    }

    @Override
    public void unaryMinus() {

    }

    @Override
    public void unaryPlus() {

    }

    @Override
    public void unaryBang() {

    }
}
