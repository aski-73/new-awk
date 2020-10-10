package interpreter.ast;

import java.util.HashMap;

public class SymbolTable {
    /**
     * Key: Identifier
     * Value: AstVariable: Definition of the whole variable. Variable value may be null, if not assigned yet
     */
    public HashMap<String, AstVariable> table = new HashMap<>();
    public SymbolTable parent;

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    public void add(String id, AstVariable t) {
        if (find(id) == null) {
            table.put(id, t);
        }
    }

    public AstVariable find(String id) {
        // local query
        if (table.containsKey(id)) {
            return table.get(id);
        }

        // ask parent
        if (parent != null) {
            return parent.find(id);
        }
        return null;
    }

    public void removeValue(String id) {
        table.remove(id);
    }
}
