package org.example.command;

import org.example.game.Cell;

public class SetCellXValueCommand implements Command {

    Cell cell;
    public SetCellXValueCommand(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void execute() {
        cell.setValue('X');
    }

    @Override
    public void undo() {
        cell.setValue('\0');
    }
}
