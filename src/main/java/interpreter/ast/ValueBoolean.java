package interpreter.ast;

public class ValueBoolean extends Value {
    public ValueBoolean(Boolean value) {
        super(Type.BOOLEAN, value);
    }

    @Override
    public Value copy(Value v) {
        return null;
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

}
