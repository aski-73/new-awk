package interpreter;

public class Helper {
    public static boolean isPredefined(String functionName) {
        return functionName.equals("toDouble")
                || functionName.equals("toInt")
                || functionName.equals("toChar")
                || functionName.equals("toBoolean")
                || functionName.equals("isDouble")
                || functionName.equals("isInt")
                || functionName.equals("isChar")
                || functionName.equals("isBoolean")
                || functionName.equals("print")
                || functionName.equals("this");
    }
}
