package interpreter.ast;

import interpreter.NawkParserConstants;
import interpreter.Token;
import interpreter.errors.CompilerError;
import interpreter.errors.SemanticError;

import java.util.*;

public class AstExprArrayCall extends AstExpr {
    public AstExprArrayInit declaration;
    /**
     * Function parameters. Can be variables, can be expressions
     */
    private List<AstExpr> indices;
    private AstExpr identifier;

    public AstExprArrayCall(Token start, Token end, AstExprArrayInit declaration, List<AstExpr> indices, AstExpr identifier, SymbolTable st) {
        super(start, end);
        this.declaration = declaration;
        this.indices = indices;
        this.identifier = identifier;
        this.symbolTable = st;
    }

    @Override
    public Value run() {
        if (declaration == null) {
            return new ValueInteger(0);
        }

        // Result of array access with boolean expression (result is an array)
        List<AstExpr> result = new LinkedList<>();

        // temp result of array access. Can be either a further array or a literal
        AstExpr resultN = declaration;

        // contains for each dimension an entry which points to the current index in the dimension
        AstExpr[] iValues = new AstExpr[indices.size()];
        // "i[k]" points to the current index in the iteration of dimension k [For Test: k is limited to 2]
        Token i = Token.newToken(NawkParserConstants.INTEGER, Type.INT.name());
        Token id2 = Token.newToken(NawkParserConstants.Ident, "i");
        AstExprArrayInit iArray = new AstExprArrayInit(start, end, Type.INT, null, symbolTable);
        AstVariable iVar = new AstVariable(i, id2, end);
        iVar.type = Type.INT;
        iVar.value = iArray;

        for (int k = 0; k < indices.size(); k++) {
            symbolTable.add("i", iVar);
            // Special array call if the indices are boolean expressions
            if (indices.get(k) instanceof AstExprEquality) {
                // special array call can only be used on array. The case when resultN was over written in the else if
                if (resultN instanceof AstExprArrayInit) {
                    AstExprEquality e = (AstExprEquality) indices.get(k);
                    for (int j = 0; j < ((AstExprArrayInit) resultN).elements.size(); j++) { // create in each iteration new pointer variables
                        // eval expression and set the pointer variables (i[k] and this)
                        // pointer variables needs to be reset in each iteration
                        symbolTable.removeValue("this");

                        // "this" points to the current element
                        Token t = Token.newToken(NawkParserConstants.anything, type.name());
                        Token id = Token.newToken(NawkParserConstants.Ident, "this");
                        AstVariable thisVar = new AstVariable(t, id, id);
                        thisVar.value = ((AstExprArrayInit) resultN).elements.get(j);
                        symbolTable.add("this", thisVar);

                        // if the user uses i[0] (k=0) the value will be in this iteration like the counter j;
                        iValues[k] = new ValueInteger(j);
                        iArray.elements = Arrays.asList(iValues.clone());

                        // trigger semantic analysis anew since new values were added to the symbol table
                        e.checkSemantic(Collections.emptyList());
                        // execute the boolean expression
                        if ((Boolean) e.run().value) {
                            result.add(((AstExprArrayInit) resultN).run(j));
                        }
                    }
                    // result of bool-array-index-call is an array
                    resultN = new AstExprArrayInit(start, end, type, result, symbolTable);
                }
                // remove i because its only needed in this scope
                symbolTable.removeValue("i");
            } else if (indices.get(k) instanceof AstExprUnary) { // "normal" index access via integer (nested in AstExprUnary)
                if ((resultN instanceof AstExprArrayInit)) {
                    resultN = ((AstExprArrayInit) resultN).run((Integer) indices.get(k).run().value);
                }
            } else {
                throw new RuntimeException(String.format("Invalid array index '%s'.", indices.get(k).toString()));
            }
        }

        return resultN.run();
    }

    @Override
    public void checkSemantic(List<CompilerError> errors) {
        if (!(identifier instanceof AstLiteralIdent)) {
            String msg = String.format("'%s' is not an array", identifier.toString());
            errors.add(new SemanticError(msg, start, end));
        } else {
            String i = ((AstLiteralIdent) identifier).identifier.image;
            if (symbolTable.find(i) != null) {
                if (symbolTable.find(i).value instanceof AstExprUnary) { // call via array[]
                    AstExprPrimary ap = (AstExprPrimary) ((AstExprUnary) symbolTable.find(i).value).expr;
                    declaration = ((AstExprArrayCall) ap.suffix).declaration;
                } else if (symbolTable.find(i).value instanceof AstExprStringOp) { // Array init through string op
                    declaration = (AstExprArrayInit) symbolTable.find(i).value.run();
                } else {  // Not a call. Array Init {1, 2, 3} etc.
                    declaration = (AstExprArrayInit) symbolTable.find(i).value;
                }
                type = declaration.type;
            } else {
                String msg = String.format("array '%s' is not declared", i);
                errors.add(new SemanticError(msg, start, end));
            }

            // "this" and "i[k]" are reserved identifiers
            if (i.equals("this") && declaration != null) {
                type = declaration.type;
            }

            if (i.equals("i")) {
                type = Type.INT;
            }
        }
    }

    @Override
    public String toString() {
        return "array call: " + declaration.start.image;
    }

    @Override
    public int length() {
        return run().length();
    }
}
