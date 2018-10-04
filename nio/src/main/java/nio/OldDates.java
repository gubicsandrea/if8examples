package nio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class OldDates {
    private static final int OFFSET_HOURS = 5;
    private static final int HOUR_IN_MILLIS = 60 * 60 * 1000;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd. hh:mm:ss X");

    public static void main(String[] args) {
        String[] ids = TimeZone.getAvailableIDs(OFFSET_HOURS * HOUR_IN_MILLIS);
        //System.out.println(Arrays.toString(ids));
        //System.out.println(ids[26]);
        SimpleTimeZone stz = new SimpleTimeZone(OFFSET_HOURS * HOUR_IN_MILLIS, ids[0]);
        Calendar calendar = new GregorianCalendar(stz);
//        System.out.println(calendar);
//        calendar.setTimeInMillis(0);
//        calendar.setTime(time);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " " + calendar.getTimeZone().getDisplayName());
        sdf.setTimeZone(calendar.getTimeZone());
        System.out.println(sdf.format(calendar.getTime()));
        calendar.setTimeZone(new SimpleTimeZone(1 * HOUR_IN_MILLIS, "Europe/Budapest"));
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + " " + calendar.getTimeZone().getDisplayName());
        sdf.setTimeZone(calendar.getTimeZone());
        System.out.println(sdf.format(calendar.getTime()));


    }
}
