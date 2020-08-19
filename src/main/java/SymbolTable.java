import java.util.HashMap;

/**
 * Mapping von Datentypen
 */
public class SymbolTable {
    public HashMap<String, String> table = new HashMap<>();
    public SymbolTable parent = null;

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    public void add(String id, String t) {
        if (find(id) == null) {
            table.put(id, t);
        } else {
            System.out.println(String.format("Die Variable '%s' ist schon deklariert.", id));
        }
    }

    public String find(String id) {
        // erst lokal schauen
        if (table.containsKey(id)) {
            return table.get(id);
        }

        // parent fragen, wenn vorhanden
        if (parent != null) {
            return parent.find(id);
        }
        return null;
    }
}
