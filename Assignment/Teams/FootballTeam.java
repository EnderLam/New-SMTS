package Teams;

import java.util.Scanner;

public class FootballTeam extends Team {
    public static final int GOALKEEPER = 1;
    public static final int DEFENDER = 2;
    public static final int MIDFIELDER = 3;
    public static final int FORWARD = 4;
    private Scanner sc;

    public FootballTeam(String teamID, Scanner sc) {
        super(teamID);
        this.sc = sc;
    }


    public void updatePlayerPosition() {
        System.out.print("Please input player ID: ");
        int playerID = sc.nextInt();
        System.out.println("Position (1 = goal keeper | 2 = defender  | 3 = midfielder | 4 = forward): ");
    }


    public void displayTeam() {
        System.out.println("Football Team " + getName() + " ("  + getTeamID() + ")");
    }
}