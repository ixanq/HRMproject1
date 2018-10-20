package com.ixanq.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OherTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateString = sdf.format(date);
        //2017-12-12 12:12:12
        String day = dateString.substring(8, 10);
        String hour = dateString.substring(11, 13);
        String min = dateString.substring(14, 16);
        System.out.println(sdf.format(date));
        System.out.println(day);
        System.out.println(hour);
        System.out.println(min);

    }
}
