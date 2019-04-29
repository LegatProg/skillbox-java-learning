public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String[] salaries = text.replaceAll("^\\D+", "").split("\\D+");

        int totalSalary = 0;
        for (String salary : salaries) {
            totalSalary += Integer.parseInt(salary);
        }
        System.out.println(totalSalary);
    }
}