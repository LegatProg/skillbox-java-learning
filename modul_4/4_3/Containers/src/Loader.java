import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Loader {
    private static final int TRUCK_CAPACITY = 12;
    private static final int CONT_CAPACITY = 27;

    public static void main(String[] args) {

        System.out.println("Введите количество ящиков:");

        int boxAmount = inputNum();
        int containerAmount = (int) Math.ceil(boxAmount / (CONT_CAPACITY * 1.));    //округляет строго в большую сторону
        int truckAmount = (int) Math.ceil(containerAmount / (TRUCK_CAPACITY * 1.)); //округляет строго в большую сторону
        int containerCount = 1;
        int boxCount = 1;

        System.out.println("Контейнеров нужно: " + containerAmount);
        System.out.println("Грузовиков нужно: " + truckAmount + "\n");

        for (int i = 1; i <= truckAmount; i++) {
            System.out.println("Грузовик " + i + ":");
            for (int j = 1; j <= TRUCK_CAPACITY; j++) {
                System.out.println("\t\tКонтейнер " + containerCount++ + ":");
                for (int k = 1; k <= CONT_CAPACITY; k++) {
                    System.out.println("\t\t\t\tЯщик " + boxCount++);
                    if (boxCount > boxAmount) {
                        j = 13;
                        i = truckAmount + 1;
                        break;
                        // System.exit(0); - или лучше так?
                    }
                }
            }
        }
    }

    private static int inputNum() {
        int num = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (num <= 0) {
            try {
                num = Integer.parseInt(reader.readLine());
                if (num <= 0) {
                    System.out.println("Количество должно быть больше 0, введите снова:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Это не целое число, попробуйте снова:");
            } catch (IOException e) {
                System.out.println("Похоже что то пошло не так, попробуйте снова:");
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}
