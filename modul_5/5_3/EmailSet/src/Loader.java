import java.util.Scanner;
import java.util.TreeSet;

public class Loader {

    private static TreeSet<String> emails;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        emails = new TreeSet<>();
        do {
            System.out.println("\nType command (to view available commands type \"HELP\"):");
            command = scanner.nextLine().trim();
            switch (command) {
                case "EXIT": {
                    break;
                }
                case "HELP": {
                    printCommands();
                    break;
                }
                case "LIST": {
                    printList();
                    break;
                }
                default: {
                    if (command.startsWith("ADD")) {
                        addEntity(command);
                    } else {
                        System.out.println("Wrong command, try again!");
                    }
                    break;
                }
            }
        } while (!command.equals("EXIT"));
        scanner.close();
    }

    private static void printList() {
        emails.forEach(System.out::println);
    }

    private static void addEntity(String command) {
        String[] strings = command.split("\\s");
        if (strings[1].matches("^\\w+@[a-zA-Z_]+\\.[a-zA-Z]{2,5}$")) {
            emails.add(strings[1]);
            System.out.println("Email added.");
        } else {
            System.out.println("Wrong email format!");
        }
    }

    private static void printCommands() {
        System.out.println("Type \"ADD {email}\" to add email.");
        System.out.println("Type \"LIST \" to print the list.");
        System.out.println("Type \"HELP\" to view available commands.");
        System.out.println("Type \"EXIT\" for exit.");
    }
}
