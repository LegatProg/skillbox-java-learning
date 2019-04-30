import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        System.out.println("Input the phone number: ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine().replaceAll("\\D+", "");
        if (phoneNumber.length() == 10) {
            phoneNumber = '7' + phoneNumber;
            printNumberInRightFormat(phoneNumber);
        } else if (phoneNumber.length() == 11) {
            phoneNumber = phoneNumber.replaceFirst("^.", "7");
            printNumberInRightFormat(phoneNumber);
        } else {
            System.out.println("Wrong number format");
        }
        scanner.close();
    }

    private static void printNumberInRightFormat(String number) {
        System.out.println(String.format("+%s %s %s-%s-%s",
                number.substring(0, 1),
                number.substring(1, 4),
                number.substring(4, 7),
                number.substring(7, 9),
                number.substring(9)));
    }
}
