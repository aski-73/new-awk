package interpreter.ast;

import interpreter.Token;

import java.util.List;

public class AstFunctionDeclaration extends AstNode {
    public Type returnType;
    public String name;
    public List<AstVariable> parameters;
    public AstFunctionBlock astFunctionBlock;

    public AstFunctionDeclaration(Token start, Token end, String name, List<AstVariable> parameters,
                                  AstFunctionBlock astFunctionBlock) {
        super(start, end);
        this.returnType = Type.parseType(start.image);
        this.name = name;
        this.parameters = parameters;
        this.astFunctionBlock = astFunctionBlock;
    }

    @Override
    public Object run() {
        return null;
    }
}
