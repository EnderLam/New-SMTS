package Commands;

public interface Command {
    public abstract void execute();
    public abstract void undo();
    public abstract void redo();
    public abstract String toString();
}
