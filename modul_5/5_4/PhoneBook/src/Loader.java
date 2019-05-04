import java.util.Scanner;
import java.util.TreeMap;

public class Loader {

    private static String inputString;
    private static TreeMap<String, String> phoneBook;
    private static Scanner scanner;

    public static void main(String[] args) {
        phoneBook = new TreeMap<>();
        scanner = new Scanner(System.in);
        do {
            System.out.println("Please, type the number or the name:");
            inputString = scanner.nextLine().trim();
            if (inputString.equals("EXIT")) {
                break;
            }
            if (inputString.equals("LIST")) {
                if (!phoneBook.isEmpty()) {
                    phoneBook.forEach((key, value) -> System.out.println(key + " " + value));
                } else {
                    System.out.println("Phonebook is empty, add more entities");
                }
                continue;
            }
            if (isPhoneNumber(inputString)) {
                findOrAddUser();
            } else {
                findOrAddNumber();
            }
        } while (!inputString.equals("EXIT"));
        scanner.close();
    }

    private static boolean isPhoneNumber (String inputString){
        return inputString.matches("^\\W*\\d+.*");
    }

    private static void findOrAddNumber() {
        if (phoneBook.containsKey(inputString)) {
            System.out.println("User's number is: " + phoneBook.get(inputString));
        } else {
            System.out.println("Number not found.\nPlease type the number:");
            String phone = scanner.nextLine().trim().replaceAll("\\D", "");
            phoneBook.put(inputString, phone);
            System.out.println("The number was added.");
        }
    }

    private static void findOrAddUser() {
        inputString = inputString.replaceAll("\\D", "");
        if (phoneBook.containsValue(inputString)) {
            phoneBook.forEach((key, value) -> {
                if (value.equals(inputString)) {
                    System.out.println("The user's name is: " + key);
                }
            });
        } else {
            System.out.println("User not found.\nPlease type the user's name:");
            String user = scanner.nextLine().trim();
            phoneBook.put(user, inputString);
            System.out.println("The user was added.");
        }
    }
}
