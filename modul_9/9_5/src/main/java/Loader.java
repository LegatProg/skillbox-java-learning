import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class Loader {

    private static long size = 0;
    private static final int KILO = 1024;
    private static final int MEGA = 1024 * 1024;
    private static final int GIGA = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input path to directory:");
        String path = scanner.nextLine();

        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("Directory not found!");
        }
        if (file.isFile()) {
            System.out.println("You entered the path to the file!\nThe file size is: " + getReadableNumber(file.length()));

        } else {
            long dirSize = getFileSize(file);

            System.out.println("The directory size (including subdirectories) is: " + getReadableNumber(dirSize));
        }
    }

    private static long getFileSize(File file) throws IOException {
        if (file.isDirectory()) {
            Stream<Path> stream = Files.list(Path.of(file.getAbsolutePath()));
            stream.forEach(e -> {
                try {
                    Loader.getFileSize(e.toFile());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } else {
            size += file.length();
        }
        return size;
    }

    private static String getReadableNumber(long number) {
        if (number <= KILO) {
            return number + " Bytes.";
        } else if (number <= MEGA) {
            double kilo = (double) number / KILO;
            return String.format("%.2f", kilo) + " Kilobytes.";
        } else if (number <= GIGA) {
            double mega = (double) number / MEGA;
            return String.format("%.2f", mega) + " Megabytes.";
        } else {
            double giga = (double) number / GIGA;
            return String.format("%.2f", giga) + " Gigabytes.";
    }
}
}
