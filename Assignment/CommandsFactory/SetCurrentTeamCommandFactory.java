package CommandsFactory;

import Commands.*;
import Teams.*;
import java.util.*;

public class SetCurrentTeamCommandFactory implements CommandFactory {

    private Scanner sc;
    private Vector<Team> teams;
    private Vector currentTeam;
    private Stack<Command> commands;

    public SetCurrentTeamCommandFactory(Scanner sc, Vector currentTeam, Vector<Team> teams, Stack<Command> commands) {
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.teams = teams;
        this.commands = commands;
    }

    public Command createCommand() {
        Command com = new SetCurrentTeamCommand(sc, currentTeam, teams);
        commands.push(com);
        return com;
    }
}