package logic.init;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static String getFormattedDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss", Locale.US);
        return simpleFormat.format(date);
    }

    public static String getFormattedDate2(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-dd-MMMM-HH-mm-ss", Locale.US);
        return simpleFormat.format(date);
    }

    public static String getEventDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yy ", Locale.US);
        return simpleFormat.format(date);
    }

    public static String currentDateIR(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        return simpleFormat.format(date);
    }

    public static String currentDateVideo(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return simpleFormat.format(date);
    }

    public static String currentTimeVideo(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH-mm-ss", Locale.US);
        return simpleFormat.format(date);
    }

    public static String formattedCurrentDateIRWeb(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return simpleFormat.format(date);
    }

    public String getDateByDeltaDay(Date date, int day) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day); //good realisation
//        int currentDay = c.get(Calendar.DATE);//bad realisation
//        c.set(Calendar.DATE, currentDay + day);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd MMM", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDateByDeltaDayOnEvent(Date date, int day) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day); //good realisation
//        int currentDay = c.get(Calendar.DATE);//bad realisation
//        c.set(Calendar.DATE, currentDay + day);
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventMinute(Date date, int minute) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventMinute3(Date date, int minute) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("mm", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventHours(Date date, int hours) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hours); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventHours3(Date date, int hours) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hours); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("H", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventHours2(Date date, int hours) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hours); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("HH", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventMinute2(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);SimpleDateFormat simpleFormat = new SimpleDateFormat("mm", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventMinute3(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);SimpleDateFormat simpleFormat = new SimpleDateFormat("m", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventSeconds1(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);SimpleDateFormat simpleFormat = new SimpleDateFormat("ss", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventSeconds2(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);SimpleDateFormat simpleFormat = new SimpleDateFormat("s", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventDays(Date date, int days) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaEventMinuteForIR(Date date, int minute) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("mm", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public String getDeltaIrDay(Date date, int day) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day); //good realisation
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        return simpleFormat.format(c.getTime());
    }

    public Date getDateByDeltaSecond(Date date, int delta) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.SECOND, delta);
        return c.getTime();
    }

    public String getLogDate(Date date) {
        if (date == null) {
            date = new Date();
        }
        SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        return simpleFormat.format(date);
    }
}
        /*сделать массив с проверкой каждого дня на флаг
        поискать теги*/
