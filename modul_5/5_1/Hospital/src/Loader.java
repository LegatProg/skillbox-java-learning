public class Loader {
//    Создать массив с температурами 30-ти пациентов (от 32 до 40 градусов).
//    Написать код, рассчитывающий среднюю температуру по больнице и количество здоровых пациентов
//    (с температурой от 36,2 до 36,9).
    private static final float MIN_TEMP = (float) 36.2;
    private static final float MAX_TEMP = (float) 36.9;

    public static void main(String[] args) {

        float[] temperatures = createAndFillArray(30);

        System.out.printf("Average hospital temperature is: %.2f °C\n", getAverage(temperatures));
        System.out.println("The healthy patients count is: " + countHealthy(temperatures, MIN_TEMP, MAX_TEMP));
    }

    private static float[] createAndFillArray(int capacity) {
        float[] arr = new float[capacity];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) Math.random() * 8 + 32;
        }
        return arr;
    }

    private static float getAverage(float[] arr) {
        float sum = 0;
        for (float num : arr) {
            sum += num;
        }
        return sum / arr.length;
    }

    private static int countHealthy (float[] arr, float minTemp, float maxTemp){
        int healthyCount = 0;
        for (float num : arr) {
            if (num >= minTemp && num <= maxTemp){
                healthyCount++;
            }
        }
        return healthyCount;
    }
}