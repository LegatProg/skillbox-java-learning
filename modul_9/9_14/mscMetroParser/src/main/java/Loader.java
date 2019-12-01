import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Loader {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://ru.wikipedia.org/wiki" +
                "/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B9" +
                "_%D0%9C%D0%BE%D1%81%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_" +
                "%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B5%D0%BD%D0%B0")
                .get();
        Element table = doc.getElementsByTag("table").get(3);
        Elements rows = table.getElementsByTag("tr");
        Map<String, ArrayList<String>> metro = new LinkedHashMap<>();
        ArrayList<String> thisStations;
        System.out.println(rows.size());
        for (Element el : rows) {
            if (el.equals(rows.get(0))) { //skip 1st row in table
                continue;
            }
            String line = el.child(0).select("a[href]").get(0).attr("title"); //Line name
//            String lineNum = el.child(0).select("td").attr("data-sort-value"); //Line #
            String station = el.child(1).select("a[href]").get(0).text();
            if (!metro.containsKey(line)) {
                ArrayList<String> stationsList = new ArrayList<>();
                stationsList.add(station);
                metro.put(line, stationsList);
            } else {
                thisStations = metro.get(line);
                thisStations.add(station);
                metro.put(line, thisStations);
            }
        }
        System.out.println(metro.size());
        metro.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(val -> System.out.println("\t" + (v.indexOf(val)+1) + "\t" + val));
        });
    }
}
