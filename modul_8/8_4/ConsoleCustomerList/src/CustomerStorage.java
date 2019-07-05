import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");

        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong command size");
        }

        String regexToCheckName = "[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+";
        if (!components[0].matches(regexToCheckName) ||
                !components[1].matches(regexToCheckName)) {
            throw new IllegalArgumentException("Wrong name format");
        }
        String name = components[0] + " " + components[1];

        if (!isValidEmailAddress(components[2])) {
            throw new IllegalArgumentException("Wrong email");
        }

        if (!components[3].matches("^\\+?\\d{1,2}\\(?\\d{1,4}\\)?\\d{7}$")) {
            throw new IllegalArgumentException("Wrong phone number");
        }

        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("User doesn't exists");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }

    private boolean isValidEmailAddress(String email) {
        try {
            InternetAddress address = new InternetAddress(email);
            address.validate();
        } catch (AddressException e) {
            return false;
        }
        return true;
    }
}