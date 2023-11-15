package Commands;

import java.util.*;

public class UndoRedoListCommand implements Command {
    private Stack<Command> commands;
    private Stack<Command> redos;
    private List<String> executedCommands;

    public UndoRedoListCommand(Stack<Command> commands, Stack<Command> redos) {
        this.commands = commands;
        this.redos = redos;
    }

    public void execute() {
        executedCommands = new ArrayList<>();
        System.out.println("Undo List:");
        for (Command command : commands) {
            executedCommands.add(command.toString());
            System.out.println("[" + command.toString() + "]"); // Format and print command
        }

        System.out.println("Redo List:");
        for (Command redo : redos) {
            executedCommands.add(redo.toString());
            System.out.println("[" + redo.toString() + "]"); // Format and print redo command
        }
    }

    public void undo() {

    }

    public void redo() {

    }
}