package Test3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyCalendar {

    private int YEAR = 0;

    Weekend weekend = new Weekend();
    Holidays holidays = new Holidays();

    private ArrayList<GregorianCalendar> list = new ArrayList();

    // вызов метода start запускает ... анализ даты
    public void start(GregorianCalendar date) {

        weekend.weekend(date);
        holidays.holidaysList(list);
        holidays.holidayDay(date);

        System.out.println("********************");
    }

    // Проверка даты: является дата выходным днем или нет
    private class Weekend {

        int Saturday = GregorianCalendar.SATURDAY;
        int Sunday = GregorianCalendar.SUNDAY;

        public void weekend(GregorianCalendar date) {

            System.out.println("Дата - " + date.getTime());
            System.out.println("********************");

            if (Saturday == date.get(Calendar.DAY_OF_WEEK) || Sunday == date.get(Calendar.DAY_OF_WEEK)) {
                System.out.println("Данная дата является выходным днем");
                System.out.println(date.getTime());
            } else System.out.println("Рабочий день");
        }
    }

    // Данный класс содержит праздничные даты
    private class Holidays {

        /*
            Метод содержит праздничные даты, ннекоторые даты приведены условно. Год по умалчанию принят "0"
        т.к. нет необходимости сравнивать год, нас интересует месяц и день
         */
        private ArrayList  holidaysList(ArrayList holidays) {
            holidays.add(new GregorianCalendar(YEAR, Calendar.APRIL, 9));
            holidays.add(new GregorianCalendar(YEAR, Calendar.MAY, 9));
            holidays.add(new GregorianCalendar(YEAR, Calendar.JUNE, 9));

            return holidays;
        }

        // Метод проверяет, является ли данная дата праздничной
        public void holidayDay(GregorianCalendar date) {
            int countResult = 0;
            for(GregorianCalendar dayList : list) {
                if (date.get(GregorianCalendar.MONTH) == dayList.get(GregorianCalendar.MONTH)) {
                    if (date.get(GregorianCalendar.DAY_OF_MONTH) == dayList.get(GregorianCalendar.DAY_OF_MONTH)) {
                        System.out.println("Данная дата является праздничной");
                        countResult++;
                    }
                }
            }
            if(countResult == 0) {
                System.out.println("Данная дата не является праздничной");
            }
        }
    }
}
