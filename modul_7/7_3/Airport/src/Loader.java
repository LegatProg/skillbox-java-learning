import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collection;
import java.util.List;

public class Loader {

    private static Airport airport;
    private static List<Terminal> terminals;
    private static long now;

    private static final int DEPARTURE_IN_HOURS = 2 * 60 * 60 * 1000;

    public static void main(String[] args) {
        airport = Airport.getInstance();
        terminals = airport.getTerminals();

        terminals.forEach(t -> {
            List<Flight> flights = t.getFlights();
            flights.stream()
                    .filter(Loader::isDepartureWithin2Hours)
                    .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                    .forEach(e -> System.out.println(e + " - " + e.getAircraft()));
        });

        System.out.println("------");

        terminals.stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(Loader::isDepartureWithin2Hours)
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .forEach(e -> System.out.println(e + " - " + e.getAircraft()));
    }

    private static boolean isDepartureWithin2Hours(Flight flight) {
        now = System.currentTimeMillis();
        return flight.getDate().getTime() - now <= DEPARTURE_IN_HOURS &&
                flight.getDate().getTime() - now > 0;
    }

}
