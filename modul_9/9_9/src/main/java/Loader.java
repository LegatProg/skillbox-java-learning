import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;

public class Loader {

    private static final Path RESOURCE = Path.of("/Users/maksimgelevera/Desktop/skillbox-java-learning/modul_9/9_9/src/main/resources/movementList.csv");

    public static void main(String[] args) throws Exception {

        List<String[]> list = readAll();
        List<BankingOperation> operations = parseOperations(list);
        System.out.printf("Total income: %.2f RUB\n", (double) (getTotal(operations, BankingOperation::getIncome) / 100.0));
        System.out.printf("Total expense: %.2f RUB\n", (double) (getTotal(operations, BankingOperation::getExpense) / 100.0));

        Map<String, Long> incByCategory = groupByCategory(operations, BankingOperation::getIncome);
        System.out.println("\nIncome by Category: \n");
        printGroup(incByCategory);

        Map<String, Long> expensesByCategory = groupByCategory(operations, BankingOperation::getExpense);
        System.out.println("\nExpenses by Category: \n");
        printGroup(expensesByCategory);

        System.out.println("\n\nConsolidated report: \n");
        operations.stream()
                .collect(Collectors.groupingBy(BankingOperation::getDescription,
                        Collectors.mapping(Summary::fromOperation,
                                Collectors.reducing(Summary::merge)
                        )))
                .forEach((s, summ) -> System.out.printf(
                        "%s : Income: %.2f \t Expense: %.2f \n", s, summ.get().income / 100.0, summ.get().withdraw / 100.0));

    }

    private static void printGroup(Map<String, Long> map) {
        map.forEach((k, v) -> {
            if (v > 0) {
                System.out.printf("%s : %.2f RUB \n", k, v / 100.0);
            }
        });
    }

    private static Map<String, Long> groupByCategory(List<BankingOperation> operations, ToLongFunction<BankingOperation> function) {
        return operations.stream()
                .collect(Collectors.groupingBy(BankingOperation::getDescription,
                        Collectors.summingLong(function)));


    }

    private static long getTotal(List<BankingOperation> list, ToLongFunction<BankingOperation> function) {
        return list.stream().mapToLong(function).sum();
    }

    private static List<BankingOperation> parseOperations(List<String[]> list) {
        List<BankingOperation> operations = new ArrayList<>();
        for (String[] arr : list) {
            if (arr.length != 8) {
                System.err.println("Wrong operation");
                continue;
            }
            long inc = (long) (Double.parseDouble(arr[6].replaceAll(",", ".")) * 100);
            long exp = (long) (Double.parseDouble(arr[7].replaceAll(",", ".")) * 100);

            String desc = arr[5].replaceAll(".+[\\\\/]", "") //cut the 1st part of the string
                    .replaceAll("\\s\\d{2}\\..+", "") //cut the end of the string;
                    .replaceAll(">MOSCOW", ""); //cut >MOSCOW

            operations.add(new BankingOperation(desc.trim(),
                    inc, exp));
        }
        return operations;
    }

    private static List<String[]> readAll() throws Exception {
        List<String[]> list;
        try (Reader reader = Files.newBufferedReader(RESOURCE);
             CSVReader csvReader = createCSVReader(reader, ',', false, 1)) {
            list = csvReader.readAll();
        }
        return list;
    }

    private static CSVReader createCSVReader(Reader reader, char separator, boolean ignoreQuotations, int skipLines) {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(separator)
                .withIgnoreQuotations(ignoreQuotations)
                .withEscapeChar('\0')
                .build();
        return new CSVReaderBuilder(reader)
                .withSkipLines(skipLines)
                .withCSVParser(parser)
                .build();
    }

    private static class Summary {
        long income;
        long withdraw;

        Summary(long income, long withdraw) {
            this.income = income;
            this.withdraw = withdraw;
        }

        static Summary merge(Summary s1, Summary s2) {
            return new Summary(s1.income + s2.income, s1.withdraw + s2.withdraw);
        }

        static Summary fromOperation(BankingOperation bankingOperation) {
            return new Summary(bankingOperation.getIncome(), bankingOperation.getExpense());
        }

    }
}
