package interpreter.ast;

import interpreter.errors.CompilerError;

import java.util.List;

public class ValueChar extends Value {
    public ValueChar(Character value) {
        super(Type.CHAR, value);
    }

    @Override
    public Character copy() {
        // primitive type. no reference
        return (char) value;
    }

    @Override
    public Value selfCopy() {
        return new ValueChar(copy());
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

    @Override
    public void unaryBang() {

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
        return 2;
    }
}
