package interpreter.ast;

import interpreter.Token;

/**
 * extends AstVariable since a function is something like a variable (has an identifier, can return a value)
 */
public class AstFunctionDeclaration extends AstVariable {
    public SymbolTable st;
    public AstFunctionBlock astFunctionBlock;

    public AstFunctionDeclaration(Token start, Token end, Token identifier, SymbolTable st,
                                  AstFunctionBlock astFunctionBlock) {
        super(start, identifier, end);
        this.st = st;
        this.astFunctionBlock = astFunctionBlock;
    }

    @Override
    public Value run() {
        return null;
    }
}
