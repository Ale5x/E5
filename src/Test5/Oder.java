package Test5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Oder {

    private int price;

    private List<String> bouquetOfFlowersList = new ArrayList();

    Calendar date = new GregorianCalendar();

    Flowers flowers = new Flowers();
    Box box = new Box();

    // Оформление заказа
    public void payment() {

        flowers.bouquetOfFlowers(bouquetOfFlowersList);
        box.box();
        System.out.println("\n**********************\n");
        System.out.println("Ваш букет содержит цветы: ");

        for(String flowers : bouquetOfFlowersList) {
            System.out.print(flowers + " | ");
        }

        System.out.println();
        System.out.println("\nБукет упакован в упаковку - " + box.getBox());
        price = flowers.getFlowerPriceSum() + box.getPrice();
        System.out.println("\nСтоимость букета " + price + " $" + "\n");
        System.out.println(date.getTime());
    }
}
