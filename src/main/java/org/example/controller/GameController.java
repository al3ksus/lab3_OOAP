package org.example.controller;

import org.example.command.Command;
import org.example.command.NoCommand;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GameController {
    private final Command[] setXCommands;
    private final Command[] setOCommands;
    private final Stack<Command> undoCommands;

    public GameController() {
        setXCommands = new Command[9];
        setOCommands = new Command[9];
        undoCommands = new Stack<>();

        for (int i = 0; i < 9; i++) {
            setXCommands[i] = new NoCommand();
            setOCommands[i] = new NoCommand();
        }
    }

    public void setCommand(int cellNumber, Command setX, Command setO) {
        setXCommands[cellNumber] = setX;
        setOCommands[cellNumber] = setO;
    }

    public void onPlayerXMoving(int cellNumber) {
        setXCommands[cellNumber].execute();
        undoCommands.add(setXCommands[cellNumber]);
    }

    public void onPlayerOMoving(int cellNumber) {
        setOCommands[cellNumber].execute();
        undoCommands.add(setOCommands[cellNumber]);
    }

    public void undo() {
        Command command = undoCommands.pop();
        command.undo();
    }
}
