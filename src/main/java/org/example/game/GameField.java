package org.example.game;

public class GameField {
    public Cell[] cells;

    public GameField() {
        cells = new Cell[9];
        for (int i = 0;  i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i * 3 + j] = new Cell();
            }
        }
    }

    public boolean isOver() {
        return (cells[0].getValue() != '\0' && cells[0].getValue() == cells[1].getValue() && cells[0].getValue() == cells[2].getValue()) ||
                (cells[3].getValue() != '\0' && cells[3].getValue() == cells[4].getValue() && cells[3].getValue() == cells[5].getValue()) ||
                (cells[6].getValue() != '\0' && cells[6].getValue() == cells[7].getValue() && cells[6].getValue() == cells[8].getValue()) ||
                (cells[0].getValue() != '\0' && cells[0].getValue() == cells[3].getValue() && cells[0].getValue() == cells[6].getValue()) ||
                (cells[1].getValue() != '\0' && cells[1].getValue() == cells[4].getValue() && cells[1].getValue() == cells[7].getValue()) ||
                (cells[2].getValue() != '\0' && cells[2].getValue() == cells[5].getValue() && cells[2].getValue() == cells[8].getValue()) ||
                (cells[0].getValue() != '\0' && cells[0].getValue() == cells[4].getValue() && cells[0].getValue() == cells[8].getValue()) ||
                (cells[2].getValue() != '\0' && cells[2].getValue() == cells[4].getValue() && cells[2].getValue() == cells[6].getValue());
    }

    public boolean isEmptyCellExists() {
        for (Cell cell : cells) {
            if (cell.getValue() == '\0') {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                System.out.print("= = ");
            }
            System.out.println('=');
            for (int j = 0; j < 3; j++) {
                if (cells[i * 3 + j].getValue() != '\0') {
                    System.out.print("| " + cells[i * 3 + j].getValue() + " ");
                } else {
                    System.out.print("| " + "  ");
                }
            }
            System.out.println("|");
        }

        for (int k = 0; k < 3; k++) {
            System.out.print("= = ");
        }
        System.out.println('=');
    }
}
