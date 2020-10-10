package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

/**
 * extends AstVariable since a function is something like a variable (has an identifier, can return a value)
 */
public class AstFunctionDeclaration extends AstVariable {
    public AstFunctionBlock astFunctionBlock;
    public List<AstVariable> params;

    public AstFunctionDeclaration(Token start, Token end, Token identifier, SymbolTable st,
                                  AstFunctionBlock astFunctionBlock, List<AstVariable> params) {
        super(start, identifier, end);
        this.symbolTable = st;
        this.astFunctionBlock = astFunctionBlock;
        this.params = params;
    }

    @Override
    public Value run() {
        return null;
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        super.checkSemantic(errors);
        for (AstVariable param: params) {
            if (symbolTable.find(param.identifier.image) == null) {
                symbolTable.add(param.identifier.image, param);
            } else {
                String msg = String.format("'%s' is already defined in this function", param.identifier.image);
                errors.add(new SemanticError(msg, param.start, param.end));
            }
        }

        astFunctionBlock.checkSemantic(errors);
    }
}
