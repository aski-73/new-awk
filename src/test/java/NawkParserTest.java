import interpreter.ast.AstNode;
import interpreter.ast.AstRoot;
import interpreter.errors.CompilerError;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import interpreter.NawkParser;
import interpreter.ParseException;

import java.util.LinkedList;
import java.util.List;

public class NawkParserTest {
    private NawkParser testSubject;

    @Test
    public void parseDeclarationsWithValidDeclarations() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("1_declaration_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        Assertions.assertThat(nodes.size()).isEqualTo(9);
        Assertions.assertThat(nodes.get(5).run().value).isEqualTo('A');
    }

    @Test
    public void parseDeclarationsReturnsSemanticErrors() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("1a_declaration_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        root.run();
        Assertions.assertThat(errors.size()).isEqualTo(2);
    }

    @Test
    public void testBlockDeclaration() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("2_block_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testBoolDeclaration() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("3_bool_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testArray() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("4_array_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testArray2() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("4a_array_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testFunction() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("5_function_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        root.run();
        for (CompilerError err: errors) {
            System.out.println(err.toString());
        }
    }


    @Test
    public void testDefinition() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("6_definition_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        List<AstNode> nodes = root.subtrees;
        Assertions.assertThat(nodes.size()).isEqualTo(13);
        Assertions.assertThat(nodes.get(0).run().value).isEqualTo(8);
        Assertions.assertThat(nodes.get(1).run().value).isEqualTo(2);
        Assertions.assertThat(nodes.get(3).run().value).isEqualTo(true);
        Assertions.assertThat(nodes.get(4).run().value).isEqualTo(true);
        Assertions.assertThat(nodes.get(5).run().value).isEqualTo(true);
        Assertions.assertThat(nodes.get(6).run().value).isEqualTo(false);
        Assertions.assertThat(nodes.get(8).run().value).isEqualTo("Hallo dies ist ein String äüö AÄÜÖ +_/% .;:???");
        Assertions.assertThat(nodes.get(9).run().value).isEqualTo("Hallo dies ist ein String äüö AÄÜÖ +_/% .;:??? Concatenation");
        Assertions.assertThat(nodes.get(10).run().value).isEqualTo(3.14);
    }

    @Test
    public void testDefinition2() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("6a_definition_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        Assertions.assertThat(nodes.size()).isEqualTo(4);
        Assertions.assertThat(nodes.get(0).run().value).isEqualTo(8);
        Assertions.assertThat(nodes.get(1).run().value).isEqualTo(2);
        Assertions.assertThat(nodes.get(2).run().value).isEqualTo(true);
        Assertions.assertThat(nodes.get(3).run().value).isEqualTo(false);
    }

    @Test
    public void testDefinition3() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("6b_definition_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        List<AstNode> nodes = root.subtrees;
        root.checkSemantic(errors);
        Assertions.assertThat(nodes.get(0).run().value).isEqualTo(3.14);
    }

    @Test
    public void testStringOp() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("7_string-op_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<CompilerError>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testSemantic() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("8_semantic_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        Assertions.assertThat(errors.size()).isEqualTo(5);
    }

    @Test
    public void testPrintStatement() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("9_print_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testSyntaxErrorHandling() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("10_syntax_error_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        if (testSubject.globalErrors.size() > 0) {
            System.out.println("Program can not be executed. Check out errors");
        }
    }

    @Test
    public void testWhileStatement() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("11_while_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testIfStatement() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("12_if_test.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void test() throws ParseException {
        testSubject = new NawkParser(this.getClass().getResourceAsStream("testfile_.nawk"));
        LinkedList<CompilerError> errors = new LinkedList<>();
        AstRoot root = testSubject.start();
        root.checkSemantic(errors);
        root.run();
    }

    @Test
    public void testMain() throws ParseException {
        NawkParser.main(new String[0]);
    }
}