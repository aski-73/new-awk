package interpreter.ast;

/**
 * Every type can be implicitly converted into a string.
 * An enum value has an ordinal value. If ones ordinal value is lower than that of a string
 * it will be converted into a string if a conversion is needed
 */
public enum Type {
    BOOLEAN("boolean"),
    CHAR("char"),
    INT("int"),
    DOUBLE("double"),
    STRING("string"),
    ERROR("error"),
    VOID("void");

    Type(String type) {
    }

    public static Type parseType(String type) {
        switch (type) {
            case "int":
                return INT;
            case "double":
                return DOUBLE;
            case "char":
                return CHAR;
            case "boolean":
                return BOOLEAN;
            case "string":
                return STRING;
            default:
                return VOID;
        }
    }
}
