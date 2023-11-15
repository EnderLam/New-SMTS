import Teams.*;
import java.util.*;

import Commands.*;
import CommandsFactory.*;
import Caretaker.*;
import Memento.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Vector teams = new Vector();
    public static Vector<Team> currentTeam = new Vector();

    public static void main(String[] args) {
        String command;
        Player player = null;
        Stack commands = new Stack(); // a stack to store the executed commands (for undo)
        Stack redos = new Stack();
        Command com;
        List<Player> players = new ArrayList<>();
        PlayerFactory playerFactory = new PlayerFactory();

        // use a HashMap to store the command factories
        HashMap<String,CommandFactory> cFactories = new HashMap<String,CommandFactory>();
        cFactories.put("c", new CreateCommandFactory(sc, currentTeam, teams, commands));
        cFactories.put("g", new SetCurrentTeamCommandFactory(sc, currentTeam, teams, commands));
        cFactories.put("a", new AddPlayerCommandFactory(sc, currentTeam, playerFactory, players, commands));
        cFactories.put("m", new ModifyPlayerCommandFactory(sc, players, player, currentTeam, commands));
        cFactories.put("d", new DeletePlayerCommandFactory(sc, redos, players, commands));
        cFactories.put("s", new ShowTeamCommandFactory(currentTeam, commands));
        cFactories.put("p", new DisplayAllTeamCommandFactory(teams, commands));
        cFactories.put("t", new ChangeTeamNameCommandFactory(sc, currentTeam, commands));
        cFactories.put("u", new UndoCommandFactory(commands, redos));
        cFactories.put("r", new RedoCommandFactory(commands, redos));
        cFactories.put("x", new ExitCommandFactory());
        Caretaker ct = new Caretaker();
        MyClass mc = new MyClass();

        while (true) {
            System.out.println("Sport Teams Management System (STMS)");
            System.out.println("c = create team, g = set current team, a = add player, m = modify player’s position, d = delete player, s = show team, p = display all teams, t = change team’s name, u = undo, r = redo, l = list undo/redo, x = exit system");
            if (!currentTeam.isEmpty()){
                Team team = currentTeam.get(0);
                System.out.println("Current team is " + team.getName() + " " + team.getTeamID() + ".");
           }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] : ");
            command = sc.nextLine();

            switch (command) {
                case "c":
                //create team
                    com = cFactories.get("c").createCommand();
                    com.execute();
                    currentTeam = CreateCommand.currentTeam;
                    break;
                case "g":
                //set current team
                if (!currentTeam.isEmpty()) {
                    com = cFactories.get("g").createCommand();
                    com.execute();
                    currentTeam = SetCurrentTeamCommand.currentTeam;
                }else{
                    System.out.println("No current team set.");
                }
                    break;
                case "a":
                //add player
                if (!currentTeam.isEmpty()) {
                com = cFactories.get("a").createCommand();
                com.execute();
                } else {
                    System.out.println("No current team set.");
                }
                    break;
                case "m":
                //modify player’s position
                if (!currentTeam.isEmpty()) {
                com = cFactories.get("m").createCommand();
                com.execute();
            }else{
                System.out.println("Invalid Modify.");
            }
                    break;
                case "d":
                //d = delete player
                if (!currentTeam.isEmpty()) {
                    com = cFactories.get("d").createCommand();
                    com.execute();
                }else{
                    System.out.println("Player not found.");
                }
                    break;
                case "s":
                //show team
                    if (!currentTeam.isEmpty()) {
                    com = cFactories.get("s").createCommand();
                    com.execute();
                }else{
                    System.out.println("No team set.");
                }
                    break;
                case "p":
                    com = cFactories.get("p").createCommand();
                    com.execute();
                    break;
                case "t":
                //change team’s name
                if (!currentTeam.isEmpty()) {
                    com = cFactories.get("t").createCommand();
                    com.execute();
                    currentTeam = ChangeTeamNameCommand.currentTeam;
                }else{
                     System.out.println("No team set.");
                }
                    break;
                case "u":
                //undo
                    com = cFactories.get("u").createCommand();
                    com.execute();
                    break;
                case "r":
                //redo
                    com = cFactories.get("r").createCommand();
                    com.execute();
                    break;
                case "l":
                //list undo/redo
                    com = new UndoRedoListCommand(commands, redos);
                    com.execute();
                    break;
                case "x":
                    com = cFactories.get("x").createCommand();
                    com.execute();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}