import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.List;

public class Test1 {

    /*
        Задача 1. Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать,
    переименовать, вывести на консоль содержимое, дополнить, удалить.
     */

    static Path pathFile = Paths.get("Test1 File.txt");

    public static void main(String[] args) {

        createFile();
        fileWrite();
        System.out.println("Вывод содержимого файла...");
        fileReader();
        System.out.println("Дополнить файл...");
        fileWrite();
        System.out.println("Вывод содержимого файла после дополнения...");
        fileReader();
        copyFile();
        moveFile();
        deleteFile();
    }

    // Переименовать файл
    public static void moveFile() {
        try {
            if (Files.exists(pathFile)) {
                Files.move(pathFile, Paths.get("Move file.txt"));
            } else System.out.println("Файл не сущесвует...");

            if (Files.exists(Paths.get("Move file.txt"))) {
                System.out.println("Файл переименован");
            } else System.out.println("Файл не переименован...");
        } catch (IOException e) {

        }
    }

    // Прочитать содержимое файла
    public static void fileReader() {
        try {
            if(Files.exists(pathFile)) {
                List<String> stringFile = Files.readAllLines(pathFile);
                for(String line : stringFile) {
                    System.out.println(line);
                }
            } else System.out.println("Файл не сущесвует...");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Запись в файл
    public static void fileWrite() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            if(Files.exists(pathFile)) {
                System.out.println("Введите текст для записи... ");
                Files.write(pathFile, reader.readLine().getBytes(), StandardOpenOption.APPEND);
                Files.write(pathFile, "\n".getBytes(), StandardOpenOption.APPEND);
                Files.write(pathFile, reader.readLine().getBytes(), StandardOpenOption.APPEND);
            } else System.out.println("Файл не сущесвует...");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Создание файла
    public static void createFile() {
        try {
            if (!Files.exists(pathFile)) {
                Files.createFile(pathFile);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Копирование файла
    public static void copyFile() {
        try {
            if (Files.exists(pathFile)) {
                Files.copy(Paths.get("Test1 File.txt"), Paths.get("Copy file.txt"));
                if (Files.exists(Paths.get("Copy file.txt"))) {
                    System.out.println("Файл скопирован");
                } else System.out.println("Файл не скопирован");
            } else System.out.println("Файл не сущесвует...");
        }catch (FileAlreadyExistsException e) {
            System.out.println("Файл с таким именем существует в директории");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Удаление файла
    public static void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get("Move file.txt"));
            Files.deleteIfExists(Paths.get("Copy file.txt"));
            if (Files.exists(pathFile)) {
                Files.delete(pathFile);

                if(!(Files.exists(pathFile))){
                    System.out.println("Файл удален...");
                }
            }
            if(!(Files.exists(Paths.get("Move file.txt")))){
                System.out.println("Файл удален...");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
