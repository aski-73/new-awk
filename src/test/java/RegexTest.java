import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    @Test
    public void testRegex() {
        String literal = "aa12aA";
        String regex1 = "([a-z])";
        String regex2 = "([12])";
        String regex3 = "([a-z12]|[12])";
        // WHEN
        Pattern p = Pattern.compile(regex1);
        Matcher m = p.matcher(literal);

        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(literal);

        Pattern p3 = Pattern.compile(regex3);
        Matcher m3 = p3.matcher(literal);

        // THEN
        System.out.println("");

        while (m3.find()) {
            String c = m3.group(0);
            System.out.println(m3.groupCount() + " " + c);
            System.out.println(m3.groupCount() + " " + c);
        }
    }
}
