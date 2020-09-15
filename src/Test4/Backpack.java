package Test4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backpack implements Gems {


    private String nameGem;
    private int costGem;

    public List<Backpack> backpackList = new ArrayList<>();
    private List<String> takeGemUser = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Scanner scanner = new Scanner(System.in);

    public Backpack() {

    }

    public Backpack(String nameThing, int cost) {
        this.nameGem = nameThing;
        this.costGem = cost;
    }

    public void start() {
        boolean isNext = true;
        backpackListGems(backpackList);
        while (isNext) {
            System.out.println("Выберите действие: \n1 - Просмотр содержимого рюкзака; 2 - Взять камни на определенную"
                    + " сумму; 3 - Положить камни; 0 - Выход");

            System.out.print("\nВыбор - ");
            int action = scanner.nextInt();

            if (action == 0) {
                isNext = false;
                System.out.println("Конец работы... До свидания...");
            } else if (action == 1) {
                watchBackpack(backpackList);
            } else if (action == 2) {
                takeGems(backpackList);
            } else if (action == 3) {
                putGem(backpackList);
            } else System.out.println("Введено неверное действие...");
        }
    }

    // Инициализация содержимого рюкзака, с самого начала инициализируем рандомными камнями
    public List backpackListGems(List<Backpack> backpackList) {
        int lengthTableCell = 100;
        int numberRandom;
        for(int i = 0; i < lengthTableCell; i++) {
            numberRandom = (int) (Math.random() * 10);

                if (numberRandom >= 0 && numberRandom <= 1) {
                    backpackList.add(new Backpack(getNameTopaz(), getCostTopaz()));
                } else if (numberRandom >= 2 && numberRandom <= 3) {
                    backpackList.add(new Backpack(getNameDiamond(), getCostDiamond()));
                } else if (numberRandom >= 4 && numberRandom <= 5) {
                    backpackList.add(new Backpack(getNameEmerald(), getCostEmerald()));
                } else if (numberRandom >= 6 && numberRandom <= 7) {
                    backpackList.add(new Backpack(getNameSapphire(), getCostSapphire()));
                } else if (numberRandom >= 8 && numberRandom <= 9) {
                    backpackList.add(new Backpack(getNameRuby(), getCostRuby()));
                }
            }

        return backpackList;
    }

    // Рандомное взятие камней на сумму, которую вводит пользователь
    public List<Backpack> takeGems(List<Backpack> backpackList) {
        int maxTake = 0;
        int sumTake = 0;
        int maxSumTake = 0;
        int numberRandom;

        /*
        Найдем Сумму всех камней в рюкзаке...
         */
        for(Backpack gems : backpackList) {
            maxSumTake += gems.getCostGem();
        }

            Scanner scannerReader = new Scanner(System.in);
            System.out.print("Введите сумму, на которую следует брать камни: ");
            if(scannerReader.hasNextInt()) {
                maxTake = scannerReader.nextInt();
            }else System.out.println("Вы ввели не число...");

            if(maxTake >= getCostEmerald()) {
                while ((sumTake + getCostSapphire()) <= maxTake) {
                    numberRandom = (int) (Math.random() * 100);
            /*
                После взятия камня из ячейки, в ячейке ничего не находится, поэтому необходимо проверить, чтобы
            ячейка была не пустой, если ячейка пустая, то повторяется цикл
             */
                    if (!(backpackList.get(numberRandom).getNameGem() == null)) {
                        sumTake += backpackList.get(numberRandom).getCostGem();
                       // countGems++;
                        takeGemUser.add(backpackList.get(numberRandom).getNameGem());
                        // После взятия камня из ячейки, присваиваем значение "0" и null соответственно
                        backpackList.get(numberRandom).setCostGem(0);
                        backpackList.get(numberRandom).setNameGem(null);
                    }
                    if(sumTake == maxSumTake) {
                        break;
                    }
                }
        System.out.println("Камни, которые взял пользователь из рюкзака\n" + takeGemUser.toString() + "\n");
        System.out.println("Камни взяты на сумму - " + sumTake);
            }else System.out.println("Минимальная сумма, взятие камней не возможна");
        return backpackList;
        }

     // Положить камни в рюкзак...
     public List<Backpack> putGem(List<Backpack> backpackList) {
         try {
             System.out.println("Положить на пустые ячейки камни (ruby, emerald, topaz, diamond, sapphire)...\n"
                     + "Для выхода введите stop/стоп");
             boolean isNext = true;
             int countAction = 0;
             while (isNext) {
                 for (int i = 0; i < 100; i++) {
                     if (backpackList.get(i).getNameGem() == null) {
                         System.out.println("Положить на пустые ячейки камни (ruby, emerald, topaz, diamond, sapphire)...\n"
                                 + "Для выхода введите stop/стоп");
                         System.out.print("\nПоложить в ячейку камень: ");
                         String gem = reader.readLine();
                         countAction++;
                         if (gem.equalsIgnoreCase(getNameDiamond())) {
                             backpackList.set(i, new Backpack(setNameDiamond(), setCostDiamond()));
                             System.out.println("********Камень положен*************");
                         } else if (gem.equalsIgnoreCase(getNameEmerald())) {
                             backpackList.set(i, new Backpack(setNameEmerald(), setCostEmerald()));
                             System.out.println("********Камень положен*************");
                         } else if (gem.equalsIgnoreCase(getNameRuby())) {
                             backpackList.set(i, new Backpack(setNameRuby(), setCostRuby()));
                             System.out.println("********Камень положен*************");
                         } else if (gem.equalsIgnoreCase(getNameSapphire())) {
                             backpackList.set(i, new Backpack(setNameSapphire(), setCostSapphire()));
                             System.out.println("********Камень положен*************");
                         } else if (gem.equalsIgnoreCase(getNameTopaz())) {
                             backpackList.set(i, new Backpack(setNameEmerald(), setCostEmerald()));
                             backpackList.get(i).setCostTopaz();
                             backpackList.get(i).setCostSapphire();
                         } else System.out.println("Введен неверный камень... Такого камня не существует...");

                         if(gem.equalsIgnoreCase("стоп") || gem.equalsIgnoreCase("stop")) {
                             i = 99;
                         }
                     }

                     if (i == 99) {
                         isNext = false;
                     }
                 }
             }
             if(countAction == 0) {
                 System.out.println("\nРюкзак полон! Невозможно положить камни в рюкзак\n");
             }
         } catch (IOException e) {

         }
         return backpackList;
     }

     // Вывод всего, что находится в рюкзаке
    public void watchBackpack(List<Backpack> backpackList) {
        System.out.println("Вывод содержимого рюкзака...\n");
        int cell = 0;
        for(Backpack gems : backpackList) {
            System.out.print(gems.getNameGem() + ", ");
            cell++;
            if(cell == 10) {
                cell = 0;
                System.out.println("\n");
            }
        }
    }

    @Override
    public int getCostTopaz() {
        return TOPAZ;
    }

    @Override
    public int getCostDiamond() {
        return DIAMOND;
    }

    @Override
    public int getCostEmerald() {
        return EMERALD;
    }

    @Override
    public int getCostSapphire() {
        return SAPPHIRE;
    }

    @Override
    public int getCostRuby() {
        return RUBY;
    }

    @Override
    public int setCostTopaz() {
        return getCostTopaz();
    }

    @Override
    public int setCostDiamond() {
        return getCostDiamond();
    }

    @Override
    public int setCostEmerald() {
        return getCostEmerald();
    }

    @Override
    public int setCostSapphire() {
        return getCostSapphire();
    }

    @Override
    public int setCostRuby() {
        return getCostRuby();
    }

    @Override
    public String getNameTopaz() {
        return TOPAZ_NAME;
    }

    @Override
    public String getNameDiamond() {
        return DIAMOND_NAME;
    }

    @Override
    public String getNameEmerald() {
        return EMERALD_NAME;
    }

    @Override
    public String getNameSapphire() {
        return SAPPHIRE_NAME;
    }

    @Override
    public String getNameRuby() {
        return RUBY_NAME;
    }

    @Override
    public String setNameTopaz() {
        return getNameTopaz();
    }

    @Override
    public String setNameDiamond() {
        return getNameDiamond();
    }

    @Override
    public String setNameEmerald() {
        return null;
    }

    @Override
    public String setNameSapphire() {
        return getNameSapphire();
    }

    @Override
    public String setNameRuby() {
        return getNameRuby();
    }

    public String getNameGem() {
        return nameGem;
    }

    public int getCostGem() {
        return costGem;
    }

    public void setNameGem(String nameGem) {
        this.nameGem = nameGem;
    }

    public void setCostGem(int costGem) {
        this.costGem = costGem;
    }
}
