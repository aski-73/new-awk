package interpreter.ast;

import interpreter.Token;
import interpreter.errors.CompilerError;

import java.util.List;

public class AstVariable extends AstExpr {
    public Token identifier;
    public AstExpr value;

    // if this is an array this variable counts its dimensions
    public int dimensions;

    // PARSER
    public AstVariable(Token type, Token identifier, Token end) {
        super(type, end);

        if (type != null)
            this.type = Type.parseType(type.image);

        this.identifier = identifier;
    }

    // INTERPRETER

    @Override
    public Value run() {
        return value.run();
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (value != null) {
            value.checkSemantic(errors);
            type = value.type;
            end = value.end;
        }
    }

    @Override
    public int length() {
        return run().length();
    }
}
