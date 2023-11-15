package Teams;

import java.util.Scanner;

public interface TeamFactory {
    public abstract Team createTeam(Scanner sc);
    public abstract Team getCurrentTeam();
}
