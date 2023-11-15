package Commands;

import java.util.Scanner;
import java.util.Vector;

import Teams.Team;
import Teams.TeamFactory;

public class CreateCommand implements Command {
    private Scanner sc;
    private Vector teams;
    public static Vector currentTeam;
    private TeamFactory volleyballTeamFactory;
    private TeamFactory footballTeamFactory;
    private Team lastCreatedTeam;
    private String sportType;
    private String previousName;

    public CreateCommand(Scanner sc, Vector currentTeam, Vector teams, TeamFactory volleyballTeamFactory, TeamFactory footballTeamFactory) {
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.teams = teams;
        this.volleyballTeamFactory = volleyballTeamFactory;
        this.footballTeamFactory = footballTeamFactory;
    }

    public void execute() {
        System.out.print("Enter sport type (v = volleyball | f = football) : ");
        sportType = sc.nextLine();
        currentTeam.clear();
        if (sportType.equals("v")) {
            Team volleyballTeam = volleyballTeamFactory.createTeam(sc);
            teams.add(volleyballTeam);
            System.out.println("Volleyball team is created!");
            System.out.println("Current team is changed to " + volleyballTeam.getTeamID() + ".");
            currentTeam.add(volleyballTeam);
            lastCreatedTeam = volleyballTeam;
            previousName = volleyballTeam.getName();
        } else if (sportType.equals("f")) {
            Team footballTeam = footballTeamFactory.createTeam(sc);
            teams.add(footballTeam);
            System.out.println("Football team is created!");
            System.out.println("Current team is changed to " + footballTeam.getTeamID() + ".");
            currentTeam.add(footballTeam);
            lastCreatedTeam = footballTeam;
            previousName = footballTeam.getName();
        } else {
            System.out.println("Invalid sport type.");
        }
    }

    public void undo() {
        if(sportType.equals("v")) {
        System.out.println("Command (Create volleyball team " + lastCreatedTeam.getTeamID() + " " + lastCreatedTeam.getName() + " )" + " is undone");
        }else if (sportType.equals("f")){
        System.out.println("Command (Create football team " + lastCreatedTeam.getTeamID() + " " + lastCreatedTeam.getName() + " )" + " is undone");
        }
        teams.remove(lastCreatedTeam);
        currentTeam.remove(lastCreatedTeam);
    }

    public void redo() {
        teams.add(lastCreatedTeam);
        currentTeam.add(lastCreatedTeam);
        if(sportType.equals("v")) {
            System.out.println("Command (Create volleyball team " + lastCreatedTeam.getTeamID() + " " + lastCreatedTeam.getName() + " )" + " is redone");
        }else if (sportType.equals("f")){
            System.out.println("Command (Create football team " + lastCreatedTeam.getTeamID() + " " + lastCreatedTeam.getName() + " )" + " is redone");
            }
    }

    public String toString(){
        if(sportType.equals("v")) {
            return "Create volleyball team, " + lastCreatedTeam.getTeamID() + ", " + previousName;
        }else if (sportType.equals("f")){
            return "Create volleyball team, " + lastCreatedTeam.getTeamID() + ", " + previousName;
    }else{
        return "Unknown sport type";
    }
}

    // public Team findTeamByID(String teamID) {
    //     for (Object team : teams) {
    //         Team currentTeam = (Team) team;
    //         if (currentTeam.getTeamID().equals(teamID)) {
    //             return currentTeam;
    //         }
    //     }
    //     return null;
    // }
}
