package ru.chernov.java.basic.homeworks.homework12;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextApplication {
    public static void main(String[] args) throws IOException {
        File file = new File("src");
        System.out.println("Список txt файлов в папке: " + file.getPath());
        List<String> listFiles = getListFiles(file, "txt");

        System.out.println(listFiles.toString());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите имя файла для редактирования ");
        String inputFileName = scanner.next();


        for (String s : listFiles) {
            if (s.endsWith(inputFileName + ".txt")) {
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(s));
                int n = in.read();
                while (n != -1) {
                    System.out.print((char) n);
                    n = in.read();
                }
            }
        }


    }

    public static List<String> getListFiles(File file, String ext) {
        List<String> listFiles = new ArrayList<>();
        int cnt = 0;
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                getListFiles(f, ext);
            }
            if (f.isFile() && f.getName().endsWith("." + ext)) {
                if (cnt == 0) {
                    System.out.println("folder:: " + f.getParent());
                }
                cnt++;
                listFiles.add(f.getPath());
                System.out.println("-" + f.getName());
            }
        }
        return listFiles;
    }
}
