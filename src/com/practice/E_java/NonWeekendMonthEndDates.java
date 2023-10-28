package com.practice.E_java;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by prathapchowdary on 29/03/23.
 */
public class NonWeekendMonthEndDates {
    public static void main(String[] args) {
        LocalDate fromlocalDate=LocalDate.of(2021,1,8);
        LocalDate tolocalDate=LocalDate.of(2023,1,8);
        LocalDate currentMonthLastDay=LocalDate.of(fromlocalDate.getYear(),fromlocalDate.getMonthValue(),fromlocalDate.lengthOfMonth());
        while(tolocalDate.isAfter(currentMonthLastDay)){
            currentMonthLastDay=LocalDate.of(fromlocalDate.getYear(),fromlocalDate.getMonthValue(),fromlocalDate.lengthOfMonth());
            currentMonthLastDay=currentMonthLastDay.minusDays(getDiff(currentMonthLastDay));
            System.out.println(currentMonthLastDay);
            fromlocalDate= currentMonthLastDay.plusMonths(1);
        }

    }
    public static int getDiff(LocalDate date){
        if(date.getDayOfWeek()== DayOfWeek.SUNDAY) return 2;
        if(date.getDayOfWeek()==DayOfWeek.SATURDAY) return 1;
        return 0;
    }

    //other way
    /**
     * Created by prathapchowdary on 29/03/23.
     */
    public static void monthEndDates() {
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2023, 12, 31);

        List<LocalDate> weekDays = countBusinessDaysBetweenDates(date1, date2);
        System.out.println(weekDays);

        List<LocalDate> result = new ArrayList<>();
        getMonthEndDates(weekDays, result);
        System.out.println(result);
    }

    private static void getMonthEndDates(List<LocalDate> weekDays, List<LocalDate> result) {
        Integer m = null;
        LocalDate prevDay = null;
        for (LocalDate d : weekDays) {
            if (m == null) {
                m = d.getMonthValue();
            } else {
                int currM = d.getMonthValue();
                if (m != currM) {
                    result.add(prevDay);
                    m = currM;
                }
            }
            prevDay = d;
        }
        result.add(prevDay);
    }

    private static List<LocalDate> countBusinessDaysBetweenDates(LocalDate startDate,
                                                                 LocalDate endDate) {
        endDate = endDate.plusDays(1);
        Predicate<LocalDate> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(daysBetween)
                .filter(isWeekend.negate())
                .collect(Collectors.toList());
    }
}