package demo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static boolean dateInRange(Date d){

        Long nowTimeMillis = System.currentTimeMillis();

        Date now = new Date(nowTimeMillis);

        Date nowMinusOne = new Date(nowTimeMillis - TimeUnit.HOURS.toMillis(1));

        return d.before(now) && d.after(nowMinusOne);
    }
}
