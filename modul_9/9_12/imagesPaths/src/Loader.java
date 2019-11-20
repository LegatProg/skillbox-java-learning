import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
        URL url = new URL(path);
        InputStream is = url.openStream();
        Document doc = Jsoup.parse(is, "UTF-8", path);

        Elements elements = doc.select("img");
        int count = 0;
        for (Element element : elements) {
            String href = element.attr("src");
            if (href.startsWith("http") && (href.contains(".jpg") || (href.contains(".png")
                    || (href.contains(".bmp") || href.contains(".ico"))))) {
                downloadImage(href);
                System.out.println(++count + " image(s) downloaded");
            }
        }
    }

    private static void downloadImage(String imgSrc) {
        BufferedImage image;
        try {
            String url = imgSrc;
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = "res/" + imgSrc;
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
