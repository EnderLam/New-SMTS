package CommandsFactory;

import Commands.*;
import Teams.*;
import java.util.*;


public class DisplayAllTeamCommandFactory implements CommandFactory {
    private Vector<Team> teams;
    private Stack<Command> commands;

    public DisplayAllTeamCommandFactory(Vector<Team> teams, Stack<Command> commands) {
        this.teams = teams;
        this.commands = commands;
    }

    public Command createCommand() {
        Command com = new DisplayAllTeamCommand(teams);
        return com;
    }
}