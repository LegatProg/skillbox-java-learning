import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Loader {
    //    Создать массив с температурами 30-ти пациентов (от 32 до 40 градусов).
//    Написать код, рассчитывающий среднюю температуру по больнице и количество здоровых пациентов
//    (с температурой от 36,2 до 36,9).
    private static final double MIN_TEMP = 36.2;
    private static final double MAX_TEMP = 36.9;
    private static final int MIN_ARRAY_TEMP = 32;
    private static final int ARRAY_TEMP_OFFSET = 40 - MIN_ARRAY_TEMP;

    public static void main(String[] args) {

        double[] temperatures = createAndFillArray(30);

        System.out.printf("Average hospital temperature is: %.2f °C\n", getAverage(temperatures));
        System.out.println("The healthy patients count is: " + countHealthy(temperatures, MIN_TEMP, MAX_TEMP));
    }

    private static double[] createAndFillArray(int capacity) {
        return DoubleStream.generate(() -> Math.random() * ARRAY_TEMP_OFFSET + MIN_ARRAY_TEMP).limit(capacity).toArray();
    }

    private static double getAverage(double[] arr) {
        OptionalDouble avg = Arrays.stream(arr).average();
        return avg.isPresent() ? avg.getAsDouble() : 0;
    }

    private static int countHealthy(double[] arr, double minTemp, double maxTemp) {
        return (int) Arrays.stream(arr).filter(x -> x >= minTemp && x <= maxTemp).count();
    }
}