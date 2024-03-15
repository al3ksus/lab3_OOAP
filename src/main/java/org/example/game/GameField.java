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
        char value;
        //проверка по строкам
        for (int i = 0; i < 3; i++) {
            value = cells[i * 3].getValue();
            for (int j = 0; j < 3; j++) {
                if (cells[i * 3 + j].getValue() != value) {
                    break;
                }
                if (cells[i * 3 + j].getValue() == value && j == 2 && value != '\0') {
                    return true;
                }
            }
        }
        //проверка по столбцам
        for (int j = 0; j < 3; j++) {
            value = cells[j].getValue();
            for (int i = 0; i < 3; i++) {
                if (cells[i * 3 + j].getValue() != value) {
                    break;
                }
                if (cells[i * 3 + j].getValue() == value && i == 2 && value != '\0') {
                    return true;
                }
            }
        }
        //проверка по главной диагонали
        value = cells[0].getValue();
        for (int i = 0, j = 0; i < 3 && j < 3; i++, j++) {
            if (cells[i * 3 + j].getValue() != value) {
                break;
            }
            if (cells[i * 3 + j].getValue() == value && i == 2 && value != '\0') {
                return true;
            }
        }

        //проверка по второстепенной диагонали
        value = cells[2].getValue();
        for (int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
            if (cells[i * 3 + j].getValue() != value) {
                break;
            }
            if (cells[i * 3 + j].getValue() == value && i == 2 && value != '\0') {
                return true;
            }
        }

        return false;
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
