package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.LinkedList;
import java.util.List;

public class AstRoot extends AstNode {
    public List<AstNode> subtrees;
    public SymbolTable symbolTable;

    public AstRoot(List<AstNode> subtrees, SymbolTable symbolTable) {
        this.subtrees = subtrees;
        this.symbolTable = symbolTable;
    }

    public AstRoot(Token start, Token end, List<AstNode> subtrees, SymbolTable symbolTable) {
        super(start, end);
        this.subtrees = subtrees;
        this.symbolTable = symbolTable;
    }

    @Override
    public Value run() {
        for (AstNode tree: subtrees)
            tree.run();

        return new ValueBoolean(true);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        for (AstNode tree: subtrees)
            tree.checkSemantic(errors);
    }
}
