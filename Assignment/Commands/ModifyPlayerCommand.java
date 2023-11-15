package Commands;

import java.util.Scanner;
import java.util.Vector;
import java.util.List;

import Teams.*;

public class ModifyPlayerCommand implements Command {
    private Scanner sc;
    private List<Player> players;
    private Player player;
    private Vector<Team> currentTeam;
    private int previousPosition;
    private int position;

    public ModifyPlayerCommand(Scanner sc, List<Player> players, Player player, Vector currentTeam){
        this.sc = sc;
        this.players = players;
        this.player = player;
        this.currentTeam = currentTeam;
    }

    public void execute(){
        Team team = currentTeam.get(0);
        System.out.print("Please input player ID: ");
        String playerID = sc.nextLine();
        for (Player currentPlayer : players) {
            if (currentPlayer.getPlayerID().equals(playerID)) {
                previousPosition = currentPlayer.getPosition();
                if (team instanceof VolleyballTeam) {
                    System.out.print("Position (1 = attacker | 2 = defender ): ");
                    position = Integer.parseInt(sc.nextLine());
                    if (position == 1) {
                        currentPlayer.setPosition(1);
                        System.out.println("Position is updated.");
                    } else if (position == 2) {
                        currentPlayer.setPosition(2);
                        System.out.println("Position is updated.");
                    } else {
                        System.out.println("Invalid position.");
                    }
                } else if (team instanceof FootballTeam) {
                    System.out.print("Position (1 = goal keeper | 2 = defender  | 3 = midfielder | 4 = forward): ");
                    position = Integer.parseInt(sc.nextLine());
                    if (position >= 1 && position <= 4) {
                        currentPlayer.setPosition(position);
                        System.out.println("Position is updated.");
                    } else {
                        System.out.println("Invalid position.");
                    }
                }
                return;
            }
        }
        System.out.println("Player not found in the current team.");
    }

    public void undo(){
        System.out.println("Modify player’s position, " + player.getPlayerID() + ", " + player.getPosition() + " )" + " is undone");
        player.setPosition(previousPosition);
    }

    public void redo(){
        System.out.println("Modify player’s position, " + player.getPlayerID() + ", " + previousPosition + " )" + " is redone");
        player.setPosition(position);
    }

    public String toString(){
        return "Modify player’s position, " + player.getPlayerID() + ", " + player.getPosition();
    }
}