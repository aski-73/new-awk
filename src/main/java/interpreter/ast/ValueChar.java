package interpreter.ast;

public class ValueChar extends Value {
    public ValueChar(Character value) {
        super(Type.CHAR, value);
    }

    @Override
    public Value copy(Value v) {
        return null;
    }

    @Override
    public void preIncrement() {
        value = (Character) value + 1;
    }

    @Override
    public void preDecrement() {
        value = (Character) value - 1;
    }

    @Override
    public void unaryMinus() {
        value = (Character) value *  -1;

    }

    @Override
    public void unaryPlus() {

    }
}
