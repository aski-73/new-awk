package interpreter.ast;

public abstract class Value extends AstExpr {
    public Object value;

    public Value(Type type, Object value) {
        // no need to save start and end token because the attributes type and value have all information
        super(null, null, type);
        this.value = value;
    }

    public static Value parseValue(Type type, String v) {
        switch (type) {
            case CHAR:
                return new ValueChar((char) Integer.parseInt(v));
            case INT:
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
     * @return copied value
     */
    public abstract Object copy();

    /**
     * Copy creates a copy of it self
     * @return copied value
     */
    public abstract Value selfCopy();

    public abstract void preIncrement();
    public abstract void preDecrement();
    public abstract void unaryMinus();
    public abstract void unaryPlus();
    public abstract void unaryBang();

    @Override
    public Value run() {
        return this;
    }
}
