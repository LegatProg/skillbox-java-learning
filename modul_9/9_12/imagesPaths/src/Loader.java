import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) throws IOException {
        String path;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Please input reference: ");
                path = scanner.nextLine();
                if (!path.startsWith("http")) {
                    continue;
                }
                break;
            }
        }

        Document doc = Jsoup.connect(path).maxBodySize(0).get();
        Elements elements = doc.select("img");
        
        int count = 0;
        for (Element element : elements) {
            String href = element.attr("src");
            String template = "^http.+jpg|png|bmp|ico|gif|psd|svg.*";
            if (href.matches(template)) {
                downloadImage(href);
                System.out.println(++count + " image(s) downloaded");
            }
        }
    }

    private static void downloadImage(String imgSrc) throws MalformedURLException {
        URL url = new URL(imgSrc);
        imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
        String fileName = "res/" + imgSrc;
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.getChannel()
                    .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
