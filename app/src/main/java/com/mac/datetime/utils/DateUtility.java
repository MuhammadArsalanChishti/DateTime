package com.mac.datetime.utils;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtility {
    public static final String MM_DD_YYYY = "MM/dd/yyyy";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String MMDDYYYY = "MMddyyyy";
    public static final String MM_DD_YYYY_HH_mm_ss = "MM/dd/yyyy HH:mm:ss";
    public static final String MM_DD_YYYY_HH_mm = "MM/dd/yyyy HH:mm";
    public static final String MM_DD_YYYY_hh_mm_a = "MM/dd/yyyy hh:mm a";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String EEE_MMM_DD_HH_MM_SS_ZZZ_YYYY = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static final String MM_DD_YY = "MM/dd/yy";
    public static final String MMMM_DD_YYYY_HH_mm_ss = "MMMM dd,yyyy HH:mm:ss";
    public static final String EEE_MMM_DD_YYYY_HH_MM_SS_ZZZ = "EEE MMM dd yyyy HH:mm:ss zzz Z";
    public static final String EEE_MMM_DD_YYYY_HH_MM_ZZZ = "EEE MMM dd, yyyy HH:mm zzz";
    public static final String hh_mm_a = "hh:mm a";
    public static final String hhmma = "hhmma";
    public static final String YYYY_MM_DD_SLASH = "yyyy/MM/dd";
    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String MM_DD_YY_hh_mm_a = "MM/dd/yy hh:mm a";
    public static final String MM_DD_YYYY_DASH_SEPARATOR = "MM-dd-yyyy";
    //Release: 3.5.0 - Citizen385
    //[04/20/2012�author name] - Added MMMM dd, yyyy date format.
    public static final String MMMM_dd_yyyy = "MMMM dd, yyyy";

    //Release: 3.1.3 - UVT-820
    //[11/28/2011�ASandhu] - Added MM/YYYY date format.
    public static final String MM_YYYY = "MM/yyyy";
    //Release: 3.7.1 - NSP-1073
    //[10/05/2012�tIqbal] - This dash separated time stamp Format is used in reports.
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    //Release: 3.8.3
    //[24/05/2013�author name] - MM-dd-yy date format added.
    public static final String MM_DD_YY_DASH_SEPARATOR = "MM-dd-yy";
    //Release: 4.0.1
    //[23/AUG/2013�author name] - format added
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd hh:mm";

    //Release: 4.4.3 VAS-33
    //[06/13/2016�sauthor name] - format added
    public static final String MM_DD = "MM/dd";

    public static final Date NULL_DATE = getNullDate();
    public static final Date NULL_DATETIME = getNullDateTime();

    public static final String M_d_yy_HMMA = "M/d/yy h:mm a";
    // Release 4.4.5 - AIA-137
    // [wPirwani - 12-09-2016] added date patterns that are missing in date utility
    public static final String dd_MM_yyyy_DASH_SEPERATED = "dd-MM-yyyy";
    public static final String yyyy_MM_dd_T_HH_mm_ss = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String dd_MM_yyyy_hh_mm_aaa_z = "dd-MM-yyyy hh:mm aaa z";
    public static final String MM_dd_yyyy_hh_mm_aaa_z = "MM-dd-yyyy hh:mm aaa z";
    // Release 4.4.6 - AIA-142
    // [sYousuf - 03-03-2017] added date patterns that are missing in date utility
    public static final String YYYYMMDD = "yyyyMMdd";
    // Release 4.4.6 - QC:5539
    // [nAbro - 04-06-2017] added date pattern
    public static final String MM_dd_yyyy_hh_mm_aaa = "MM-dd-yyyy hh:mm aaa";

    // Release: 4.4.8 : ALL-132
    // [10/11/2017 - Ghazala] - added format
    public static final String YYYY_MM_DD_HH_MM_SS_SLASH = "yyyy/MM/dd HH:mm:ss";
    // Release: 4.4.9 : AIA-338
    // [12/04/2017 - Ramsha Khan] - Additional elements required when Collaboration is Required in Closing Instructions Delivered event
    public static final String yyyy_MM_dd = "yyyy-MM-dd";

    public static int getYear(String date) {
        return Integer.parseInt(date.substring(date.length() - 4));
    }

    public static int getCurrentYear(String date) {
        return getYear(date);
    }

    public static int getMonth(String date) {
        Date d = getDate(date, MM_DD_YYYY);
        return getMonth(d);
    }

    public static Date getDate(String date, String formatString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        try {
            simpleDateFormat.applyPattern(formatString);
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Date incrementDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static String incrementDate(String date, int days) {
        SimpleDateFormat df = new SimpleDateFormat(
                MM_DD_YYYY);
        Date d = getDate(date, MM_DD_YYYY);
        return df.format(incrementDate(d, days));

    }

    public static int getMonth(Date date) {
        if (date == null) {
            return 0;
        } // end of if
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.MONTH);
        } // end of try
        catch (Exception e) {
            e.printStackTrace();
        } // end of catch
        return 0;
    } // end of getMonth

    public static int getDay(Date date) {
        if (date == null) {
            return 0;
        } // end of if
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.DAY_OF_MONTH);
        } // end of try
        catch (Exception e) {
            e.printStackTrace();
        } // end of catch
        return 0;
    } // end of getMonth

    public static int getDay(String date) {
        Date d = getDate(date, MM_DD_YYYY);
        return getDay(d);
    }

    public static Long getDateDifferenceInMonths(Date mainDate,
                                                 Date comparingDate) {
        Long diff = null;

        SimpleDateFormat dtMainDateFormat = new SimpleDateFormat(mainDate
                .toString());
        SimpleDateFormat dtComparingDateFormat = new SimpleDateFormat(
                comparingDate.toString());

        if (mainDate != null && comparingDate != null) {
            int firstValue = dtMainDateFormat.getCalendar().get(Calendar.MONTH)
                    + (dtMainDateFormat.getCalendar().get(Calendar.YEAR) * 12);
            int secondValue = dtComparingDateFormat.getCalendar().get(
                    Calendar.MONTH)
                    + (dtComparingDateFormat.getCalendar().get(Calendar.YEAR) * 12);
            int diff1 = firstValue - secondValue;
            diff = new Long(diff1);
        }
        return diff;
    }

    public static final String convertDateToString(Date aDate,
                                                   String formatToBeConverted) {
        SimpleDateFormat df = null;
        String returnValue = "";

        try {
            if (aDate != null) {
                df = new SimpleDateFormat(formatToBeConverted);
                returnValue = df.format(aDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "";
        }

        return (returnValue);
    }

    public static final String convertDateToString(String aDate,
                                                   String aDatePattern, String formatToBeConverted) {
        SimpleDateFormat df = null;
        String returnValue = "";

        try {
            if (aDate != null && !aDate.equals("")) {
                df = new SimpleDateFormat(aDatePattern);
                Date newDate = df.parse(aDate);
                if (newDate != null) {
                    df = new SimpleDateFormat(formatToBeConverted);
                    returnValue = df.format(newDate);
                }
            }
        } catch (Exception e) {
            returnValue = "";
        }

        return (returnValue);
    }

    public static final Date convertDateToDate(Date aDate,
                                               String formatToBeConverted) {
        SimpleDateFormat df = null;
        Date returnValue = null;

        try {

            if (aDate != null) {
                df = new SimpleDateFormat(formatToBeConverted);
                returnValue = df.parse(df.format(aDate));
            }
        } catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }

        return (returnValue);
    }

    public static final Date convertStringToDate(String aDate,
                                                 String aDatePattern, String formatToBeConverted) {
        SimpleDateFormat df = null;
        Date returnValue = null;

        try {
            if (aDate != null && !aDate.equals("")) {
                df = new SimpleDateFormat(aDatePattern);
                Date newDate = df.parse(aDate);
                if (newDate != null) {
                    df = new SimpleDateFormat(formatToBeConverted);
                    returnValue = df.parse(df.format(newDate));
                }
            }
        } catch (Exception e) {
            returnValue = null;
        }

        return (returnValue);
    }

    public static final Date convertStringToDate(String aDate,
                                                 String formatToBeConverted) {
        SimpleDateFormat df = null;
        Date returnValue = null;

        try {
            if (aDate != null && !aDate.equals("")) {
                df =
                        new SimpleDateFormat(formatToBeConverted);

                returnValue = df.parse(aDate);
            }
        } catch (Exception e) {
            returnValue = null;
        }

        return (returnValue);
    }
    public static Date addDays(Date date, int noOfDays) {
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, noOfDays);
        date = c.getTime();

        return date;
    }

    public static Date getNullDateTime() {
        return convertStringToDate("1/1/1870 00:00", MM_DD_YYYY_HH_mm, MM_DD_YYYY_HH_mm);
    }

    public static Date getNullDate() {
        return convertStringToDate("1/1/1870", MM_DD_YYYY, MM_DD_YYYY);
    }

    public static Long getDateDifferenceInDays(Date mainDate,
                                               Date comparingDate) {
        TimeZone timeZone = TimeZone.getDefault();
        Calendar mainDateCalendar = Calendar.getInstance();
        mainDateCalendar.setTime(mainDate);

        Calendar comparingDateCalendar = Calendar.getInstance();
        comparingDateCalendar.setTime(comparingDate);

        if(timeZone.inDaylightTime(mainDate)){
            mainDateCalendar.add(Calendar.HOUR, 1);
        }

        if(timeZone.inDaylightTime(comparingDate)){
            comparingDateCalendar.add(Calendar.HOUR, 1);
        }

        long milliseconds1 = mainDateCalendar.getTimeInMillis();
        long milliseconds2 = comparingDateCalendar.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;

        long diffDays = (diff / (24 * 60 * 60 * 1000));

        return diffDays;
    }

    /**
     * This method adds 1 day in date difference
     *
     */
    public static Long getCompleteDateDifference(Date mainDate,
                                                 Date comparingDate) {
        TimeZone timeZone = TimeZone.getDefault();
        Calendar mainDateCalendar = Calendar.getInstance();
        mainDateCalendar.setTime(mainDate);

        Calendar comparingDateCalendar = Calendar.getInstance();
        comparingDateCalendar.setTime(comparingDate);

        if(comparingDate.after(mainDate)) {
            comparingDateCalendar.add(Calendar.DAY_OF_MONTH, 1);
        } else {
            mainDateCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }


        if(timeZone.inDaylightTime(mainDate)){
            mainDateCalendar.add(Calendar.HOUR, 1);
        }

        if(timeZone.inDaylightTime(comparingDate)){
            comparingDateCalendar.add(Calendar.HOUR, 1);
        }

        long milliseconds1 = mainDateCalendar.getTimeInMillis();
        long milliseconds2 = comparingDateCalendar.getTimeInMillis();
        long diff = milliseconds2 - milliseconds1;

        long diffDays = (diff / (24 * 60 * 60 * 1000));

        return diffDays;
    }

    public static Date getCurrentDate() {

        Date returnValue;
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String currentDate = dateFormat.format(calendar.getTime());
            returnValue = dateFormat.parse(currentDate);
        } catch (Exception e) {
            returnValue = null;
        }

        return returnValue;
    }

    public static Date getCurrentDate(String format) {

        Date returnValue;
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            String currentDate = dateFormat.format(calendar.getTime());
            returnValue = dateFormat.parse(currentDate);
        } catch (Exception e) {
            returnValue = null;
        }

        return returnValue;
    }

    public static Date getNextMonthFirstDate() {
        Date returnValue;
        try {
            Calendar cal = GregorianCalendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date currentMonth = new Date();
            cal.setTime(currentMonth);
            // Add next month
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            String nextMonthAsString = dateFormat.format(cal.getTime());
            returnValue = dateFormat.parse(nextMonthAsString);
        } catch (Exception e) {
            returnValue = null;
        }
        return returnValue;
    }

    public static Date getNextMonthFirstDateByGivenDate(Date givenDate) {
        Date returnValue;
        try {
            Calendar cal = GregorianCalendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date currentMonth = givenDate;
            cal.setTime(currentMonth);
            // Add next month
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            String nextMonthAsString = dateFormat.format(cal.getTime());
            returnValue = dateFormat.parse(nextMonthAsString);
        } catch (Exception e) {
            returnValue = null;
        }
        return returnValue;
    }


    public static Object getDateInXmlGregorianCalendarType(Date value) {

        Object convertedValue = "";
        XMLGregorianCalendar xmlGregorianCalendar = null;

        if (value != null && !"".equals(value)) {
            convertedValue = DateUtility.convertDateToString(value, DateUtility.MM_DD_YYYY);
            convertedValue = DateUtility.getDate(convertedValue.toString(), DateUtility.MM_DD_YYYY);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime((Date) convertedValue);

            try {
                xmlGregorianCalendar = DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(gregorianCalendar);
            } catch (DatatypeConfigurationException e) {
            }
        }

        return xmlGregorianCalendar;

    }
    public static Date checkHolidays(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            calendar.add(Calendar.DATE, 3);
        }else if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            calendar.add(Calendar.DATE, 2);
        }else{
            calendar.add(Calendar.DATE, 1);
        }

        return calendar.getTime();
    }

    public static int getYear(Date date) {
        if (date == null) {
            return 0;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.get(Calendar.YEAR);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String getXmlGregorianCalendarAsString(XMLGregorianCalendar value) {

        String convertedValue = "";

        if (value != null && !"".equals(value)) {

            if (value instanceof XMLGregorianCalendar) {
                Date date = ((XMLGregorianCalendar) value)
                        .toGregorianCalendar().getTime();
                convertedValue = DateUtility.convertDateToString(date,
                        DateUtility.MM_DD_YYYY);
            }
        }
        return convertedValue;
    }

    public static String getFormattedXmlGregorianCalendarAsString(XMLGregorianCalendar value, String format) {

        String convertedValue = "";

        if (value != null && !"".equals(value)) {

            if (value instanceof XMLGregorianCalendar) {
                Date date = ((XMLGregorianCalendar) value)
                        .toGregorianCalendar().getTime();
                convertedValue = DateUtility.convertDateToString(date,format);
            }
        }
        return convertedValue;
    }

    public static Date diff(String date) throws ParseException {

        Calendar cal = Calendar.getInstance();

        // Substract No.of.Year from the calendar(current date)
        int noOfYear = Integer.parseInt(date);
        cal.add(Calendar.YEAR, -noOfYear);
        return convertDateToDate(cal.getTime(), DateUtility.MM_DD_YYYY);
    }

    public static int getDaysBetween (Date d1, Date d2){

        long mills_per_day = 1000 * 60 * 60 * 24;

        long day_diff = ( d2.getTime() - d1.getTime() ) / mills_per_day;
        return (int)day_diff;
    }

    /**
     * This method returns the last date of the current month
     *
     */
    public static Date getLastDayOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int lastDate = calendar.getActualMaximum(Calendar.DATE);
        calendar.set(Calendar.DATE, lastDate);
        return calendar.getTime();
    }

    public static String findDate(String date) {

        SimpleDateFormat checker = new SimpleDateFormat();
        String format = DateUtility.MM_DD_YYYY;
        Date result = new Date();

        ParsePosition pp = new ParsePosition(0);
        checker.applyPattern(format);
        for (int j = 0; j < date.length(); j++) {
            pp.setIndex(j);
            result = checker.parse(date, pp);
            if (result != null) {
                break;
            }
        }
        return DateUtility.convertDateToString(result, DateUtility.MM_DD_YY);
    }
    public static Date getCurrentMonthFirstDate() {
        Date returnValue;
        try {
            Calendar cal = GregorianCalendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date currentMonth = new Date();
            cal.setTime(currentMonth);
            // Add next month
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
            cal.set(Calendar.DAY_OF_MONTH, 1);
            String nextMonthAsString = dateFormat.format(cal.getTime());
            returnValue = dateFormat.parse(nextMonthAsString);
        } catch (Exception e) {
            returnValue = null;
        }
        return returnValue;
    }

    public static Date getCurrentMonthLastDate() {
        Date returnValue;
        try {
            Calendar cal = GregorianCalendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date currentMonth = new Date();
            cal.setTime(currentMonth);
            // Add next month
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));
            int lastDate = cal.getActualMaximum(Calendar.DATE);
            cal.set(Calendar.DAY_OF_MONTH, lastDate);
            String nextMonthAsString = dateFormat.format(cal.getTime());
            returnValue = dateFormat.parse(nextMonthAsString);
        } catch (Exception e) {
            returnValue = null;
        }
        return returnValue;
    }

    public static Date getDateFromHourMin(String strTime) {

        Date endTime = null;
        if (strTime.matches("^([0-1][0-9]|2[0-3]):([0-5][0-9])$")) {
            String[] hourMin = strTime.split(":");
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hourMin[0]));
            gc.set(Calendar.MINUTE, Integer.parseInt(hourMin[1]));
            gc.set(Calendar.SECOND, 0);
            gc.set(Calendar.MILLISECOND, 0);
            endTime = gc.getTime();
        }

        return endTime;
    }

    /**
     * Release: 3.4 - Medallion Issues
     * Author: hraza, Date: 02/29/2012
     * Description: validate the date in the given format
     */
    public static Date parseDate(String date, String formatString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(formatString);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(date);
    }

    public static boolean validateDate(String date, String formatString) {
        boolean validDate = false;
        try {
            parseDate(date, formatString);
            validDate = true;
        } catch (ParseException e) {
            //Do nothing
        }
        return validDate;
    }

    /**
     * Release: 3.8.2 - BSI-19
     * Author: fQadeer, Date: 10/01/2012
     * Description: Method to increment amount in provided date.
     * Unit can MINUTE/HOUR/DAY/SECOND etc. See java.util.Calendar for more details.
     *
     */
    public static Date incrementDate(Date date, int unit, int amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(unit, amount);
        return calendar.getTime();
    }

    /**
     Release: 3.8.2 - BSI-19
     * Author: author name, Date: 01/31/2013
     * Description: date difference in Minutes
     */
    public static float getDateDifferenceInMinutes(Date mainDate, Date comparingDate) {

        TimeZone timeZone = TimeZone.getDefault();
        Calendar mainDateCalendar = Calendar.getInstance();
        mainDateCalendar.setTime(mainDate);

        Calendar comparingDateCalendar = Calendar.getInstance();
        comparingDateCalendar.setTime(comparingDate);

        if(timeZone.inDaylightTime(mainDate)){
            mainDateCalendar.add(Calendar.HOUR, 1);
        }

        if(timeZone.inDaylightTime(comparingDate)){
            comparingDateCalendar.add(Calendar.HOUR, 1);
        }

        long milliseconds1 = mainDateCalendar.getTimeInMillis();
        long milliseconds2 = comparingDateCalendar.getTimeInMillis();
        float diff = milliseconds2 - milliseconds1;

        float diffMinutes = (diff / (60 * 1000));

        return diffMinutes;
    }

    /**
     Release: 3.8.3
     * Author: author name, Date: 24/05/2013
     * Description: convert given string formats to date
     */
    public static final Date convertStringFormatsToDate(String aDate, String... formatsToBeConverted) {

        SimpleDateFormat df = null;
        Date returnValue = null;

        if (aDate != null && !aDate.equals("")) {
            for (String format : formatsToBeConverted) {
                try {
                    df = new SimpleDateFormat(format);
                    returnValue = df.parse(aDate);
                    break;
                } catch (Exception e) {
                    returnValue = null;
                }
            }
        }
        return (returnValue);
    }

    /**
     Release: 4.0.1
     * Author: hRaza, Date: 15/08/2013
     * Description: get current date with time
     */
    public static Date getCurrentDateWithTime() {

        Date returnValue;
        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat(DateUtility.MM_DD_YYYY_HH_mm_ss);
            String currentDate = dateFormat.format(calendar.getTime());
            returnValue = dateFormat.parse(currentDate);
        } catch (Exception e) {
            returnValue = null;
        }

        return returnValue;
    }

    /**
     Release: 4.2.1 - NVT-923
     * Author: nAbro, Date: 04/07/2014
     * Description: get time zone
     */
    public static Integer getTimeZone() {

        Calendar cal = Calendar.getInstance();

        int gmtOffset = cal.getTimeZone().getOffset(cal.get(Calendar.ERA),
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_WEEK),
                cal.get(Calendar.MILLISECOND));

        // convert to hours
        gmtOffset = gmtOffset / (60 * 60 * 1000);

        return gmtOffset;
    }

    /**
     * Release 4.4.2 - NSP-1395
     * Author: rameeshaA, Date: 10/09/2015
     * Description: get past 2.5 year date (1st day of the month)
     * @return
     */
    public static Date getPastTwoAndHalfYear(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -5);
        cal.add(Calendar.YEAR, -2);
        Date date = cal.getTime();
        int month = DateUtility.getMonth(date);
        int year = DateUtility.getYear(date);
        String strDate = month + "/" + "01" + "/" + year;
        Date past_date = DateUtility.getDate(strDate, DateUtility.MM_DD_YYYY);

        return past_date;
    }

    /**
     * Release 4.4.2 - NSP-1395
     * Author: mSiddiqui, Date: 02/11/2015
     * Description: get past 1 Month date (1st day of the month)
     * @return
     */
    public static Date getPastMonth(){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 0);
        Date date = cal.getTime();
        int month = DateUtility.getMonth(date);
        int year = DateUtility.getYear(date);
        String strDate = month + "/" + 1 + "/" + year;
        Date past_date = DateUtility.getDate(strDate, DateUtility.MM_DD_YYYY);

        return past_date;
    }

    /**
     * Release 4.4.2 - QC-3235
     * Author: mSiddiqui, Date: 12/03/2015
     * Description:parse the date and check the year upto 4 digit
     * @return
     */
    public static boolean isDateValid(String date, String formatString){

        boolean values= true;
        Date formattedDate = null;
        /* if check for checking date is null or not*/

        try {
            if(date == null){
                values=false;
            }
            /* Else condition when date is not null*/
            else{
                formattedDate = parseDate(date, formatString);
                int year=getYear(formattedDate);
                /*if check for checking that year is in 4 digits or not */
                if(year < 1000){
                    values=false;
                }else{
                    values=true;
                }
            }

        } catch (ParseException e) {
            values= false;
        }
        return values;
    }

    /**
     * Release 4.4.2 - NSP-1411
     * Author: mSiddiqui, Date: 1/15/2016
     * Description:get previous 30 dates
     * @return
     */
    public static Date get30DaysBackDate(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -29);
        Date today30 = cal.getTime();
        int day = DateUtility.getDay(today30);
        int month = DateUtility.getMonth(today30);
        int year = DateUtility.getYear(today30);
        String strDate = (month+1) + "/" + day + "/" + year;
        Date past_date = DateUtility.getDate(strDate, DateUtility.MM_DD_YYYY);

        return past_date;
    }

    /**
     * Release 4.4.2 - NSP-1411
     * Author: mSiddiqui, Date: 1/15/2016
     * Description:get previous month date
     * @return
     */
    public static Date getPreviousWeekDays(String date){

        SimpleDateFormat dateFormat = new SimpleDateFormat(MM_DD_YYYY);
        Date myDate = null;
        try {
            myDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(myDate);
        // Release 4.4.2 - NSP - 1411
        // [02/02/2016 - mSiddiqui] - change previous week day from sunday to monday.
        cal1.add(Calendar.DAY_OF_YEAR, -6);
        Date previousDate = cal1.getTime();
        return previousDate;

    }

    /**
     * Release 4.4.2 - NSP-1411
     * Author: mSiddiqui, Date: 1/15/2016
     * Description:get last sunday before current date
     * @return
     */
    public static Date getLastSunday(){

        Calendar cal=Calendar.getInstance();
        // Release 4.4.2 - NSP - 1411
        // [02/02/2016 - mSiddiqui] - change previous week day from sunday to monday for From Date.
        cal.add( Calendar.DAY_OF_WEEK, -(cal.get(Calendar.DAY_OF_WEEK)-2));
        Date sunday = cal.getTime();
        int day = DateUtility.getDay(sunday);
        int month = DateUtility.getMonth(sunday);
        int year = DateUtility.getYear(sunday);
        String strDate = (month+1) + "/" + day + "/" + year;
        Date lastSunday = DateUtility.getDate(strDate, DateUtility.MM_DD_YYYY);
        return lastSunday;

    }

    /**
     * Release 4.4.3 - VAS-33
     * Author: sauthor name, Date: 06/12/2016
     * Description:Compare dates according to month and date, ignore year.
     * return true if date1 > date2
     */
    public static boolean compareMonthDayOfDate(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(date1);
        c2.setTime(date2);

        //if month of first argument is greater then month of second argument
        if(c1.get(Calendar.MONTH) > c2.get(Calendar.MONTH)
                || (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)
                && c1.get(Calendar.DAY_OF_MONTH) > c2.get(Calendar.DAY_OF_MONTH))) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Release 4.4.3 - AIA-45
     * Author: sYousuf, Date: 08/18/2016
     * Description:get time zone in mismo format
     * @return string
     */
    // Release: 4.4.7 - AIA-186
    // [05/05/2017 - mAhsan] - added a new parameter date
    public static String getMismoTimeZone(Date date) {

        Calendar cal = Calendar.getInstance();
        // Release: 4.4.7 - AIA-186
        // [05/05/2017 - mAhsan] - setting date.
        cal.setTime(date);
        String numberAsString = "";

        int gmtOffset = cal.getTimeZone().getOffset(cal.get(Calendar.ERA),
                cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_WEEK),
                cal.get(Calendar.MILLISECOND));

        // convert to hours
        gmtOffset = gmtOffset / (60 * 60 * 1000);

        if(gmtOffset > 0){
            numberAsString = String.format ("%0+3d", gmtOffset);
        } else{
            numberAsString = String.format ("%03d", gmtOffset);
        }

        return numberAsString;
    }
    /**
     * Release 4.4.5 - time should be in proper format
     * Author: faizanK, Date: 12/27/2016
     * Description:get time of valid format including timezone
     * @return string
     */
    public static final String convertStringToTime(String aDate, String formatToBeConverted) {

        SimpleDateFormat df = null;
        Date returnValue = null;
        String finalDate = "";
        Date currentDate =DateUtility.getCurrentDate();
        String currentsDate = DateUtility.convertDateToString(currentDate, DateUtility.YYYY_MM_DD);
        aDate = currentsDate.concat(" " + aDate);
        try {
            if (aDate != null && !aDate.equals("")) {
                df = new SimpleDateFormat(formatToBeConverted);

                returnValue = df.parse(aDate);
                finalDate =  DateUtility.convertDateToString(returnValue, DateUtility.MM_dd_yyyy_hh_mm_aaa_z);
                finalDate = finalDate.substring(11, finalDate.length());
            }

        } catch (Exception e) {
            finalDate = null;
        }

        return (finalDate);
    }

    /**
     * Release 4.4.5 - AIA-136
     * Author: sauthor name, Date: 01/16/2017
     * Description:get Diffenence in minutes from current time
     * @return string
     */
    public static final long getDifferneceInMinFromCurrentDate(Date date) {
        long minutes = 0;
        if (date != null) {
            // Release 4.4.5 AIA-131
            // [wPirwani - 18-01-2017] changed getCurrentDate to getCurrentDateWithTime so that it may fetch the time along with the date hence may calculate the difference properly
            Date cuttentDate = getCurrentDateWithTime();

            long diff = cuttentDate.getTime() - date.getTime();
            minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        }
        return minutes;
    }

    /**
     * Release 4.4.6 - AIA-134
     * Author: mSiddiqui, Date: 02/20/2017
     * Description:Method made in order to validate and format date for export action
     * @return string
     */
    public static String validateAndFormatDate(Date paramDate) {
        String date = "";
        if (paramDate != null) {
            date = DateUtility.convertDateToString(paramDate.toString(), DateUtility.YYYY_MM_DD_HH_MM_SS,
                    DateUtility.MM_DD_YYYY_HH_mm_ss);
        }
        return date;
    }

    /**
     * Release: 4.4.5
     * Author: wPirwani,
     * Date: 02/16/2017
     * Description: Method to return start date of a year's daylight saving
     */
    public static final Date getSecondSundayOfMarch (int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH,2);
        cal.set(Calendar.MONTH, Calendar.MARCH);
        return cal.getTime();
    }

    /**
     * Release: 4.4.5
     * Author: wPirwani,
     * Date: 02/16/2017
     * Description: Method to return end date of a year's daylight saving
     */
    public static final Date getFirstSundayOfNovember (int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cal.set(Calendar.DAY_OF_WEEK_IN_MONTH,1);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);


        return cal.getTime();
    }
}
