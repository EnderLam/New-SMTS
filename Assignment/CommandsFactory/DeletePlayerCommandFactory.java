package CommandsFactory;
import Commands.*;
import Teams.*;
import java.util.*;


public class DeletePlayerCommandFactory implements CommandFactory {

    private Scanner sc;
    private Vector<Team> currentTeam;
    private List<Player> players;
    private Stack commands;

    public DeletePlayerCommandFactory(Scanner sc, Vector currentTeam, List<Player> players, Stack commands){
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.players = players;
        this.commands = commands;
    }
    
    public Command createCommand(){
        Command com = new DeletePlayerCommand(sc, currentTeam, players);
        commands.push(com);
        return com;
    }
}
