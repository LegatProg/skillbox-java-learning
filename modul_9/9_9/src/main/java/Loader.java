import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Loader {

    private static final Path RESOURCE = Path.of("/Users/maksimgelevera/Desktop/skillbox-java-learning/modul_9/9_9/src/main/resources/movementList.csv");
    private static Reader reader;
    private static CSVReader csvReader;

    public static void main(String[] args) throws Exception {

        csvReader = createCSVReader(',', false, 1);
        List<String[]> list = readAll();
        List<BankingOperation> operations = new ArrayList<>();
        parseOperations(list, operations);
        System.out.printf("Total income: %.2f RUB\n", (double) (getTotalIncome(operations) / 100.0));
        System.out.printf("Total expense: %.2f RUB\n", (double) (getTotalExpense(operations) / 100.0));

        Set<String> expDescriptions = new HashSet<>();
        parseExpenseDescriptions(expDescriptions, operations);

        HashMap<String, Long> expensesByCategory = new HashMap<>();
        separateExpensesByCategory(expDescriptions, operations, expensesByCategory);
        System.out.println("\nExpenses by Category: \n");
        expensesByCategory.forEach((k, v) -> {
            System.out.printf("%s : %.2f RUB \n", k, v / 100.0);
        });
    }

    private static void separateExpensesByCategory(Set<String> expDescriptions,
                                                   List<BankingOperation> operations,
                                                   HashMap<String, Long> expensesByCategory) {
        for (String desc : expDescriptions) {
            for (BankingOperation operation : operations) {
                if (operation.getDescription().equals(desc)) {
                    if (!expensesByCategory.containsKey(desc)) {
                        expensesByCategory.put(desc, operation.getExpense());
                    } else {
                        long newValue = expensesByCategory.get(desc) + operation.getExpense();
                        expensesByCategory.put(desc, newValue);
                    }
                }
            }
        }
    }

    private static void parseExpenseDescriptions(Set<String> expDescriptions, List<BankingOperation> operations) {
        operations.stream().filter(e -> e.getExpense() > 0)
                .forEach(bankingOperation -> {
                    expDescriptions.add(bankingOperation.getDescription());
                });
    }

    private static void parseOperations(List<String[]> list, List<BankingOperation> operations) {
        for (String[] arr : list) {
            if (arr.length != 8) {
                System.err.println("Wrong operation");
                continue;
            }
            long inc = (long) (Double.parseDouble(arr[6].replaceAll(",", ".")) * 100);
            long exp = (long) (Double.parseDouble(arr[7].replaceAll(",", ".")) * 100);

            operations.add(new BankingOperation(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5],
                    inc, exp));
        }
    }

    private static List<String[]> readAll() throws Exception {
        List<String[]> list = csvReader.readAll();
        reader.close();
        csvReader.close();
        return list;
    }

    private static CSVReader createCSVReader(char separator, boolean ignoreQuotations, int skipLines) throws IOException {
        reader = Files.newBufferedReader(RESOURCE);
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(separator)
                .withIgnoreQuotations(ignoreQuotations)
                .build();
        return new CSVReaderBuilder(reader)
                .withSkipLines(skipLines)
                .withCSVParser(parser)
                .build();
    }

    private static long getTotalIncome(List<BankingOperation> list) {
        return list.stream().mapToLong(BankingOperation::getIncome).sum();
    }

    private static long getTotalExpense(List<BankingOperation> list) {
        return list.stream().mapToLong(BankingOperation::getExpense).sum();
    }
}
