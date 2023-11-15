package Commands;

import java.util.Scanner;
import java.util.Vector;
import java.util.List;

import Teams.Player;
import Teams.Team;

public class DeletePlayerCommand implements Command {

    private Scanner sc;
    private Vector<Team> currentTeam;
    private List<Player> players;
    private Player playerToRemove;

    public DeletePlayerCommand(Scanner sc, Vector currentTeam, List<Player> players) {
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.players = players;
    }

    public void execute() {
        Team team = currentTeam.get(0); // Assuming only one current team is selected
        System.out.print("Please input player ID:");
        String playerID = sc.nextLine();

        playerToRemove = null;
        for (Player player : players) {
            if (player.getPlayerID().equals(playerID)) {
                playerToRemove = player;
                break;
            }
        }

        if (playerToRemove != null) {
            team.remove(playerToRemove);
            players.remove(playerToRemove);
            System.out.println("Delete successful.");
        } else {
            System.out.println("Player not found in the current team.");
        }
    }

    public void undo() {
        if (playerToRemove != null) {
            Team team = currentTeam.get(0);
            team.addPlayer(playerToRemove);
            players.add(playerToRemove);
            System.out.println("Command (Delete player, " + playerToRemove.getPlayerID() + " )" + " is undone");
        }
    }

    public void redo() {
        if (playerToRemove != null) {
            Team team = currentTeam.get(0);
            team.remove(playerToRemove);
            players.remove(playerToRemove);
            System.out.println("Command (Delete player, " + playerToRemove.getPlayerID() + " )" + " is redone");
        }
    }

    public String toString(){
        return "Delete player, " + playerToRemove.getPlayerID();
    }
}