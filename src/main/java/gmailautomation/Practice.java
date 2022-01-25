package gmailautomation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Practice {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, +5);
        Date Futuredate = calendar.getTime();
        System.out.println("Future date is " + Futuredate);
    }
}
