package ru.chernov.java.basic.homeworks.homework12;

import java.io.*;
import java.util.*;

public class TextApplication {
    public static void main(String[] args) {
        System.out.println("Список txt файлов в папке \"src\": ");
        List<String> listFiles = getListFiles("src", "txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите имя файла для редактирования (без расширения)");
        String inputFileName = "src\\" + scanner.nextLine() + ".txt";

        if (searchFileInList(listFiles, inputFileName)) {
            readFile(inputFileName);
            boolean choice = false;
            do {
                System.out.println("Добавить новые данные в файл? (Y/N)");
                if (yesNoChoice()) {
                    System.out.println("Введите строку для добавления в файл");
                    String inputData = scanner.nextLine();
                    writeFile(inputFileName, inputData);
                    System.out.println("Вывести новое содержимое а экран? (Y/N)");
                    if (yesNoChoice()) {
                        readFile(inputFileName);
                        choice = true;
                    } else {
                        System.out.println("Работа с файлом завершена");
                        return;
                    }
                } else {
                    System.out.println("Работа с файлом завершена");
                    return;
                }
            } while (choice);
        } else {
            System.out.println("Работа программы завершена");
            return;
        }
    }

    private static void readFile(String f) {
        System.out.println("#Начало файла" + "\n" + "-->");
        File readFile = new File(f);
        try (InputStreamReader inFile = new InputStreamReader(new BufferedInputStream(new FileInputStream(readFile)))) {
            int n = inFile.read();
            while (n != -1) {
                System.out.print((char) n);
                n = inFile.read();
            }
            System.out.println("\n<--" + "\n#Конец файла");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeFile(String f, String data) {
        File writtenFile = new File(f);
        try (OutputStreamWriter writer = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(writtenFile)))) {
            writer.write(data);
            writer.close();
            System.out.println("Данные записаны в файл");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> getListFiles(String path, String ext) {
        List<String> listFiles = new ArrayList<>();
        int cnt = 0;
        for (File f : new File(path).listFiles()) {
            if (f.isDirectory()) {
                getListFiles(f.getPath(), ext);
            }
            if (f.isFile() && f.getName().endsWith("." + ext)) {
                cnt++;
                if (cnt == 1) {
                    System.out.println("folder:: " + f.getParent() + "\\");
                }
                listFiles.add(f.getPath());
                System.out.println("-" + f.getName());
            }
        }
        return listFiles;
    }

    public static boolean searchFileInList(List<String> listFiles, String fileName) {
        int tries = listFiles.size();
        for (String f : listFiles) {
            tries -= 1;
            if (f.equals(fileName)) {
                return true;
            }
        }
        if (tries == 0) {
            System.out.println("Файл с указанным именем не найден");
            return false;
        }
        return false;
    }

    public static boolean yesNoChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toUpperCase();
        return choice.equals("Y");
    }
}