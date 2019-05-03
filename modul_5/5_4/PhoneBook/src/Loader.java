import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Loader {

    private static String data;

    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please, type the number or the name:");
            data = scanner.nextLine().trim();
            if (data.equals("EXIT")) {
                break;
            }
            if (data.equals("LIST")) {
                if (!phoneBook.isEmpty()) {
                    phoneBook.forEach((key, value) -> System.out.println(key + " " + value));
                } else {
                    System.out.println("Phonebook is empty, add more entities");
                }
                continue;
            }
            if (data.matches("^\\W*\\d+.*")) {
                findOrAddUser(phoneBook, scanner);
            } else {
                findOrAddNumber(phoneBook, scanner);
            }

        } while (!data.equals("EXIT"));
        scanner.close();
    }

    private static void findOrAddNumber(Map<String, String> phoneBook, Scanner scanner) {
        if (phoneBook.containsKey(data)) {
            System.out.println("User's number is: " + phoneBook.get(data));
        } else {
            System.out.println("Number not found.\nPlease type the number:");
            String phone = scanner.nextLine().trim().replaceAll("\\D", "");
            phoneBook.put(data, phone);
            System.out.println("The number was added.");
        }
    }

    private static void findOrAddUser(Map<String, String> phoneBook, Scanner scanner) {
        data = data.replaceAll("\\D", "");
        if (phoneBook.containsValue(data)) {
            phoneBook.forEach((key, value) -> {
                if (value.equals(data)) {
                    System.out.println("The user's name is: " + key);
                }
            });
        } else {
            System.out.println("User not found.\nPlease type the user's name:");
            String user = scanner.nextLine().trim();
            phoneBook.put(user, data);
            System.out.println("The user was added.");
        }
    }
}
