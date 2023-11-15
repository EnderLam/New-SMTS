package CommandsFactory;

import Commands.*;
import Teams.*;
import java.util.*;

public class AddPlayerCommandFactory implements CommandFactory {

    private Scanner sc;
    private Vector currentTeam;
    private PlayerFactory playerFactory;
    private List<Player> players;
    private Stack<Command> commands;

    public AddPlayerCommandFactory(Scanner sc, Vector currentTeam, PlayerFactory playerFactory, List<Player> players, Stack<Command> commands) {
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.playerFactory = playerFactory;
        this.players = players;
        this.commands = commands;
    }

    public Command createCommand() {
        Command com = new AddPlayerCommand(sc, currentTeam, playerFactory, players);
        commands.push(com);
        return com;
    }
}