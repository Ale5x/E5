package Test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Flowers {

    /*
        Данный класс реализует список цветов находящихся в магазине и доступные для покупки
     */

    private BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    private String flowerName;
    private int flowerPrice;
    private int flowerPriceSum;
    private boolean nextFlowers = true;
    private boolean next = true;

    public Flowers() {

    }

    public Flowers(String flowerName, int flowerPrice) {
        this.flowerName = flowerName;
        this.flowerPrice = flowerPrice;

    }

    private List<Flowers> flowersList = new ArrayList<>();

    // Инициализация цветов и их стомости
    public void initialiseFlowerList() {
        flowersList.add(new Flowers("Rose Red", 35));
        flowersList.add(new Flowers("Rose White", 35));
        flowersList.add(new Flowers("Tulip", 20));
        flowersList.add(new Flowers("Dahlia", 30));
        flowersList.add(new Flowers("Peonies", 45));
        flowersList.add(new Flowers("Orchid", 15));
        flowersList.add(new Flowers("Peony Rose", 50));
        flowersList.add(new Flowers("Others flowers", 50));
    }

    // Добавление новых цветов  в список (доступно продавцам)
    public void setFlowersList() {

        try {
            System.out.println("Введите данные по цветам: ");
            while (nextFlowers) {
                System.out.print("Введите сорт цветов - ");
                setFlowerName(read.readLine());
                System.out.println();

                System.out.print("Введите цену цветов - ");
                setFlowerPrice(Integer.parseInt(read.readLine()));
                System.out.println();

                flowersList.add(new Flowers(flowerName, flowerPrice));

                System.out.println("Продолжить заполнение? 0 - да; 1 - нет");
                switch (Integer.parseInt(read.readLine())) {
                    case 0:
                        break;
                    case 1:
                        nextFlowers = false;
                }
            }
        } catch (IOException e) {
            System.err.println("Error the class Flowers " + e);
        }
    }

    // В методе реализована витрина цветочного магазина, покупатель выбирает сам, какие цветы ему нужно купить
    public List bouquetOfFlowers (List bouquetOfFlowersList){

        initialiseFlowerList();
        System.out.println("Выберите цветы: 1 - Красная роза; 2 - Белая роза; 3 - Тюльпан; 4 - Георгина; 5 - Пионы;"
                + " 6 - Орхидея; 7 - Пионная Роза; 8 - Другие цветы (На выбор продавца); 0 - выход");

        while (next) {
            try {
                System.out.print("Введите цветы под номером: ");
                int number = Integer.parseInt(read.readLine());

                switch (number) {
                    case 0:
                        next = false;
                        break;
                    case 1:
                        bouquetOfFlowersList.add(flowersList.get(0).getFlowerName());
                        flowerPriceSum += flowersList.get(0).getFlowerPrice();
                        break;
                    case 2:
                        bouquetOfFlowersList.add(flowersList.get(1).getFlowerName());
                        flowerPriceSum += flowersList.get(1).getFlowerPrice();
                        break;
                    case 3:
                        bouquetOfFlowersList.add(flowersList.get(2).getFlowerName());
                        flowerPriceSum += flowersList.get(2).getFlowerPrice();
                        break;
                    case 4:
                        bouquetOfFlowersList.add(flowersList.get(3).getFlowerName());
                        flowerPriceSum += flowersList.get(3).getFlowerPrice();
                        break;
                    case 5:
                        bouquetOfFlowersList.add(flowersList.get(4).getFlowerName());
                        flowerPriceSum += flowersList.get(4).getFlowerPrice();
                        break;
                    case 6:
                        bouquetOfFlowersList.add(flowersList.get(5).getFlowerName());
                        flowerPriceSum += flowersList.get(5).getFlowerPrice();
                        break;
                    case 7:
                        bouquetOfFlowersList.add(flowersList.get(6).getFlowerName());
                        flowerPriceSum += flowersList.get(6).getFlowerPrice();
                        break;
                    case 8:
                        bouquetOfFlowersList.add(flowersList.get(7).getFlowerName());
                        flowerPriceSum += flowersList.get(7).getFlowerPrice();
                        break;
                }

            } catch (IOException e) {
                System.err.print("Error! Enter the number");
            }

        }
        return bouquetOfFlowersList;
    }

    public int getFlowerPriceSum() {
        return flowerPriceSum;
    }

    public String getFlowerName () {
        return flowerName;
    }

    public void setFlowerName (String flowerName){
        this.flowerName = flowerName;
    }

    public int getFlowerPrice () {
        return flowerPrice;
    }

    public void setFlowerPrice ( int flowerPrice){
        this.flowerPrice = flowerPrice;
    }
}