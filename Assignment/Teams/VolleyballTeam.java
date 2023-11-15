package Teams;

import java.util.Scanner;

public class VolleyballTeam extends Team {
    public static final int ATTACKER = 1;
    public static final int DEFENDER = 2;
    private Scanner sc;

    public VolleyballTeam(String teamID, Scanner sc) {
        super(teamID);
        this.sc = sc;
    }


    public void updatePlayerPosition() {
        System.out.println("Please input player ID: ");
        int playerID = sc.nextInt();
        System.out.println("Position (1 = attacker | 2 = defender ): ");
    }


    public void displayTeam() {
        System.out.println("Volleyball Team " + getName() + " ("  + getTeamID() + ")");

    }
}