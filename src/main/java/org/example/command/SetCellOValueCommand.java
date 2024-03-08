package org.example.command;

import org.example.game.Cell;

public class SetCellOValueCommand implements Command {

    Cell cell;

    public SetCellOValueCommand(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void execute() {
        cell.setValue('O');
    }

    @Override
    public void undo() {
        cell.setValue('\0');
    }
}
