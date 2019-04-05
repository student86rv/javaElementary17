package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final String WORK_DIR = "D:/ElementaryLessons/javaElementary17/testFile/testSrc";
    private static int javaCount = 0;
    private static int funcCount = 0;

    public static void main(String[] args) {

        // printFiles(System.getProperty("user.dir"));

        System.out.println("Java files: " + countJavaFiles(WORK_DIR));
        System.out.println("Functional interfaces: " + funcCount);
    }

    private static void printFiles(String startDir) {
        File homeDir = new File(startDir);
        if (homeDir.exists() && homeDir.isDirectory()) {
            File[] files = homeDir.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
                printFiles(file.getAbsolutePath());
            }
        }
    }

    private static int countJavaFiles(String startDir) {
        File homeDir = new File(startDir);
        if (homeDir.exists() && homeDir.isDirectory()) {
            File[] files = homeDir.listFiles();
            for (File file : files) {
                if (!file.isDirectory()) {
                    String[] nameAndExtension = file.getName().split("\\W+");
                    if (nameAndExtension[1].equals("java")) {
                        javaCount++;
                        if (fileReader(file.getAbsolutePath())) {
                            funcCount++;
                        }
                    }
                }
                countJavaFiles(file.getAbsolutePath());
            }
        }
        return javaCount;
    }

    private static boolean fileReader(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while((currentLine = br.readLine()) != null) {
               if (currentLine.equals("@FunctionalInterface")) {
                   return true;
               }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
