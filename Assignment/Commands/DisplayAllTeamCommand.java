package Commands;

import Teams.*;
import java.util.*;

public class DisplayAllTeamCommand implements Command {

    private Vector teams;

    public DisplayAllTeamCommand(Vector teams){
        this.teams = teams;
    }
    public void execute(){
        for (Object team : teams) {
            Team currentTeam = (Team) team; // Manually cast to Team
            System.out.println();
            currentTeam.displayTeam();
            System.out.println();
        }
    }
    public void undo(){

    }
    public void redo(){

    }
}
