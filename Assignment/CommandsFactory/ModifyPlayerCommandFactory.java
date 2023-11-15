package CommandsFactory;
import Commands.*;
import Teams.*;
import java.util.*;
public class ModifyPlayerCommandFactory implements CommandFactory {
    private Scanner sc;
    private List<Player> players;
    private Player player;
    private Vector<Team> currentTeam;
    private Stack commands;

    public ModifyPlayerCommandFactory(Scanner sc, List<Player> players, Player player, Vector currentTeam, Stack commands){
        this.sc = sc;
        this.players = players;
        this.player = player;
        this.currentTeam = currentTeam;
        this.commands = commands;
    }

    public Command createCommand(){
        Command com = new ModifyPlayerCommand(sc, players, player, currentTeam);
        commands.push(com);
        return com;
    }
}
