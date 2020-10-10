package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.LinkedList;
import java.util.List;

public class AstExprArrayInit extends Value {
    /**
     * Elements can be more array init expressions xor primitive types
     */
    public List<AstExpr> elements;

    public AstExprArrayInit parent;

    public int dimensions = 1;

    public AstExprArrayInit(Token start, Token end, Type type, List<AstExpr> elements, SymbolTable st) {
        super(type, null);
        this.start = start;
        this.end = end;
        this.elements = elements;
        // give array init an extra symbol table to store the "i" variable
        symbolTable = new SymbolTable(st);
    }

    public Value run(int index) {
        if (index > elements.size() || index < 0)
            throw new IndexOutOfBoundsException(String.format("you chose index '%s'. Your array has only '%s' elements.", index, elements.size()));

        return elements.get(index).run();
    }

    @Override
    public Value run() {
        return this;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        for (AstExpr e1 : elements) {
            e1.checkSemantic(errors);
            if (e1 instanceof AstExprArrayInit)
                ((AstExprArrayInit) e1).parent = this;
        }

        for (AstExpr e1 : elements) {
            for (AstExpr e2 : elements) {
                if (e1 instanceof AstExprArrayInit && !(e2 instanceof AstExprArrayInit)) {
                    errors.add(new SemanticError(String.format("incompatible array types '%s' and '%s'", e1.getClass().getName(), e2.getClass().getName()), e1.start, e2.end));
                    break;
                }
            }
        }

        // assign type of literal value
        if (elements.size() > 0)
            type = elements.get(0).run().type;
    }

    @Override
    public Object copy() {
        // deep copy
        List<AstExpr> copiedElements = new LinkedList<>();
        for (AstExpr e : elements) {
            copiedElements.add(e.run().selfCopy());
        }

        return new AstExprArrayInit(start, end, type, copiedElements, symbolTable);
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

    @Override
    public int length() {
        return elements.size();
    }
}
