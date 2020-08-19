package ast;

public class Variable extends Node {
    public String identifier;
    public String value;
    public Variable(String identifier, String value) {
        this.identifier = identifier;
        this.value = value;
    }
}
