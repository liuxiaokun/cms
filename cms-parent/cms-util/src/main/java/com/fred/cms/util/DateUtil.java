package com.fred.cms.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.util.StringUtils;

import com.fred.cms.constant.CommonConstant;

public final class DateUtil {

    private static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

    private DateUtil() {
        // empty
    }

    public static boolean checkIfAfterToday(final Date date) {

        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        calendarDate.set(Calendar.HOUR_OF_DAY, 0);
        calendarDate.set(Calendar.MINUTE, 0);
        calendarDate.set(Calendar.SECOND, 0);
        calendarDate.set(Calendar.MILLISECOND, 0);

        Calendar calendarNow = Calendar.getInstance();
        calendarNow.set(Calendar.HOUR_OF_DAY, 0);
        calendarNow.set(Calendar.MINUTE, 0);
        calendarNow.set(Calendar.SECOND, 0);
        calendarNow.set(Calendar.MILLISECOND, 0);

        return calendarDate.after(calendarNow);
    }

    public static String formatDate(final Date date, final String dateFormat) {
        return formatDate(date, dateFormat, DEFAULT_LOCALE);
    }

    public static String formatDate(final Date date, final String dateFormat, final Locale locale) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.isEmpty(dateFormat) ? CommonConstant.DATE_FORMAT_LONG
                : dateFormat, (null == locale) ? locale : DEFAULT_LOCALE);
        return sdf.format(date);
    }

    public static Timestamp formatDateString(final String dateStr, final String dateFormat) {

        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.isEmpty(dateFormat) ? CommonConstant.DATE_FORMAT_LONG
                : dateFormat);
        Timestamp ts = null;

        try {
            ts = new Timestamp(sdf.parse(dateStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ts;
    }
}