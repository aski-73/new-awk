package interpreter.ast;

public class ValueString extends Value {
    public ValueString(String value) {
        super(Type.STRING, value);
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
