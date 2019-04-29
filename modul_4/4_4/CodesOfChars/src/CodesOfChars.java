public class CodesOfChars {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXYZ" +
                "абвгдеёжзийклмнопрстухфцчшщьэъыюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЭЪЫЮЯ";
        for (int i = 0; i < alphabet.length(); i++) {
            System.out.println(alphabet.charAt(i) + " = " + (int) alphabet.charAt(i));
        }
    }
}
