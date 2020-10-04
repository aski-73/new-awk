package interpreter.ast;

import com.sun.jdi.DoubleValue;

public class ValueDouble extends Value {
    public ValueDouble(Double value) {
        super(Type.DOUBLE, value);
    }

    @Override
    public Value copy(Value v) {
        return null;
    }

    @Override
    public void preIncrement() {
        value = ((Double) value) + 1;
    }

    @Override
    public void preDecrement() {
        value = ((Double) value) - 1;
    }

    @Override
    public void unaryMinus() {
        value = ((Double) value) * (-1);
    }

    @Override
    public void unaryPlus() {

    }
}
