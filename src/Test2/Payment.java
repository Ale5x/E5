package Test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Payment {

    List<Oder> list = new ArrayList<>();
    OderList oderList = new OderList();


    public void start() {
        oderList.initializeList(list);
        oderList.setList(list);
        outputOderList(list);
    }

    // Вывод всего списка
    public void outputOderList(List<Oder> oders) {
        System.out.println("\nВывод всего списка заказов...");
        for (Oder oder : oders) {
            System.out.println(oder.toString());
        }
    }


    /*
        Создадим внутренний класс, который будет описывать данные заказа номер (рандомное значение), номер
    заказа (инкреметное значение. которое после заказа увеличивается на 1, имя клиента и цена
    */

    class Oder {

        private int number;
        private int numberOder = 1;
        private String name;
        private double price;
        private String thing;

        public Oder() {

        }

        public Oder(int number, int numberOder, String name, double price, String thing) {
            this.number = number;
            this.numberOder = numberOder;
            this.name = name;
            this.price = price;
            this.thing = thing;
        }

        public int getNumber() {
            return (int) (Math.random() * 10000);
        }

        public int getNumberOder() {
            return numberOder++;
        }

        public double getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public String getThing() {
            return thing;
        }

        public String toString() {
            return "Заказ №" + getNumber() + ". Номер заказа №" + getNumberOder() + ". Имя - " + getName()
                    + ". Приобретённый товар " + getThing() + ". Цена - " + getPrice() + "$";
        }
    }

    /*
        В данном классе реализован список клиентов, а также добавление в список нового заказа
     */
    class OderList {

        ArrayList<Oder> listOder = new ArrayList<>();
        Oder oder = new Oder();
        Scanner scanner = new Scanner(System.in);

        private String name;
        private String thing;
        private double price;

        // Инициализация списка
        public List initializeList(List listOder) {
            listOder.add(new Oder(oder.getNumber(), oder.getNumberOder(), "Din", 45.0, "Ручка"));
            listOder.add(new Oder(oder.getNumber(), oder.getNumberOder(), "Bob", 115.5, "Лампочка"));
            listOder.add(new Oder(oder.getNumber(), oder.getNumberOder(), "Rob", 15.3, "Пенал"));
            return listOder;
        }

        // Установка нового загаза в список
        public List setList(List listOder) {
            System.out.println("Оформление нового заказа...");
            int countOderError = 0;
            System.out.print("Введите имя: ");
            name = scanner.nextLine();
            System.out.print("Введите вещь, которую покупаете: ");
            thing = scanner.nextLine();
            System.out.print("Введите цену: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
            } else {
                System.out.println("Вы ввели не число...");
                countOderError++;
            }

            if(countOderError == 0) {
                System.out.println("\nЗаказ оформлен\n");
                System.out.println("Заказ №" + oder.getNumber() + ". Номер заказа №" + oder.getNumberOder() +
                        ". Имя - " + name + ". Приобретённый товар " + thing + ". Цена - " + price + "$");
                listOder.add(new Oder(oder.getNumber(), oder.getNumberOder(), name, price, thing));
            } else {
                System.out.println("\nЗаказ не оформлен\n");
            }

            return listOder;
        }
    }
}
