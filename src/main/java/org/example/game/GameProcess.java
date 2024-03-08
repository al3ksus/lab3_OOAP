package org.example.game;

import org.example.controller.GameController;

import java.util.Scanner;

public class GameProcess {
    private GameController controller;
    private GameField field;

    private final Scanner scanner = new Scanner(System.in);
    public GameProcess(GameController controller, GameField field) {
        this.controller = controller;
        this.field = field;
    }

    public void start() {
        GameState state = GameState.IS_NOT_OVER;

        while(state.equals(GameState.IS_NOT_OVER)) {
            move('X');
            state = getResult();

            if (state.equals(GameState.IS_NOT_OVER)) {
                move('O');
                state = getResult();
                if (state.equals(GameState.WINNER)) {
                    field.print();
                    System.out.println("Winner: O");
                    break;
                }
            } else if (state.equals(GameState.WINNER)) {
                field.print();
                System.out.println("Winner: X");
                break;
            }
        }
        if (state.equals(GameState.DRAW)) {
            field.print();
            System.out.println("Draw :/");
        }
    }

    private void move(char player) {
        int x, y;
        field.print();
        System.out.println("To cancel a move, enter -1 -1");
        System.out.printf("Turn %s:\n", player);
        do {
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (x <= 0 || x > 3 || y <= 0 || y > 3) {
                if (x == -1 & y == -1) {
                    controller.undo();
                    return;
                }
                System.out.println("Wrong coordinates!");
            }
        } while(!(x > 0 && x <= 3 && y > 0 && y <= 3));

        if (player == 'X') {
            controller.onPlayerXMoving((x - 1) * 3 + (y - 1));
        } else {
            controller.onPlayerOMoving((x - 1) * 3 + (y - 1));
        }
    }

    private GameState getResult() {
        if (field.isOver()) {
            return GameState.WINNER;
        } else if (!field.isEmptyCellExists()) {
            return GameState.DRAW;
        } else {
            return GameState.IS_NOT_OVER;
        }
    }

    public GameController getController() {
        return controller;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }

    public GameField getField() {
        return field;
    }

    public void setField(GameField field) {
        this.field = field;
    }
}
