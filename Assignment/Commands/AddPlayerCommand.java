package Commands;

import java.util.Scanner;
import java.util.Vector;
import java.util.List;

import Teams.*;

public class AddPlayerCommand implements Command {
    private Scanner sc;
    private Vector<Team> currentTeam;
    private PlayerFactory playerFactory;
    private List<Player> players;
    private Player lastPlayer;
    private Player redoPlayer;
    private int previousPosition;

    public AddPlayerCommand(Scanner sc, Vector<Team> currentTeam, PlayerFactory playerFactory, List<Player> players) {
        this.sc = sc;
        this.currentTeam = currentTeam;
        this.playerFactory = playerFactory;
        this.players = players;
    }

    public void execute() {
        System.out.print("Please input player information (id, name): ");
        String playerInfo = sc.nextLine();
        String[] playerDetails = playerInfo.split(", ");

        if (playerDetails.length != 2) {
            System.out.println("Invalid player details. Please provide correct player ID and name.");
            return;
        }

        String playerID = playerDetails[0];
        String playerName = playerDetails[1];
        Player player = playerFactory.createPlayer(sc, playerID, playerName);

        Team team = currentTeam.get(0); // Assuming only one current team is selected

        if (team instanceof VolleyballTeam) {
            System.out.print("Position (1 = attacker | 2 = defender): ");
            int position = Integer.parseInt(sc.nextLine());
            previousPosition = position;

            if (position == 1 || position == 2) {
                player.setPosition(position);
                team.addPlayer(player);
                players.add(player);
                System.out.println("Player is added.");
                lastPlayer = player;
            } else {
                System.out.println("Invalid position.");
            }
        } else if (team instanceof FootballTeam) {
            System.out.print("Position (1 = goal keeper | 2 = defender  | 3 = midfielder | 4 = forward): ");
            int position = Integer.parseInt(sc.nextLine());
            previousPosition = position;

            if (position >= 1 && position <= 4) {
                player.setPosition(position);
                team.addPlayer(player);
                players.add(player);
                System.out.println("Player is added.");
                lastPlayer = player;
            } else {
                System.out.println("Invalid position.");
            }
        } else {
            System.out.println("Error");
        }
    }

    public void undo() {
        if (lastPlayer != null) {
            Team team = currentTeam.get(0); // Assuming only one current team is selected
            redoPlayer = lastPlayer;
            players.remove(lastPlayer);
            team.remove(lastPlayer);
            System.out.println("Command (Add player, " + lastPlayer.getPlayerID() + ", " + lastPlayer.getName() + ", " + lastPlayer.getPosition() + " )" + " is undone.");
            lastPlayer = null;
        } else {
            System.out.println("No players to undo.");
        }
    }

    public void redo() {
        if (redoPlayer != null) {
            Team team = currentTeam.get(0); // Assuming only one current team is selected
            players.add(redoPlayer);
            team.addPlayer(redoPlayer);
            System.out.println("Command (Add player, " + redoPlayer.getPlayerID() + ", " + redoPlayer.getName() + ", " + redoPlayer.getPosition() + " )" + " is redone.");
        }else{
            System.out.println("No players to redo.");
        }
    }

    public String toString(){
        if (lastPlayer != null) {
            Team team = currentTeam.get(0); // Assuming only one current team is selected
            String positionDescription;
            int position = lastPlayer.getPosition();
    
            if (team instanceof VolleyballTeam) {
                switch (previousPosition) {
                    case 1:
                        positionDescription = "Attacker";
                        break;
                    case 2:
                        positionDescription = "Defender";
                        break;
                    default:
                        positionDescription = "Unknown Position";
                        break;
                }
            } else if (team instanceof FootballTeam) {
                switch (position) {
                    case 1:
                        positionDescription = "Goalkeeper";
                        break;
                    case 2:
                        positionDescription = "Defender";
                        break;
                    case 3:
                        positionDescription = "Midfielder";
                        break;
                    case 4:
                        positionDescription = "Forward";
                        break;
                    default:
                        positionDescription = "Unknown Position";
                        break;
                }
            } else {
                positionDescription = "Unknown Position";
            }
    
            return "Add player, " + lastPlayer.getPlayerID() + ", " + lastPlayer.getName() + ", " + positionDescription;
        } else {
            return "No player";
        }
    }
}