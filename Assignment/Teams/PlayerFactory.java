package Teams;
import java.util.Scanner;
public class PlayerFactory {

    public Player createPlayer(Scanner sc,String playerID, String playerName){
        Player player = new Player(playerID, playerName);
        return player;
    }
    
}
