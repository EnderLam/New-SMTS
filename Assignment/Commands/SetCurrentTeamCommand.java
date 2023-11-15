package Commands;

import java.util.Scanner;
import java.util.Vector;

import Teams.Team;

public class SetCurrentTeamCommand implements Command {

    private Scanner sc;
    private Vector<Team> teams;
    public static Vector<Team> currentTeam;
    private Team previousTeam;

    public SetCurrentTeamCommand(Scanner sc, Vector<Team> currentTeam, Vector<Team> teams){
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.teams = teams;
    }

    public void execute(){
        previousTeam = currentTeam.get(0);
        System.out.print("Enter team ID: ");
        String teamID = sc.nextLine();
        boolean teamFound = false;
        for (Team team : teams) {
            if (team.getTeamID().equals(teamID)){
                this.currentTeam.clear();
                this.currentTeam.add(team);
                System.out.println("Current team set to: " + team.getName());
                teamFound = true;
                break;
            }
        }
        if (!teamFound) {
            System.out.println("Team not found.");
        }
    }
    
    public void undo(){
        currentTeam.clear();
        currentTeam.add(previousTeam);
        System.out.println("Current team has been reverted to: " + previousTeam.getName());
    }
    public void redo(){
        execute();
    }
}