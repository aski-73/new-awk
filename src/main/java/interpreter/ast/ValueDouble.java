package interpreter.ast;

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
}
