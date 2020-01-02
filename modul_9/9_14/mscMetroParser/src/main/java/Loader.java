
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class Loader {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("https://ru.wikipedia.org/wiki" +
                "/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D1%81%D1%82%D0%B0%D0%BD%D1%86%D0%B8%D0%B9" +
                "_%D0%9C%D0%BE%D1%81%D0%BA%D0%BE%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_" +
                "%D0%BC%D0%B5%D1%82%D1%80%D0%BE%D0%BF%D0%BE%D0%BB%D0%B8%D1%82%D0%B5%D0%BD%D0%B0")
                .maxBodySize(0)
                .get();
        Element table = doc.getElementsByTag("table").get(3);
        Elements rows = table.getElementsByTag("tr");

        LinkedHashMap<String, String> lines = getLines(rows);
        LinkedHashMap<String, ArrayList<String>> stations = getStations(rows);

        ArrayList<LinkedHashMap<String, String>> linesToFormat = new ArrayList<>();
        for (Map.Entry<String, String> entry : lines.entrySet()) {
            LinkedHashMap<String, String> entryToAdd = new LinkedHashMap<>();
            entryToAdd.put("name", entry.getValue());
            entryToAdd.put("number", entry.getKey());
            linesToFormat.add(entryToAdd);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.append("lines", linesToFormat);

        jsonObject.append("stations", stations);

        Path path = Paths.get("src/main/resources/metro.json");
        if (!path.toFile().exists()) {
            Files.write(path, jsonObject.toString(5).getBytes(), StandardOpenOption.CREATE_NEW);
        } else {
            Files.write(path, jsonObject.toString(5).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
        }

//        lines.forEach((k, v) -> System.out.println(k + " : " + v));
//
//        System.out.println();
//
//        stations.forEach((k, v) -> {
//            System.out.println(k + " : ");
//            v.forEach(e -> System.out.println("\t " + e));
//        });
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(path.toString())) {
            org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(reader);
            JSONArray jsonStations = (JSONArray) json.get("stations");
            org.json.simple.JSONObject simple = (org.json.simple.JSONObject) jsonStations.get(0);
            simple.forEach((k, v) -> System.out.println(k + " : " + ((JSONArray)v).size()));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static LinkedHashMap<String, ArrayList<String>> getStations(Elements rows) {

        LinkedHashMap<String, ArrayList<String>> metro = new LinkedHashMap<>();
        ArrayList<String> thisStations;

        for (Element row : rows) {
            if (row.equals(rows.get(0))) { //skip 1st row in table
                continue;
            }
            Element firstTd = row.child(0);
            Element secondTd = row.child(1);
            String name = secondTd.select("a[href]").get(0).text();
            Elements spans = firstTd.getElementsByTag("span");
            Set<String> linesNums = new LinkedHashSet<>();
            if (spans.size() > 3) {
                String num1 = spans.get(0).text();
                String num2 = spans.get(2).text();
                linesNums.add(num1);
                linesNums.add(num2);
            } else {
                String num = spans.get(0).text();
                linesNums.add(num);
            }

            for (String line : linesNums) {
                if (!metro.containsKey(line)) {
                    ArrayList<String> stationsList = new ArrayList<>();
                    stationsList.add(name);
                    metro.put(line, stationsList);
                } else {
                    thisStations = metro.get(line);
                    thisStations.add(name);
                    metro.put(line, thisStations);
                }
            }
        }
        return metro;
    }

    private static LinkedHashMap<String, String> getLines(Elements rows) {
        LinkedHashMap<String, String> linesWithNum = new LinkedHashMap<>();
        for (Element row : rows) {
            if (row.equals(rows.get(0))) { //skip 1st row in table
                continue;
            }
            Element firstTd = row.child(0);
            Elements spans = firstTd.getElementsByTag("span");
            if (spans.size() > 3) {
                String num1 = spans.get(0).text();
                String name1 = spans.get(1).attr("title");
                String num2 = spans.get(2).text();
                String name2 = spans.get(3).attr("title");
                linesWithNum.put(num1, name1);
                linesWithNum.put(num2, name2);
            } else {
                String num = spans.get(0).text();
                String name = spans.get(1).attr("title");
                linesWithNum.put(num, name);
            }
        }
        return linesWithNum;
    }

//    public class Line {
//        String number;
//        String name;
//        LinkedHashSet<String> stations;
//
//        public Line(String number, String name) {
//            this.number = number;
//            this.name = name;
//            this.stations = new LinkedHashSet<>();
//        }
//
//        public void addStation(String station) {
//            stations.add(station);
//        }
//
//        public boolean checkLine(String line) {
//            return name.equals(line);
//        }
//    }
}
