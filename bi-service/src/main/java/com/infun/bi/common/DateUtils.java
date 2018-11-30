package com.infun.bi.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang.StringUtils;

public class DateUtils {
    public static final String DEFAULT_TIME_FORMAT_DB = "yyyy-MM-dd HH:mm:ss";
    public static String FORMAT_SHORT = "yyyy-MM-dd";
    /**
     * @Title: getCurrentDateString
     * @Description: 得到当前日期字符串:yyyymmdd
     * @return String:yyyyMMdd
     * @throws
     */
    public static String getCurrentDateString() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        return "" + calendar.get(Calendar.YEAR)
                + (month < 10 ? "0" + month : "" + month)
                + (date < 10 ? "0" + date : "" + date);
    }

    /**
     * @Title: getCurrentDateTimeString
     * @Description: 得到当前日期字符串:yyyyMMddHHmmss
     * @return String:yyyyMMddHHmmss
     * @throws
     */
    public static String getCurrentDateTimeString() {
        return getDifferentTime(0);
    }

    /**
     * @Title: getCurrentDate
     * @Description: 得到当前日期字符串,适用于数据库为Date类型，yyyyMMddHHmmss
     * @return Date:yyyyMMddHHmmss
     * @throws
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    // 判断两日期格式是否相等
    public static boolean isDateEqual(Date date1, Date date2) {

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return (cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2
                .get(Calendar.MONTH) && cal1
                .get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH));

    }



    // 将格式为“20060302”形式的字符串转换成日期类型yyyy-MM-dd
    public static Date getToDate(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(0, 4)).append("-").append(s.substring(4, 6))
                .append("-").append(s.substring(6, 8));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date obj = null;
        try {
            obj = sdf.parse(sb.toString());
        } catch (ParseException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
            System.err.println("change date type error");
        }
        return obj;
    }

    // 将格式为“2006-02-23”的日期字符串转化为日期类型
    /**
     * 将格式为“2006-02-23”的日期字符串转化为日期类型 格式为"2004-10-10" --> Date
     * <p>
     * <code> checkStartEndDate </code>
     * </p>
     *
     * @param
     * @throws ValidationException
     * @since 1.1
     */
    public static Date getString2Date(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date obj = null;

        try {
            obj = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("change date type error");
        }

        return obj;
    }

    // 判断当前的字符串是否为当前日期
    public static boolean isCurrentDate(String strDate) {
        return strDate == null || !strDate.equals(getCurrentDateString()) ? false
                : true;
    }

    // 取当前日期前一天或后一天，up传true表示取当前的前一天，up传false表示取当前日期的后一天
    public static String rollDate(Date date, boolean up) {

        if (date == null)
            return null;

        GregorianCalendar beforeCalendar = new GregorianCalendar();
        beforeCalendar.setTime(date);
        beforeCalendar.add(Calendar.DATE, up ? +1 : -1);
        int beforeDate = beforeCalendar.get(Calendar.DATE);
        int beforeMonth = beforeCalendar.get(Calendar.MONTH) + 1;
        int beforeYear = beforeCalendar.get(Calendar.YEAR);

        return "" + beforeYear
                + (beforeMonth < 10 ? "0" + beforeMonth : "" + beforeMonth)
                + (beforeDate < 10 ? "0" + beforeDate : "" + beforeDate);

    }

    // 返回年月日方式或者年月日时分方式对应的日期时间
    /**
     * @param str
     * @return
     */
    public static Date String2Date(String str) {
        try {
            SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMdd");
            SimpleDateFormat s2 = new SimpleDateFormat("yyyyMMddHHmm");

            if (str.length() == 8) {
                return s1.parse(str);
            } else if (str.length() == 12) {
                return s2.parse(str);
            } else {
                throw new RuntimeException("validation.date.parse_error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("adsasd");
        }

    }

    // 比较2个日期：返回－1，1，0
    /**
     * @param StartDate
     * @param EndDate
     * @return
     */
    public static int DateCompare(String StartDate, String EndDate) {

        Date start = String2Date(StartDate);
        Date end = String2Date(EndDate);

        if (start.before(end)) {
            return -1;
        } else if (start.after(end)) {
            return 1;
        } else
            return 0;

    }

    public static long getDiffMinutes(Date startDate,Date endDate){

        long l = endDate.getTime() - startDate.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)));
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);

        return min;
    }
    // 比较2个时间：返回－1，1，0
    /**
     * @param StartTime
     * @param EndTime
     * @return
     */
    public static int TimeCompare(String StartTime, String EndTime) {

        if ((StartTime.length() != 4) || (EndTime.length() != 4)) {
            throw new RuntimeException("validation.time.parse_error");
        }
        int startHour = Integer.parseInt(StartTime.substring(0, 2));
        int startMin = Integer.parseInt(StartTime.substring(2, 4));
        int endHour = Integer.parseInt(EndTime.substring(0, 2));
        int endMin = Integer.parseInt(EndTime.substring(2, 4));

        if (startHour < endHour) {
            return -1;
        } else if (startHour > endHour) {
            return 1;
        } else {
            if (startMin < endMin) {
                return -1;
            } else if (startMin > endMin) {
                return 1;
            } else
                return 0;
        }

    }
    /**
     * 获得从nowOrFutureDate开始days的一天
     * @nowOrFutureDate
     * 			 日期
     * @param days
     *           推迟天数,0表示当前时间
     * @return String
     */
    public static  Date getDateAfterDay(Date nowOrFutureDate, int days )
    {

        Calendar ca = Calendar.getInstance();
        ca.setTime(nowOrFutureDate);
        ca.add(Calendar.DAY_OF_YEAR, days);	//增加天数

        return ca.getTime();//得到增加后的时间
    }

    // 获得从now开始iMonth个月前的一天
    /**
     * @param now
     * @param iMonth
     * @return
     */
    public static Date getDateBefore(Date now, int iMonth) {

        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        month = month - iMonth;
        if (month < 1) {
            month = month + 12;
            year = year - 1;
        }

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        return c.getTime();
    }

    // 获得从now开始iMonth个月后的一天
    /**
     * @param now
     * @param iMonth
     * @return
     */
    public static Date getDateAfter(Date now, int iMonth) {

        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        month = month + iMonth;
        if (month > 12) {
            month = month - 12;
            year = year + 1;
        }

        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);

        return c.getTime();
    }

    public static Date getLastDay(Date now) {

        Calendar c = Calendar.getInstance();
        c.setTime(now);
        int day = c.get(Calendar.DAY_OF_MONTH);
        c.set(Calendar.DAY_OF_MONTH, day - 1);

        return c.getTime();
    }

    // 得到当前日期的开始时间
    /**
     * 得到当前日期的开始时间
     *
     * @param now
     * @return
     */
    public static Date getDayStart(Date now) {
    	if(now==null)
    		return null;
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    // 得到当前日期的结束时间
    /**
     * 得到当前日期的结束时间
     *
     * @param now
     * @return
     */
    public static Date getDayEnd(Date now) {
    	if(now==null)
    		return null;
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);

        return c.getTime();
    }

    // 判断输入的日期是否符合要求，1、3、5、7、8、10、12月日期不能大于31日，4、6、9、11月不能日期不能大于30日，2月平年不能大于28日，润年不能大于29日
    public static boolean isDateValid(String inStr) {
        int year, month, day;
        year = Integer.parseInt(inStr.substring(0, 4));
        if (inStr.indexOf(4) == '0') {
            month = Integer.parseInt(inStr.substring(5, 6));
        } else {
            month = Integer.parseInt(inStr.substring(4, 6));
        }
        if (inStr.indexOf(6) == '0') {
            day = Integer.parseInt(inStr.substring(7, 8));
        } else {
            day = Integer.parseInt(inStr.substring(6, 8));
        }

        if (month > 12 || day > 31 || month < 1 || day < 1)
            return false;

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30)
                return false;
        }

        if (month == 2) {
            if (year % 4 == 0) {
                if (day > 29)
                    return false;
            } else {
                if (day > 28)
                    return false;
            }
        }

        return true;
    }

    /**
     * 取得指定时间间隔后的系统时间
     *
     * @param hour
     *            小时
     * @return String
     */
    public static  String getDifferentTime( int hour )
    {
        GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
        calendar.add( Calendar.HOUR, hour );
        SimpleDateFormat formatter = new SimpleDateFormat( DEFAULT_TIME_FORMAT_DB );
        return formatter.format( calendar.getTime() );
    }
    /**
     * 取得指定时间间隔后的系统时间
     *
     * @param second
     *            秒
     * @return String
     */
    public static  String getDifferentTimeSecond( int second )
    {
        GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
        calendar.add( Calendar.SECOND, second );
        SimpleDateFormat formatter = new SimpleDateFormat( DEFAULT_TIME_FORMAT_DB );
        return formatter.format( calendar.getTime() );
    }
    /**
     * 取得指定时间间隔后的系统时间
     *
     * @param
     *
     * @return Date
     */
    public static  Date getDifferentDateTimeSecond( int second )
    {
        GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
        calendar.add( Calendar.SECOND, second );
        return calendar.getTime() ;
        //nowDate要计算增加的时间
        //Calendar ca = Calendar.getInstance();
        //ca.setTime(nowDate);
        //ca.add(Calendar.DAY_OF_YEAR, 20);	//增加天数
        //ca.getTime()得到增加后的时间

    }

    /**
     * 取得指定时间间隔后的系统时间
     *
     * @param minutes
     *
     * @return String
     */
    public static  String getDifferentTimeByMinute( int minutes )
    {
        GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
        calendar.add( Calendar.MINUTE, minutes);
        SimpleDateFormat formatter = new SimpleDateFormat( DEFAULT_TIME_FORMAT_DB );
        return formatter.format( calendar.getTime() );
    }

    /**
     * 取得若干天前/后的系统日期
     *
     * @param days
     *            与现在相隔的日数，正数为当前日期之后，负数为当前日期之前
     * @return String
     */
    public static String getDifferentDate(int days) {
        return getDifferentTime(24 * days);
    }
    /**
     * 比较日期时间
     *
     *
     */
    public static int dateTimeCompare(String date1,String date2) {

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat( DEFAULT_TIME_FORMAT_DB );
        try {
            cal1.setTime(formatter.parse(date1));
            cal2.setTime(formatter.parse(date2));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int result=cal1.compareTo(cal2);
        return result;
    }
    
    /**时间格式转换
	 * 
	 * @param paramDate
	 * @return
	 */
	public static Date getDateParse(String paramDate){
		Date date=null;
		String d="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(paramDate!=null && !"".equals(paramDate)){
			if(paramDate.length()==14){
				d=paramDate.substring(0, 4)+"-"+paramDate.substring(4, 6)+"-"+paramDate.substring(6, 8)+" "+paramDate.substring(8, 10)+":"+paramDate.substring(10, 12)+":"+paramDate.substring(12, 14);
				try {
					date=sdf.parse(d);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return date;
	}

    /**
     *
     * @Title: parseDate
     * @Description: 把字符串解析为日期
     * @param dateStr
     * @param format
     * @return Date
     */
    public static Date parseDate(String dateStr, String format) {

        Date date = null;
        try {
            DateFormat df = new SimpleDateFormat(format);
            date = (Date) df.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return date;
    }

    /**
     * @Title: format
     * @Description: 把日期格式化输出为字符串
     * @param date
     * @param format
     * @return String
     */
    public static String format(Date date, String format) {
        String result = "";
        try {
            if (date != null) {
                DateFormat df = new SimpleDateFormat(format);
                result = df.format(date);
            }
        } catch (Exception e) {
        }
        return result;
    }

    /**
     *
     * @Title: getMillis
     * @Description: 返回当前毫秒
     * @param date
     * @return
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * @Title: diffDate
     * @Description: 两个日期相差几天
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public static int diffDate(Date dateStart, Date dateEnd) {
        return (int) ((getMillis(dateStart) - getMillis(dateEnd)) / (24 * 3600 * 1000));
    }

    /**
     * 昨天
     * @param c
     * @return
     */
    public static Calendar yesterday(Calendar c){
        long offset = 1*24*60*60*1000;
        Calendar calendar = null;
        if(c != null){
            calendar = c;
        }else{
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
        return calendar;
    }

    /**
     * 明天
     * @param c
     * @return
     */
    public static Calendar tomorrow(Calendar c){
        long offset = 1*24*60*60*1000;
        Calendar calendar = null;
        if(c != null){
            calendar = c;
        }else{
            calendar = Calendar.getInstance();
        }

        calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
        return calendar;
    }

    /**
     * 格式化日期  yyyy-MM-dd
     * @return
     */
    public static Date getFormatDate(Date date, String format) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            returnValue = df.format(date);
        }
        return getString2Date(returnValue);
    }
    
    /**
     * 日期格式化yyyy-MM-dd
     * 
     * @param date
     * @return
     */
    public static Date formatDate(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取昨天日期
     * @return
     */
    public static String getYesterDay(){
        Calendar calendar = Calendar.getInstance();//此时打印它获取的是系统当前时间
        calendar.add(Calendar.DATE, -1);    //得到天昨天日期
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    }
    /**
     * 获取当前时间到毫秒
     * @return
     */
    public static String getCurrentDateInstance(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");//HHmmss
		Date date = new Date();
		String dateString = sdf.format(date);
    	return dateString;
    }
    
    /**
     * 日期格式化
     * 
     * @param date
     * @param 格式类型
     * @return
     */
    public static String getDateFormat(Date date, String formatStr) {
        if (StringUtils.isNotBlank(formatStr)) {
            return new SimpleDateFormat(formatStr).format(date);
        }
        return null;
    }
    
    /**
     * 获取当前时间到毫秒 yyyyMMddHHmmss.SSS
     * @return
     */
    public static String getCurrentDateInstance2(){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss.SSS");//HHmmss
		Date date = new Date();
		String dateString = sdf.format(date);
    	return dateString;
    }
    
    /**
     * 获取当前时间到毫秒 yyyyMMddHHmmss.SSS
     * @return
     */
    public static String getDateInstance(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_TIME_FORMAT_DB);
    	return sdf.format(date);
    }
    
   /**
    * 比较时间大小
    * @param time 时间
    * @param tdoa 时间差
    * @return
    */
    public static boolean getCheckLongTime(Long time,Long tdoa){
    	Long currentTime = new Date().getTime();
    	return currentTime - time > tdoa;
    }

    /**
     * 将格式为“2006-02-23”的日期字符串转化为日期类型 格式为"2004-10-10" --> Date
     * <p>
     * <code> checkStartEndDate </code>
     * </p>
     *
     * @param
     * @throws ValidationException
     * @since 1.1
     */
    public static Date getStringToDate(String sDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date obj = null;

        try {
            obj = sdf.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("change date type error");
        }

        return obj;
    }

}
