package Test5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Box {

    /*
        Данный класс реализует упаковку цветов
     */
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String boxType;
    private String box;
    private int boxPrice;
    private int price;
    private boolean nextBox = true;

    public Box() {

    }

    public Box(String boxType, int boxPrice) {
        this.boxType = boxType;
        this.boxPrice = boxPrice;
    }

    private List<Box> boxesList = new ArrayList<>();

    // Инициализация цветочных упаковок в магазине
    public void initialiseBoxesList() {
        boxesList.add(new Box("Expensive - Silver", 30));
        boxesList.add(new Box("Expensive - Gold", 35));
        boxesList.add(new Box("Expensive - Tinsel", 20));
        boxesList.add(new Box("Chip - Silver", 10));
        boxesList.add(new Box("Chip - Gold", 11));
        boxesList.add(new Box("Chip - Tinsel", 9));
        boxesList.add(new Box("Paper", 3));
    }

    // Добавление новых упаковок  в список (доступно продавцам)
    public void setBoxesList() {
        try {
            System.out.println("Введите данные по упаковке: ");
            while (nextBox) {
                System.out.print("Введите тип упаковки - ");
                setBoxType(reader.readLine());
                System.out.println();

                System.out.print("Введите цену упаковки - ");
                setBoxPrice(Integer.parseInt(reader.readLine()));
                System.out.println();

                boxesList.add(new Box(boxType, boxPrice));

                System.out.println("Продолжить заполнение? 0 - да; 1 - нет");
                switch (Integer.parseInt(reader.readLine())){
                    case 0:
                        break;
                    case 1:
                        nextBox = false;
                }
            }
        }catch (IOException e) {
            System.err.println("Error in the class Box " + e);
        }
    }

    // Выбор упаковки, в который необходимо упаковать цветы
    public void box() {

        try {
            initialiseBoxesList();
            System.out.println("Выберите упаковку: 1 - Дорогая серебрянная; 2 - Дорогая золотая; 3 - Дорогая с блестками; 4 - Дешёвая серебрянная; 5 - Дешёвая золотая; 6 - Дешёвая с блестками; 7 - Бумага" );
            int number = Integer.parseInt(reader.readLine());
            switch (number) {
                case 1:
                    price = boxesList.get(0).getBoxPrice();
                    box = boxesList.get(0).getBoxType();
                    break;
                case 2:
                    price = boxesList.get(1).getBoxPrice();
                    box = boxesList.get(1).getBoxType();
                    break;
                case 3:
                    price = boxesList.get(2).getBoxPrice();
                    box = boxesList.get(2).getBoxType();
                    break;
                case 4:
                    price = boxesList.get(3).getBoxPrice();
                    box = boxesList.get(3).getBoxType();
                    break;
                case 5:
                    price = boxesList.get(4).getBoxPrice();
                    box = boxesList.get(4).getBoxType();
                    break;
                case 6:
                    price = boxesList.get(5).getBoxPrice();
                    box = boxesList.get(5).getBoxType();
                    break;
                case 7:
                    price = boxesList.get(6).getBoxPrice();
                    box = boxesList.get(6).getBoxType();
                    break;
            }

        }catch (IOException e) {
            System.err.println("Error! Enter the number");
        }
    }

    public String getBoxType() {
        return boxType;
    }

    public void setBoxType(String boxType) {
        this.boxType = boxType;
    }

    public int getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(int boxPrice) {
        this.boxPrice = boxPrice;
    }

    public String getBox() {
        return box;
    }

    public int getPrice() {
        return price;
    }
}