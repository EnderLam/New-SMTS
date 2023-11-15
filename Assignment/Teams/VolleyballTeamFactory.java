package Teams;

import java.util.Scanner;

public class VolleyballTeamFactory implements TeamFactory {

    private Team currentTeam;

    public Team createTeam(Scanner sc) {
        System.out.print("Team ID: ");
        String teamID = sc.nextLine();
        System.out.print("Team Name: ");
        String teamName = sc.nextLine();
        VolleyballTeam volleyballTeam = new VolleyballTeam(teamID,sc);
        volleyballTeam.setName(teamName);
        currentTeam = volleyballTeam;
        return volleyballTeam;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }
}