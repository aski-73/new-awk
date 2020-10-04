package interpreter.ast;

public abstract class Value {
    public Object value;
    public Type type;

    public Value(Type type, Object value) {
        this.value = value;
        this.type = type;
    }

    public static Value parseValue(Type type, String v) {
        switch (type) {
            case INT:
            case CHAR:
                return new ValueInteger(Integer.parseInt(v));
            case DOUBLE:
                return new ValueDouble(Double.parseDouble(v));
            case BOOLEAN:
                return new ValueBoolean(Boolean.parseBoolean(v));
            default:
                return new ValueString(v);
        }
    }

    /**
     * Copy creates new Objects and not just a reference-copy
     * @param v Value to copy
     * @return copied values
     */
    public abstract  Value copy(Value v);

    public abstract void preIncrement();
    public abstract void preDecrement();
    public abstract void unaryMinus();
    public abstract void unaryPlus();
}
