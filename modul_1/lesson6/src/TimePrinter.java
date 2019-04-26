import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePrinter {
    public static void main(String[] args) {
//        15:30 28.08.2015
        SimpleDateFormat df = new SimpleDateFormat("HH:mm dd.MM.YYYY");
        System.out.println(df.format(new Date()));
    }
}
