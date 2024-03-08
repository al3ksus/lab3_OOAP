package org.example.game;

public class Cell {

    private int rowNumber;
    private int columnNumber;

    private char value;
    public Cell() {}

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
