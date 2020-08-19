import org.junit.Test;

public class NawkParserTest {
    private NawkParser testSubject;

    @Test
    public void testDeclarations() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("1_declaration_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testBlockDeclaration() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("2_block_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testBoolDeclaration() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("3_bool_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testArray() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("4_array_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testFunction() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("5_function_test.nawk"));
        testSubject.start();
    }


    @Test
    public void testDefinition() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("6_definition_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testSemantic() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("8_semantic_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testXString() {

    }
}