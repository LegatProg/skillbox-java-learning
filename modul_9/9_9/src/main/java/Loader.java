import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Loader {

    private static final Path RESOURCE = Path.of("/Users/maksimgelevera/Desktop/skillbox-java-learning/modul_9/9_9/src/main/resources/movementList.csv");

    public static void main(String[] args) throws Exception {

        List<String[]> list = readAll();
        List<BankingOperation> operations = parseOperations(list);
        System.out.printf("Total income: %.2f RUB\n", (double) (getTotalIncome(operations) / 100.0));
        System.out.printf("Total expense: %.2f RUB\n", (double) (getTotalExpense(operations) / 100.0));

        Set<String> incDescriptions = parseIncomeDescriptions(operations);
        HashMap<String, Long> incByCategory = separateIncomeByCategory(incDescriptions, operations);
        System.out.println("\nIncome by Category: \n");
        incByCategory.forEach((k, v) -> {
            System.out.printf("%s : %.2f RUB \n", k, v / 100.0);
        });

        Set<String> expDescriptions = parseExpenseDescriptions(operations);
        HashMap<String, Long> expensesByCategory = separateExpensesByCategory(expDescriptions, operations);
        System.out.println("\nExpenses by Category: \n");
        expensesByCategory.forEach((k, v) -> {
            System.out.printf("%s : %.2f RUB \n", k, v / 100.0);
        });

    }

    private static HashMap<String, Long> separateIncomeByCategory(Set<String> incomeDescriptions,
                                                                  List<BankingOperation> operations) {
        HashMap<String, Long> incomeByCategory = new HashMap<>();
//        for (String desc : expDescriptions) {
//            for (BankingOperation operation : operations) {
//                if (operation.getDescription().equals(desc)) {
//                    if (!incomeByCategory.containsKey(desc)) {
//                        incomeByCategory.put(desc, operation.getExpense());
//                    } else {
//                        long newValue = incomeByCategory.get(desc) + operation.getExpense();
//                        incomeByCategory.put(desc, newValue);
//                    }
//                }
//            }
//        }
        incomeDescriptions.forEach(descr ->
        {
            operations.forEach(operation -> {
                if (operation.getDescription().equals(descr)) {
                    if (!incomeByCategory.containsKey(descr)) {
                        incomeByCategory.put(descr, operation.getIncome());
                    } else {
                        incomeByCategory.put(descr, incomeByCategory.get(descr) + operation.getIncome());
                    }
                }

            });
        });

        return incomeByCategory;
    }

    private static HashMap<String, Long> separateExpensesByCategory(Set<String> expDescriptions,
                                                                    List<BankingOperation> operations) {
        HashMap<String, Long> expensesByCategory = new HashMap<>();
//        for (String desc : expDescriptions) {
//            for (BankingOperation operation : operations) {
//                if (operation.getDescription().equals(desc)) {
//                    if (!expensesByCategory.containsKey(desc)) {
//                        expensesByCategory.put(desc, operation.getExpense());
//                    } else {
//                        long newValue = expensesByCategory.get(desc) + operation.getExpense();
//                        expensesByCategory.put(desc, newValue);
//                    }
//                }
//            }
//        }
        expDescriptions.forEach(descr ->
        {
            operations.forEach(operation -> {
                if (operation.getDescription().equals(descr)) {
                    if (!expensesByCategory.containsKey(descr)) {
                        expensesByCategory.put(descr, operation.getExpense());
                    } else {
                        expensesByCategory.put(descr, expensesByCategory.get(descr) + operation.getExpense());
                    }
                }

            });
        });

        return expensesByCategory;
    }

    private static Set<String> parseExpenseDescriptions(List<BankingOperation> operations) {
        Set<String> expDescriptions = new HashSet<>();
        operations.stream().filter(e -> e.getExpense() > 0)
                .forEach(bankingOperation -> {
                    expDescriptions.add(bankingOperation.getDescription());
                });
        return expDescriptions;
    }

    private static Set<String> parseIncomeDescriptions(List<BankingOperation> operations) {
        Set<String> incDescriptions = new HashSet<>();
        operations.stream().filter(e -> e.getIncome() > 0)
                .forEach(bankingOperation -> {
                    incDescriptions.add(bankingOperation.getDescription());
                });
        return incDescriptions;
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

            operations.add(new BankingOperation(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5],
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

    private static long getTotalIncome(List<BankingOperation> list) {
        return list.stream().mapToLong(BankingOperation::getIncome).sum();
    }

    private static long getTotalExpense(List<BankingOperation> list) {
        return list.stream().mapToLong(BankingOperation::getExpense).sum();
    }
}
