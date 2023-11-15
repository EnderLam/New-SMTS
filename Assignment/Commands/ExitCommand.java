package Commands;

public class ExitCommand implements Command{

    public void execute(){
        System.out.println("Exiting system...");
        System.exit(0);
    }
    public void undo(){

    }
    public void redo(){

    }
}
