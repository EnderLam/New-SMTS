package CommandsFactory;
import Commands.*;
import Teams.*;
import java.util.*;

public class CreateCommandFactory implements CommandFactory{
    private Scanner sc;
    public static Vector currentTeam;
    private Vector teams;
    private Stack commands;
    private TeamFactory volleyballTeamFactory;
    private TeamFactory footballTeamFactory;

    public CreateCommandFactory(Scanner sc, Vector currentTeam, Vector teams, Stack commands){
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.teams = teams;
        this.commands = commands;
        this.volleyballTeamFactory = new VolleyballTeamFactory();
        this.footballTeamFactory = new FootballTeamFactory();
    }

    public Command createCommand(){
        Command com = new CreateCommand(sc, currentTeam, teams, volleyballTeamFactory, footballTeamFactory);
        commands.push(com);
        return com;
    }
}
