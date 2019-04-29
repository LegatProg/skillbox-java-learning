public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println(container.count);
        System.out.println(sumDigits(123456789));
    }

    public static Integer sumDigits(Integer number)
    {
        int sum = 0;
        String numInStr = Integer.toString(number);
        for (int i = 0; i < numInStr.length(); i++) {
            // Тут проверка не нужна, т.к. на вход метода подается число, но сделал для того случая, если в метод будет подаваться строка.
            // Для этого случая нужно просто раскомментировать код ниже.
//            if (Character.isDigit(numInStr.charAt(i))){
                sum += Character.digit(numInStr.charAt(i), 10);
//            } else {
//                System.out.println("Symbol at " + i + " position in string is not a digit, skipping it");
//            }
        }
        return sum;
    }
}
