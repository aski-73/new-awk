package ast;

import java.util.HashMap;

public class SymbolTable {
    public HashMap<String, String> table = new HashMap<>();
    public SymbolTable parent;

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    public void add(String id, String t) {
        if (find(id) == null) {
            table.put(id, t);
        } else {
            System.out.printf("Variable '%s' is already declared.%n", id);
        }
    }

    public String find(String id) {
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
}
