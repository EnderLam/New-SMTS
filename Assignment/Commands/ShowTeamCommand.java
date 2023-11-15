package Commands;

import java.util.*;
import Teams.*;

public class ShowTeamCommand implements Command {

    private Vector<Team> currentTeam;

    public ShowTeamCommand(Vector<Team> currentTeam) {
        this.currentTeam = currentTeam;
    }

    public void execute() {
        Team team = currentTeam.get(0); // Assuming only one current team is selected
        team.displayTeam();
        System.out.println();
    
        boolean attackerDisplayed = false;
        boolean defenderDisplayed = false;
        boolean midfielderDisplayed = false;
        boolean forwardDisplayed = false;
    
        Enumeration<Player> players = team.getAllPlayers();
        while (players.hasMoreElements()) {
            Player player = players.nextElement();
            if (team instanceof VolleyballTeam) {
                if (player.getPosition() == VolleyballTeam.ATTACKER && !attackerDisplayed) {
                    System.out.println("Attacker:");
                    attackerDisplayed = true;
                }
                if (player.getPosition() == VolleyballTeam.DEFENDER && !defenderDisplayed) {
                    System.out.println("Defender:");
                    defenderDisplayed = true;
                }
            } else if (team instanceof FootballTeam) {
                if (player.getPosition() == FootballTeam.GOALKEEPER && !attackerDisplayed) {
                    System.out.println("Goalkeeper:");
                    attackerDisplayed = true;
                }
                if (player.getPosition() == FootballTeam.DEFENDER && !defenderDisplayed) {
                    System.out.println("Defender:");
                    defenderDisplayed = true;
                }
                if (player.getPosition() == FootballTeam.MIDFIELDER && !midfielderDisplayed) {
                    System.out.println("Midfielder:");
                    midfielderDisplayed = true;
                }
                if (player.getPosition() == FootballTeam.FORWARD && !forwardDisplayed) {
                    System.out.println("Forward:");
                    forwardDisplayed = true;
                }
            }
            System.out.println(player.getPlayerID() + ", " + player.getName());
        }
    }

    public void undo() {

    }

    public void redo() {

    }
}