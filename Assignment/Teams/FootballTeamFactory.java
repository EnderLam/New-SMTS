package Teams;

import java.util.Scanner;

public class FootballTeamFactory implements TeamFactory {

    private Team currentTeam;

    public Team createTeam(Scanner sc) {
        System.out.print("Team ID: ");
        String teamID = sc.nextLine();
        System.out.print("Team Name: ");
        String teamName = sc.nextLine();
        FootballTeam footballTeam = new FootballTeam(teamID,sc);
        footballTeam.setName(teamName);
        currentTeam = footballTeam;
        return footballTeam;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }
}