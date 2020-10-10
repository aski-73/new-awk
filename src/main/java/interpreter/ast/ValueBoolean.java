package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

public class ValueBoolean extends Value {
    public ValueBoolean(Boolean value) {
        super(Type.BOOLEAN, value);
    }

    @Override
    public Boolean copy() {
        return Boolean.parseBoolean(value.toString());
    }

    @Override
    public Value selfCopy() {
        return new ValueBoolean(copy());
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

    @Override
    public void unaryBang() {
        value = !(Boolean) value;
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
        return 1;
    }
}
