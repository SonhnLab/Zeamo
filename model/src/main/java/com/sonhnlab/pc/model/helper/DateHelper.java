package com.sonhnlab.pc.model.helper;

import android.support.annotation.StringDef;
import android.util.LruCache;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class DateHelper {

    //region Property

    public static final String YYYY_MM_DD           = "yyyy-MM-dd";
    public static final String MMM_DD_YYYY          = "MMM dd, yyyy";
    public static final String DD_MMM               = "dd MMM";
    public static final String DD_MMM_YYYY          = "dd MMM yyyy";
    public static final String YYYY_MM_DD_HH_MM_SS  = "yyyy-MM-dd HH:mm:ss";


    private static final LruCache<String, SimpleDateFormat> sCache = new LruCache<>(4);

    private enum WeekDay {
        MON, TUE, WED, THU, FRI, SAT, SUN;
    }

    private enum Month {
        JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            AM, PM
    })
    private @interface DayPeriod {}
    private static  final String AM = "AM";
    private static  final String PM = "PM";


    //endregion

    //region Constructor

    private DateHelper() {

    }

    //endregion

    //region Public method

    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static Date dateTimeToDate(Date dateTime, String format) {
        SimpleDateFormat dateFormat = validInitialize(format);
        String dateString = dateToString(dateTime, format);

        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateTime;
    }

    public static String dateToString(Date date, String format) {
        SimpleDateFormat dateFormat = validInitialize(format);
        return dateFormat.format(date);
    }

    public static String dateToString(Date date) {
        Calendar calendar = Calendar.getInstance();

        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.setTime(date);

        long diffTime = currentCalendar.getTimeInMillis() - calendar.getTimeInMillis();
        if (diffTime < getPassedTimeOfDay(currentCalendar)) {
            return getTimeIdentity(currentCalendar);
        } else if (diffTime < getPassedTimeOfWeek(currentCalendar)) {
            return getWeekDayIdentity(WeekDay.values()[currentCalendar.get(Calendar.DAY_OF_WEEK)])
                    + " AT " + getTimeIdentity(currentCalendar);
        } else if (diffTime < getPassedTimeOfYear(currentCalendar)) {
            return getMonthIdentity(Month.values()[currentCalendar.get(Calendar.MONTH)])
                    + " " + currentCalendar.get(Calendar.DATE)
                    + " AT " + getTimeIdentity(currentCalendar);
        }
        else {
            return currentCalendar.get(Calendar.YEAR)
                    + " " + getMonthIdentity(Month.values()[currentCalendar.get(Calendar.MONTH)])
                    + " " + currentCalendar.get(Calendar.DATE)
                    + " AT " + getTimeIdentity(currentCalendar);
        }
    }

    public static int getDays(Date startDate, Date endDate) {
        long diff = endDate.getTime() - startDate.getTime();
        if (diff > 0) {
            return (int) (diff / (1000 * 60 * 60 * 24));
        }
        return (int) diff;
    }

    public static int getMonths(Date startDate, Date endDate) {
        long millis = endDate.getTime() - startDate.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.get(Calendar.MONTH);
    }

    public static int getDaysRemaining(Date endDate) {
        Date today = dateTimeToDate(DateHelper.getToday(), YYYY_MM_DD);
        int days = getDays(today, endDate);
        if (days < 0) {
            days = 0;
        }
        return days;
    }

    public static int getTimer(int timer, Date date) {
        Date date1 = getToday();
        long todayTime = date1.getTime();
        long endTime = date.getTime();
        long timeLeft = (timer * 60) - ((todayTime - endTime) / 1000);

        return (int) (timeLeft / 60);
    }

    public static String getTime(long position) {
        int totalSeconds = (int) (position / 1000);

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        if (hours > 0) {
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        }
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

    //endregion

    //region Private method

    private static SimpleDateFormat validInitialize(String format) {
        SimpleDateFormat dateFormat = sCache.get(format);
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(format, Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getDefault());
            sCache.put(format, dateFormat);
        }
        return dateFormat;
    }

    private static long getPassedTimeOfDay(Calendar calendar) {
        Calendar startDate = Calendar.getInstance();
        startDate.clear();

        startDate.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar.getTimeInMillis() - startDate.getTimeInMillis();
    }

    private static long getPassedTimeOfWeek(Calendar calendar) {
        Calendar firstDayOfWeek = Calendar.getInstance();
        firstDayOfWeek.clear();

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        firstDayOfWeek.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE) - dayOfWeek, 0, 0, 0);

        return calendar.getTimeInMillis() - firstDayOfWeek.getTimeInMillis();
    }

    private static long getPassedTimeOfYear(Calendar calendar) {
        Calendar firstDateOfYear = Calendar.getInstance();
        firstDateOfYear.clear();
        firstDateOfYear.set(calendar.get(Calendar.YEAR), 1, 1, 0, 0, 0);

        return calendar.getTimeInMillis() - firstDateOfYear.getTimeInMillis();
    }

    private static String getWeekDayIdentity(WeekDay weekDay) {
        return weekDay.name();
    }

    private static String getMonthIdentity(Month month) {
        return  month.name();
    }

    private static String getTimeIdentity(Calendar calendar) {
        if (calendar.get(Calendar.HOUR_OF_DAY) < 12) {
            return String.format(Locale.getDefault(), "%02d:%02d", calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE))
                    + " " + AM;
        } else {
            return String.format(Locale.getDefault(), "%02d:%02d", calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE))
                    + " " + PM;
        }
    }

    //endregion
}
