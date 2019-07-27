import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;

    Station red;
    Station blue;
    Station white;
    Station black;

    Line lineRed;
    Line lineBlue;
    Line lineGreen;

    private static StationIndex stationIndex;
    private static String dataFile = "src/main/resources/map.json";
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {

        route = new ArrayList<>();

        createStationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        lineRed = stationIndex.getLine(1);
        lineBlue = stationIndex.getLine(2);
        lineGreen = stationIndex.getLine(3);

        route.add(stationIndex.getStation("Чернышевская"));
        route.add(stationIndex.getStation("Площадь Восстания"));
        route.add(stationIndex.getStation("Маяковская"));
        route.add(stationIndex.getStation("Гостиный двор"));
        route.add(stationIndex.getStation("Невский проспект"));
        route.add(stationIndex.getStation("Горьковская"));

    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 14.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Академическая"), stationIndex.getStation("Лесная"));
        List<Station> expected = Arrays.asList(new Station("Академическая", lineRed),
                                                new Station("Политехническая", lineRed),
                                                new Station("Площадь Мужества", lineRed),
                                                new Station("Лесная", lineRed));

        Assert.assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
    }

    public void testGetShortestRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Чернышевская"), stationIndex.getStation("Гостиный двор"));
        List<Station> expected = Arrays.asList(new Station("Чернышевская", lineRed),
                                                new Station("Площадь Восстания", lineRed),
                                                new Station("Маяковская", lineGreen),
                                                new Station("Гостиный двор", lineGreen));

        Assert.assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
    }

    public void testGetShortestRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Чернышевская"), stationIndex.getStation("Горьковская"));
        List<Station> expected = Arrays.asList(new Station("Чернышевская", lineRed),
                                                new Station("Площадь Восстания", lineRed),
                                                new Station("Маяковская", lineGreen),
                                                new Station("Гостиный двор", lineGreen),
                                                new Station("Невский проспект", lineBlue),
                                                new Station("Горьковская", lineBlue));

        Assert.assertThat(actual, IsIterableContainingInOrder.contains(expected.toArray()));
    }


    private static void createStationIndex()
    {
        stationIndex = new StationIndex();
        try
        {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseConnections(JSONArray connectionsArray)
    {
        connectionsArray.forEach(connectionObject ->
        {
            JSONArray connection = (JSONArray) connectionObject;
            List<Station> connectionStations = new ArrayList<>();
            connection.forEach(item ->
            {
                JSONObject itemObject = (JSONObject) item;
                int lineNumber = ((Long) itemObject.get("line")).intValue();
                String stationName = (String) itemObject.get("station");

                Station station = stationIndex.getStation(stationName, lineNumber);
                if(station == null)
                {
                    throw new IllegalArgumentException("core.Station " +
                            stationName + " on line " + lineNumber + " not found");
                }
                connectionStations.add(station);
            });
            stationIndex.addConnection(connectionStations);
        });
    }

    private static void parseStations(JSONObject stationsObject)
    {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station((String) stationObject, line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }

    private static void parseLines(JSONArray linesArray)
    {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static String getJsonFile()
    {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
