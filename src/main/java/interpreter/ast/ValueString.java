package interpreter.ast;

public class ValueString extends Value {
    public ValueString(String value) {
        super(Type.STRING, value);
    }

    @Override
    public String copy() {
        return value + "";
    }

    @Override
    public void preIncrement() {
    }

    @Override
    public Value selfCopy() {
        return new ValueString(copy());
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
