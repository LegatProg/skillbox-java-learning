import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Loader {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);
        calendar.set(1985, Calendar.OCTOBER, 31);
        Date birthDate;
        int count = 0;
        while (calendar.getTime().before(new Date())) {
            birthDate = calendar.getTime();
            System.out.println(count + " - " + df.format(birthDate));
            calendar.add(Calendar.YEAR, 1);
            count++;
        }
    }
}
