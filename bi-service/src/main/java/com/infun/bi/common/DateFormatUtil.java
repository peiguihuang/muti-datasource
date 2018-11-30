package com.infun.bi.common;



import com.infun.bi.exception.BIException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 时间格式
 *
 * @author 黄培桂
 * @create 2018-08-03 14:54
 **/

public class DateFormatUtil {
    static String ymdPattern = "^\\d{4}-\\d{2}\\-\\d{2}$";// "yyyy-MM-dd"
    static String ymdhmsPattern = "^\\d{4}-\\d{2}\\-\\d{2} \\d{2}:\\d{2}:\\d{2}$";//"yyyy-MM-dd HH:mm:ss"
    static  String ymdPattern1 = "^\\d{4}/\\d{2}\\/\\d{2}$";// "yyyy-MM-dd"
    static String ymdhmsPattern1 = "^\\d{4}/\\d{2}\\/\\d{2} \\d{2}:\\d{2}:\\d{2}$";//"yyyy-MM-dd HH:mm:ss"


    public static Date getFormatDate(String dateStr) throws Exception{
        try {


            if (Pattern.matches(ymdhmsPattern, dateStr)){
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
            }
            if (Pattern.matches(ymdPattern, dateStr)){
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            }


            if (Pattern.matches(ymdhmsPattern1, dateStr)){
                return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateStr);
            }
            if (Pattern.matches(ymdPattern1, dateStr)){
                return new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
            }

        }catch (Exception e){
            throw new BIException("时间格式错误！");
        }
        return null;
    }
//    @Test
//    public void test(){
//
//        System.out.println(Pattern.matches(ymdPattern1, "2018/01-14"));
//
//    }
}
