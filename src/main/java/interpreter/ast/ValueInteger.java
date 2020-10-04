package interpreter.ast;

public class ValueInteger extends Value {
    public ValueInteger(Integer value) {
        super(Type.INT, value);
    }

    @Override
    public Value copy(Value v) {
        return null;
    }

    @Override
    public void preIncrement() {
        value = ((Integer) value) + 1;
    }

    @Override
    public void preDecrement() {
        value = ((Integer) value) - 1;
    }

    @Override
    public void unaryMinus() {
        value = ((Integer) value) * (-1);
    }

    @Override
    public void unaryPlus() {

    }
}
