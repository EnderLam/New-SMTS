package Commands;

import java.util.Scanner;
import java.util.Vector;

import Teams.Team;

public class ChangeTeamNameCommand implements Command {

    private Scanner sc;
    public static Vector<Team> currentTeam;
    private String previousName;
    private String newName;

    public ChangeTeamNameCommand(Scanner sc, Vector<Team> currentTeam) {
        this.sc = sc;
        this.currentTeam = currentTeam;
    }

    public void execute() {
        System.out.print("Please input new name of the current team:");
        newName = sc.nextLine();
        Team team = currentTeam.get(0); // Assuming only one current team is selected
        previousName = team.getName();
        team.setName(newName);
        System.out.println("Team's name is updated.");
    }

    public void undo() {
            Team team = currentTeam.get(0);
            System.out.println("Command (Change team’s name, " + team.getTeamID() + ", " + team.getName() + " )" + " is undone");
            team.setName(previousName);
        
    }

    public void redo() {
        Team team = currentTeam.get(0);
        System.out.println("Command (Change team’s name, " + team.getTeamID() + ", " + team.getName() + " )" + " is redone");
        team.setName(newName);
    }

    public String toString(){
        Team team = currentTeam.get(0);
        return "Change team’s name, " + team.getTeamID() + ", " + team.getName();
    }
}