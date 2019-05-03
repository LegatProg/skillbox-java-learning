import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> carNumbers = initializeCarNumbersBase(makeOneSeries(), makeNumbers(), makeOneSeries(),
                makeOneSeries(), makeRegions());
        HashSet<String> carNumberHashSet = new HashSet<>(carNumbers);
        TreeSet<String> carNumberTreeSet = new TreeSet<>(carNumbers);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("Type number:");
            String numb = reader.readLine().trim();
            if (numb.equals("exit")) {
                break;
            }
            Collections.sort(carNumbers);
            long start = System.currentTimeMillis();
            System.out.println("Find with regular Search: " + isCool(numb, carNumbers) +
                    " (" + (System.currentTimeMillis() - start) + " ms)");
            start = System.currentTimeMillis();
            System.out.println("Find with binary Search: " + Collections.binarySearch(carNumbers, numb) +
                    " (" + (System.currentTimeMillis() - start) + " ms)");
            start = System.currentTimeMillis();
            System.out.println("Find with HashSet: " + carNumberHashSet.contains(numb) +
                    " (" + (System.currentTimeMillis() - start) + " ms)");
            start = System.currentTimeMillis();
            System.out.println("Find with TreeSet: " + carNumberTreeSet.contains(numb) +
                    " (" + (System.currentTimeMillis() - start) + " ms)");


        } while (true);
        reader.close();
    }

    public static boolean isCool(String number, ArrayList<String> list) {
        return list.contains(number);
    }

    public static ArrayList<String> makeRegions() {
        ArrayList<String> regions = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            if (i < 10) {
                regions.add("0" + i);
            } else {
                regions.add("" + i);
            }
        }
        regions.add("102");
        regions.add("113");
        regions.add("116");
        regions.add("716");
        regions.add("121");
        regions.add("123");
        regions.add("124");
        regions.add("125");
        regions.add("134");
        regions.add("136");
        regions.add("138");
        regions.add("142");
        regions.add("147");
        regions.add("150");
        regions.add("190");
        regions.add("750");
        regions.add("152");
        regions.add("154");
        regions.add("159");
        regions.add("161");
        regions.add("761");
        regions.add("163");
        regions.add("763");
        regions.add("164");
        regions.add("196");
        regions.add("173");
        regions.add("174");
        regions.add("177");
        regions.add("197");
        regions.add("199");
        regions.add("777");
        regions.add("799");
        regions.add("178");
        regions.add("198");
        regions.add("186");

        regions.remove("20");
        regions.remove("80");
        regions.remove("81");
        regions.remove("84");
        regions.remove("85");
        regions.remove("88");

        Collections.sort(regions);
        return regions;
    }

    public static ArrayList<String> makeNumbers() {
        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k + j + i != 0) {
                        if ((j == 0 && k == i) || ((k == j && j == i))) {
                            numbers.add("" + (k + j * 10 + i * 100));
                        }
                    }
                }
            }
        }
        for (int i = 1; i < 10; i++) {
            numbers.add("00" + i);
            numbers.add("0" + i + "0");
            numbers.add(i + "00");
        }

        return numbers;
    }

    public static ArrayList<String> makeOneSeries() {
        ArrayList<String> series = new ArrayList<>();

        series.add("А");
        series.add("В");
        series.add("Е");
        series.add("К");
        series.add("Л");
        series.add("М");
        series.add("Н");
        series.add("О");
        series.add("Р");
        series.add("С");
        series.add("Т");
        series.add("У");
        series.add("Х");

        return series;
    }

    public static ArrayList<String> initializeCarNumbersBase(ArrayList<String> firstSeries, ArrayList<String> numbers,
                                                             ArrayList<String> secondSeries, ArrayList<String> thirdSeries,
                                                             ArrayList<String> regions) {

        ArrayList<String> carNumbers = new ArrayList<>();

        for (String region : regions) {
            for (String first : firstSeries) {
                for (String second : secondSeries) {
                    for (String third : thirdSeries) {
                        for (String number : numbers) {
                            String ser = first + second + third;
                            if ((first.equals(third)) || ser.equals("ВОР") || ser.equals("ХАМ") || ser.equals("АМО") ||
                                    ser.equals("АТО") || ser.equals("АХО") || ser.equals("ВАА") || ser.equals("ХАА")) {
                                carNumbers.add(first + number + second + third + region);
                            }
                        }
                    }
                }
            }
        }
        System.out.printf("Base contains %,d car numbers.\n", carNumbers.size());
        return carNumbers;
    }

}
// Х909ХХ99
