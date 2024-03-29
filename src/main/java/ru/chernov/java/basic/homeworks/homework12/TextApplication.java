package ru.chernov.java.basic.homeworks.homework12;

import java.io.*;
import java.util.*;

public class TextApplication {
    public static void main(String[] args) throws IOException {
        File file = new File("src");
        System.out.println("Список txt файлов в папке: " + file.getPath());
        List<File> listFiles = getListFiles(file, "txt");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите имя файла для редактирования (без расширения)");
        String inputFileName = scanner.nextLine();

        int tries = listFiles.size();
        File workFile = null;
        for (File f : listFiles) {
            tries -= 1;
            if (f.getName().endsWith(inputFileName + ".txt")) {
                workFile = f;
                readFile(f);
                break;
            }
            if (tries == 0) {
                System.out.println("Файл не найден");
                return;
            }
        }

        String choice = "N";
        do {
            System.out.println("Добавить новые данные в файл? (Y/N)");
            choice = scanner.nextLine().toUpperCase();
            if (choice.equals("Y")) {
                System.out.println("Введите строку для добавления в файл");
                String inputData = scanner.nextLine();
                writeFile(workFile, inputData);
                System.out.println("Вывести новое содержимое а экран? (Y/N)");
                String choiceOut = scanner.nextLine().toUpperCase();
                if (choiceOut.equals("Y")) {
                    readFile(workFile);
                } else {
                    System.out.println("Работа с файлом завершена");
                    return;
                }
            }
        } while (choice.equals("Y"));

        if (choice.equals("N")) {
            System.out.println("Работа с файлом завершена");
        }

    }

    private static void readFile(File f) {
        System.out.println("#Начало файла" + "\n" + "----------");
        try (InputStreamReader inFile = new InputStreamReader(new FileInputStream(f))) {
            int n = inFile.read();
            while (n != -1) {
                System.out.print((char) n);
                n = inFile.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (NullPointerException e) {
            System.out.println("Файл не определен, вывод на экран не возможен");
            return;
        }
        System.out.println("\n--------" + "\n#Конец файла");
    }

    private static void writeFile(File f, String data) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f))) {
            writer.write(data);
            writer.close();
            System.out.println("Данные записаны в файл");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Файл не определен, запись не выполнена");
        }
    }

    public static List<File> getListFiles(File file, String ext) {
        List<File> listFiles = new ArrayList<>();
        int cnt = 0;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                getListFiles(f, ext);
            }
            if (f.isFile() && f.getName().endsWith("." + ext)) {
                cnt++;
                if (cnt == 1) {
                    System.out.println("folder:: " + f.getParent());
                }
                listFiles.add(f);
                System.out.println("-" + f.getName());
            }
        }
        return listFiles;
    }
}