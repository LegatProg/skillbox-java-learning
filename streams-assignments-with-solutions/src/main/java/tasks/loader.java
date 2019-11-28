package tasks;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class loader {
    public static void main(String[] args) {
        String string = "ghbdnt dkfgjdf ass rr";
        String[] strings = string.split("\\s+");
        Arrays.stream(strings).forEach(e -> System.out.println(e.length()));
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str.length())
                    .append(" ");
        }
        System.out.println(sb.toString().trim());


        Arrays.stream(string.split("\\s+")).map(String::length)
                .map(Object::toString)
                .collect(Collectors.joining(" "));

    }
}
