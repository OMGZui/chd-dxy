package com.e.dxy.medium;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <p></p>
 *
 * @author omgzui
 * @date 7/1/22 4:51 PM
 */
public class Hello {

    public static void main(String[] args) {
        method01();
        method02();
        method03();
        method04();
    }

    private static void method01() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = format.parse("2022-08-10");
            Date endDay = format.parse("2022-08-17");
            Long starTime = startDay.getTime();
            Long endTime = endDay.getTime();
            long num = endTime - starTime;
            System.out.println("method01 Diff Days is：" + num / 24 / 60 / 60 / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void method02() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = format.parse("2022-08-10");
            Date endDay = format.parse("2023-08-10");
            Date nextDay = startDay;
            int i = 0;
            while (nextDay.before(endDay)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(startDay);
                calendar.add(Calendar.DATE, 1);
                startDay = calendar.getTime();
                nextDay = startDay;
                i++;
            }
            System.out.println("method02 Diff Days is：" + i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void method03() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = format.parse("2022-08-10");
            Date endDay = format.parse("2022-08-17");

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(startDay);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(endDay);

            int day1 = cal1.get(Calendar.DAY_OF_YEAR);
            int day2 = cal2.get(Calendar.DAY_OF_YEAR);

            int year1 = cal1.get(Calendar.YEAR);
            int year2 = cal2.get(Calendar.YEAR);
            if (year1 != year2) {
                int timeDistance = 0;
                for (int i = year1; i < year2; i++) {
                    if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                        timeDistance += 366;
                    } else {
                        timeDistance += 365;
                    }
                }
                System.out.println("method03 Diff Days is：" + timeDistance + (day2 - day1));
            } else {
                System.out.println("method03 Diff Days is：" + (day2 - day1));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void method04() {
        System.out.println("method04 Diff Days is：" + ChronoUnit.DAYS.between(LocalDate.of(2022, 8, 10),
                LocalDate.of(2022, 8, 17)));

    }

}
