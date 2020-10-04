package interpreter.ast;

public enum Type {
    INT("int"),
    DOUBLE("double"),
    CHAR("char"),
    STRING("string"),
    BOOLEAN("boolean"),
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
