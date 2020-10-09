package interpreter.ast;

public class ValueInteger extends Value {
    public ValueInteger(Integer value) {
        super(Type.INT, value);
    }

    @Override
    public Integer copy() {
        return Integer.parseInt(value.toString());
    }

    @Override
    public Value selfCopy() {
        return new ValueInteger(copy());
    }

    @Override
    public void preIncrement() {
        value = (Integer) value + 1;
    }

    @Override
    public void preDecrement() {
        value = (Integer) value - 1;
    }

    @Override
    public void unaryMinus() {
        value = (Integer) value * (-1);
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
}
