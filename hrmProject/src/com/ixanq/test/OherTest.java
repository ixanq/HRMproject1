package com.ixanq.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OherTest {
    public static void main(String[] args) {
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = sdf.format(date);
        Date date1=null;
        try {
             date1 = sdf.parse("2017-12-12 12:12:12");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("date1: "+date1);
        //2017-12-12 12:12:12
        String date4=dateString.substring(0,11);
        String stringMonth=dateString.substring(0,7);
        System.out.println(stringMonth+":stringMonth");
        System.out.println("date4"+date4);
        String day = dateString.substring(8, 10);
        String hour = dateString.substring(11, 13);
        String min = dateString.substring(14, 16);
        System.out.println(sdf.format(date));
        System.out.println(day);
        System.out.println(hour);
        System.out.println(min);*/
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DATE);
        System.out.println(year+" "+month+" "+date);

    }
}
