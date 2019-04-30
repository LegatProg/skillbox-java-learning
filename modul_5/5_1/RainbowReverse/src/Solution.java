public class Solution {
    public static void main(String[] args) {
        String inputStr = "Каждый охотник желает знать, где сидит фазан.";

        String[] rainbow = inputStr.split(",?\\s|\\.+");

        reverseAndPrint(rainbow);
    }

    static void reverseAndPrint(String arr[]) {

        for (int i = 0; i < arr.length / 2; i++) {
            String buff = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = buff;
        }

        System.out.println("Reversed array is: \n");
        for (String element : arr) {
            System.out.println(element);
        }
    }
}
