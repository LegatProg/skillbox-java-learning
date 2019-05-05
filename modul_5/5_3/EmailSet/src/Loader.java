import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.Scanner;
import java.util.TreeSet;

public class Loader {

    private static TreeSet<String> emails;

    public static void main(String[] args) {

        emails = new TreeSet<>();
        boolean isExit = false;
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                System.out.println("\nType command (to view available commands type \"HELP\"):");
                String command = scanner.nextLine().trim();
                switch (command) {
                    case "EXIT": {
                        isExit = true;
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
            } while (!isExit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printList() {
        emails.forEach(System.out::println);
    }

    private static void addEntity(String command) {
        String[] strings = command.split("\\s");
        if (strings.length == 2 && isValidEmailAddress(strings[1])) { //or strings.length > 1 && isValidEmailAddress(strings[1]) best ?
            emails.add(strings[1]);                                   //but in this case we can write for ex. ADD yaaz@mail.com something else
            System.out.println("Email added.");                       //and ADD the email anyway
        } else {
            System.out.println("Wrong email format!");
        }
    }

    private static void printCommands() {
        System.out.println("Type \"ADD {email}\" to add the email.");
        System.out.println("Type \"LIST \" to print the list.");
        System.out.println("Type \"HELP\" to view available commands.");
        System.out.println("Type \"EXIT\" for exit.");
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
