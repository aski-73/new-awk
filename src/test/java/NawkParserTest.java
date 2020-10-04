import interpreter.ast.AstNode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import interpreter.NawkParser;
import interpreter.ParseException;

import java.util.List;

public class NawkParserTest {
    private NawkParser testSubject;

    @Test
    public void parseDeclarationsWithValidDeclarations() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("1_declaration_test.nawk"));
        List<AstNode> nodes = testSubject.start();
        Assertions.assertThat(nodes.size()).isEqualTo(6);
    }

    @Test
    public void parseDeclarationsReturnsSemanticErrors() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("1a_declaration_test.nawk"));
        List<AstNode> nodes = testSubject.start();
        Assertions.assertThat(nodes.size()).isEqualTo(6);
        // variable 'do' already defined
        Assertions.assertThat(nodes.get(1).errors.size()).isEqualTo(1);
        // int can not contain a string
        Assertions.assertThat(nodes.get(2).errors.size()).isEqualTo(1);
        // implicit string conversion
        Assertions.assertThat(nodes.get(3).run()).isEqualTo("5");
        //
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
    public void testStringOp() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("7_string-op_test.nawk"));
        testSubject.start();
    }

    @Test
    public void testSemantic() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("8_semantic_test.nawk"));
        testSubject.start();
    }
}