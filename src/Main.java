import java.util.Scanner;

public class Main {
    private static CommandLine commandLine = new CommandLine();
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            String[] command = scn.nextLine().split(" ");
            if(command.length == 1) {
                if(!commandLine.performCommand(command[0], null)) {
                    break;
                }
            } else {
                if (!commandLine.performCommand(command[0], command[1])) {
                    break;
                }
            }
        }
    }
}


