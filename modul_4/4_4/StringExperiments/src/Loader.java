public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        String vasyaSalSubstr = text.substring(0, text.indexOf(" руб"));
        String vasyaSalStr = vasyaSalSubstr.substring(vasyaSalSubstr.lastIndexOf(' ')).trim();
        int vasyaSalary = Integer.parseInt(vasyaSalStr);

        String mashaSalSubstr = text.substring(0, text.lastIndexOf(" руб"));
        String mashaSalStr = mashaSalSubstr.substring(mashaSalSubstr.lastIndexOf(' ')).trim();
        int mashaSalary = Integer.parseInt(mashaSalStr);

        System.out.println(vasyaSalary + mashaSalary);
    }
}