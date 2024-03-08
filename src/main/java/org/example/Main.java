package org.example;

import org.example.command.SetCellOValueCommand;
import org.example.command.SetCellXValueCommand;
import org.example.controller.GameController;
import org.example.game.GameField;
import org.example.game.GameProcess;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        GameController controller = new GameController();
        GameField field = new GameField();

        for (int i = 0; i < size * size; i++) {
            controller.setCommand(
                    i,
                    new SetCellXValueCommand(field.cells[i]),
                    new SetCellOValueCommand(field.cells[i]));
        }

        GameProcess game = new GameProcess(controller, field);
        game.start();
    }
}