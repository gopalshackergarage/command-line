import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommandLine {
    Scanner scn = new Scanner(System.in);
    Set<String> commands = new HashSet<>();
    private Directory currentDir;

    public CommandLine() {
        currentDir = new Directory("root", null);
    }


    public boolean performCommand(String command, String param) {
        switch (command) {
            case "quit":
                return false;
            case "pwd":
                System.out.println(currentDir.printDirectoryPath());
                break;
            case "ls":
                if ("-r".equals(param)) {
                    currentDir.printContentsRecursively();
                } else {
                    currentDir.printContents();
                }
                break;
            case "mkdir":
                if (param == null || param.length() > 100) {
                    System.out.println("Invalid File or Folder Name");
                } else {
                    currentDir.addEntry(new Directory(param, currentDir));
                }
                break;
            case "cd":
                if (currentDir != null) {
                    if ("..".equals(param)) {
                        currentDir = currentDir.parent;
                    } else if (param != null) {
                        Entry content = currentDir.findContentByName(param);
                        if (content instanceof Directory) {
                            currentDir = (Directory) content;
                        } else {
                            System.out.println("Directory not found");
                        }
                    }
                }
                break;
            case "cd..":
            case "..":
                if (currentDir != null) {
                    currentDir = currentDir.parent;
                }
                break;
            case "touch":
                if (param == null || param.length() > 100) {
                    System.out.println("Invalid File or Folder Name");
                } else {
                    currentDir.addEntry(new File(param, currentDir));
                }
                break;
            default:
                System.out.println("Unrecognized command");
        }
        return true;
    }

}
