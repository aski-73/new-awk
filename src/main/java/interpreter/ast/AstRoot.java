package interpreter.ast;

import interpreter.Token;

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
        return null;
    }
}
