import org.junit.Test;

import static interpreter.ast.AstEasyRegexCustom.generateName;

public class GenerateNametest {
    @Test
    public void test() {
        String name = generateName();
        System.out.println(name);
    }
}
