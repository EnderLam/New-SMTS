package CommandsFactory;
import Commands.*;
import Teams.*;
import java.util.*;

public class ChangeTeamNameCommandFactory implements CommandFactory {

    private Scanner sc;
    private Vector currentTeam;
    private Stack commands;

    public ChangeTeamNameCommandFactory(Scanner sc, Vector currentTeam, Stack commands){
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.commands = commands;
    }

    
    public Command createCommand(){
        Command com = new ChangeTeamNameCommand(sc, currentTeam);
        commands.push(com);
        return com;
    }
}
