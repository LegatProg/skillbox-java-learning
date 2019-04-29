import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) throws IOException {
        String[] outputData = {"Фамилия: ", "Имя: ", "Отчество: "};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fullName = reader.readLine().trim();

        if (!Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+\\s" +
                "[А-ЯЁ&&[^ЪЬЫ]]{1}[а-яё]+$").matcher(fullName).matches())
            System.out.println("Неверно введено Ф.И.О.");
        else {
            String[] fullNameArray = fullName.split("\\s");
            for (int i = 0; i < 3; i++) {
                System.out.println(outputData[i] + fullNameArray[i]);
            }
        }
        reader.close();
    }
}
// Гелевера Максим Игоревич