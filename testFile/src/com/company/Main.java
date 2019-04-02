package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {

       // printFiles(System.getProperty("user.dir"));

        int count = 0;
        System.out.println("count:" + countJavaFiles("D:/ElementaryLessons/javaElementary17/testFile/testSrc", count));
    }

    private static void printFiles (String startDir) {
        File homeDir = new File(startDir);
        if (homeDir.exists() && homeDir.isDirectory()) {
            File[] files = homeDir.listFiles();
            for (File file: files) {
                System.out.println(file.getName());
                printFiles(file.getAbsolutePath());
            }
        }
    }

    private static int countJavaFiles(String startDir, int count) {
        File homeDir = new File(startDir);
        if (homeDir.exists() && homeDir.isDirectory()) {
            File[] files = homeDir.listFiles();
            for (File file: files) {
                if (!file.isDirectory()) {
                    String[] nameAndExtension = file.getName().split("\\W+");
                    System.out.println(nameAndExtension[1]);

                    if (nameAndExtension[1].equals("java")) {
                        count++;
                    }
                }
                countJavaFiles(file.getAbsolutePath(), count);
            }
        }
        return count;
    }
}
