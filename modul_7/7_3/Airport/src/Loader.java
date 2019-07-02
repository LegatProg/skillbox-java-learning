import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.List;

public class Loader {

    private static Airport airport;
    private static List<Terminal> terminals;
    private static long now;

    private static final int OFFSET = 2 * 60 * 60 * 1000;

    public static void main(String[] args) {
        airport = Airport.getInstance();
        terminals = airport.getTerminals();

        now = System.currentTimeMillis();

        terminals.forEach(t -> {
            List<Flight> flights = t.getFlights();
            flights.stream()
                    .filter(f -> (f.getDate().getTime() - now <= OFFSET) &&
                                    f.getDate().getTime() - now > 0 &&
                                    f.getType().equals(Flight.Type.DEPARTURE))
                    .forEach(e -> System.out.println(e + " - " + e.getAircraft()));
        });
    }

}
