import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Loader {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Aircraft> list = airport.getAllAircrafts();

        System.out.println(list.size());

        for (Aircraft aircraft : list){
            System.out.println(aircraft.getModel());
        }
    }
}
