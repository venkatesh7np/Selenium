package gmailautomation;

import java.sql.SQLOutput;
import java.sql.Time;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dateandtime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -5);
        Date futuredatetime = calendar.getTime();
        System.out.println("The date is 5 days before from today " + futuredatetime);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy, hh:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        System.out.println("Today's date is " + date1);
    }
}

