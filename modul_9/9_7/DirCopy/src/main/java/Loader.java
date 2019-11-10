import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class Loader {
    private static String srcPath;
    private static String dstPath;

    public static void main(String[] args) throws Exception {

        readPath();

        Path src = Path.of(srcPath);
        Path dst = Path.of(dstPath);

        Files.walkFileTree(src, new MyFileVisitor(src, dst));
    }

    private static void readPath() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Please input the path to source directory:");
        srcPath = scanner.nextLine();
        System.out.println("Please input the path to destination directory:");
        dstPath = scanner.nextLine();
        scanner.close();
    }

}

class MyFileVisitor extends SimpleFileVisitor<Path> {
    private Path src;
    private Path dst;


    public MyFileVisitor(Path src, Path dst) {
        super();
        this.src = src;
        this.dst = dst;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Files.copy(file, dst.resolve(src.relativize(file)));
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Files.createDirectory(dst.resolve(src.relativize(dir)));
        return FileVisitResult.CONTINUE;
    }
}
/*
/Users/maksimgelevera/Desktop/test

/Users/maksimgelevera/Desktop/1234567/
*/