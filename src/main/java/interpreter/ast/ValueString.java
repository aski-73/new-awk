package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

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

    @Override
    public String toString() {
        return (String) value;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {

    }

    @Override
    public int length() {
        return value.toString().length();
    }
}
