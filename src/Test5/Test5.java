package Test5;

public class Test5 {

    /*
        Создать консольное приложение, удовлетворяющее следующим требованиям:
        •Корректно спроектируйте и реализуйте предметную область задачи.
        •Для создания объектов из иерархии классов продумайте возможность использования порождающих
    шаблонов проектирования.
        •Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
        •для проверки корректности переданных данных можно применитьрегулярные выражения.
        •Меню выбора действия пользователем можно не реализовывать, используйте заглушку.

        Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
      (объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы и упаковка.
     */

    /*
        Добавлены методы для добавления в магазин новых цветов и упаковок, доступно продавцам (необходимо создать
     дополнительный алгоритм, чтобы активировать эту функцию).
     */
    public static void main(String[] args) {

        Oder oder = new Oder();
        oder.payment();
    }
}
