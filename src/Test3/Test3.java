package Test3;

import java.util.GregorianCalendar;

public class Test3 {

    /*
        Задача 3.Создать класс Календарьс внутренним классом, с помощью объектов которого можно хранить информацию о
    выходных и праздничных днях.
     */
    public static void main(String[] args) {

        GregorianCalendar date = new GregorianCalendar();

        // Создадим условную дату и проверем ее на соотвествие к выходным и праздничным дням
        date.set(2020, 3, 9);

        MyCalendar myCalendar = new MyCalendar();

        myCalendar.start(date);
    }
}
