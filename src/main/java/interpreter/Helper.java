package interpreter;

import interpreter.ast.AstExpr;
import interpreter.ast.Type;

public class Helper {
    public static boolean isPredefined(String functionName) {
        return functionName.equals("toDouble")
                || functionName.equals("toInteger")
                || functionName.equals("toChar")
                || functionName.equals("toBoolean")
                || functionName.equals("isDouble")
                || functionName.equals("isInteger")
                || functionName.equals("isChar")
                || functionName.equals("isBoolean")
                || functionName.equals("print")
                || functionName.equals("len");
    }


    public static boolean isNumeric(Type type) {
        return type == Type.INT || type == Type.CHAR || type == Type.DOUBLE;
    }

    public static Type determineTypeBase(Type t1, Type t2) {
        if (t1 == null || t2 == null)
            return Type.ERROR;

        if (t1.ordinal() > Type.STRING.ordinal() || t2.ordinal() > Type.STRING.ordinal()) // error or void
            return Type.ERROR;

        if (t1 == Type.STRING || t2 == Type.STRING) // convert to string
            return Type.STRING;

        if ((t1 == Type.BOOLEAN && t2 != Type.BOOLEAN) || (t2 == Type.BOOLEAN && t1 != Type.BOOLEAN)) // only boolean with boolean
            return Type.ERROR;

        if (t1 == Type.BOOLEAN && t2 == Type.BOOLEAN)
            return Type.BOOLEAN;

        // Otherwise numeric values

        //   OP   # char   # int #  double
        //  # # # # # # # # # # # # # # # #
        // char   # int      int    double
        // int    # int      int    double
        // double ä double  double  double
        if (t1 == Type.DOUBLE || t2 == Type.DOUBLE) return Type.DOUBLE;

        return Type.INT;
    }

    public static Type validateTypes(AstExpr left, AstExpr right, Token op) {
        if (right == null || op == null) // no point in type checking if no right expression exists
            return left.type;

        return determineTypeBase(left.type, right.type);
    }

    /**
     * Check types for && (AND) and || (OR)
     * Conditional operation is only allowed between boolean values
     */
    public static Type validateTypesForConditionalOp(Type left, Type right, Token op) {
        if (right == null || op == null) // no point in type checking if no right expression exists
            return left;

        // Only allowed between boolean types
        if (left != Type.BOOLEAN || right != Type.BOOLEAN) {
            System.out.printf("Bad operator '%s' between types '%s' and '%s'.%n", op.image, left, right);
            return Type.ERROR;
        }

        return Type.BOOLEAN;
    }

    /**
     * int/double/char/boolean/string + string is allowed
     * int/double/char/boolean/string - string is  not allowed
     * int/double/char/boolean +/- boolean is not allowed
     */
    public static Type validateTypesForAdditiveOp(AstExpr left, AstExpr right, Token op) {
        if (right == null || op == null) // no point in type checking if no right expression exists
            return left.type;

        if (left.type == Type.ERROR || right.type == Type.ERROR) {
            System.out.printf("Invalid Types '%s' '%s' %n", left.type, right.type);
            return Type.ERROR;
        }

        if (isNumeric(left.type) && isNumeric(right.type)) { // ok
            return determineTypeBase(left.type, right.type);
        } else if (left.type == Type.STRING || right.type == Type.STRING) { // Addition with String => Concat
            if (op.image == "+")
                return Type.STRING;
            else {
                System.out.printf("Subtraction between '%s' and '%s' is not allowed%n", left.type, right.type);
                return Type.ERROR;
            }
        } else { // boolean with numerics or boolean with boolean
            System.out.printf("Bad operator '%s' between types '%s' and '%s'.%n", op.image, left.type, right.type);
            System.out.println("Addition/Subtraction between numeric values and boolean or boolean with boolean is not allowed");
            return Type.ERROR;
        }
    }
}
