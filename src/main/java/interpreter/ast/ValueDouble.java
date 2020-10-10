package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

public class ValueDouble extends Value {
    public ValueDouble(Double value) {
        super(Type.DOUBLE, value);
    }

    @Override
    public Double copy() {
        return Double.parseDouble(value.toString());
    }

    @Override
    public Value selfCopy() {
        return new ValueDouble(copy());
    }

    @Override
    public void preIncrement() {
        value = (Double) value + 1;
    }

    @Override
    public void preDecrement() {
        value = (Double) value - 1;
    }

    @Override
    public void unaryMinus() {
        value = (Double) value * (-1);
    }

    @Override
    public void unaryPlus() {

    }

    @Override
    public void unaryBang() {

    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {

    }

    @Override
    public int length() {
        return ((Number) value).intValue();
    }
}
