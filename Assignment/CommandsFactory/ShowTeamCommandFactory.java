package CommandsFactory;
import Commands.*;
import Teams.*;
import java.util.*;

public class ShowTeamCommandFactory implements CommandFactory{

    private Vector currentTeam;
    private Stack commands;

    public ShowTeamCommandFactory(Vector currentTeam, Stack commands){
        this.currentTeam = currentTeam;
        this.commands = commands;
    }
    
    public Command createCommand(){
        Command com = new ShowTeamCommand(currentTeam);
        return com;
    }
}
