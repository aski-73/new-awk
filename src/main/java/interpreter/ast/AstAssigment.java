package interpreter.ast;

import interpreter.Helper;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.List;

public class AstAssigment extends AstExpr {
    public Token identifier;
    public AstExpr right;
    public SymbolTable symbolTable;
    public AstVariable declaration;

    // PARSER

    public AstAssigment(Token start, Token end, Token identifier, AstExpr val, SymbolTable symbolTable) {
        super(start, end);
        this.identifier = identifier;
        this.right = val;
        this.symbolTable = symbolTable;
    }

    // INTERPRETER

    public Value run() {
        AstVariable var = symbolTable.find(identifier.image);
        if (var != null) {
            var.value = right.run().selfCopy();
            return (Value) var.value;
        }

        return new ValueInteger(0);
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        right.checkSemantic(errors);

        declaration = symbolTable.find(identifier.image);
        if (declaration == null) {
            errors.add(new SemanticError(String.format("variable '%s' is not defined;", identifier)));
            return;
        }

        // first check if invalid types
        Type typeBase = Helper.determineTypeBase(declaration.type, right.type);

        // all types can implicitly be assigned to a type whose ordinal value is higher or equal, but not lower
        if (typeBase == Type.ERROR || declaration.type.ordinal() < right.type.ordinal()) {
            right.type = Type.ERROR;
            String msg = String.format("invalid types between '%s' and '%s'. Make sure that your variable is initialized.", declaration.type.name(), right.type);
            errors.add(new SemanticError(msg, start, end));
        }
    }

    @Override
    public int length() {
        return run().length();
    }
}
