package com.tms.parsers;

import com.tms.parsers.domparser.DomParser;
import com.tms.parsers.model.Lines;
import com.tms.parsers.saxparser.SaxParser;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Choice (1 - SAX, 2 - DOM):");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                SaxParser parser = new SaxParser();

                System.out.println("Type in the path to folder with xml file: ");
                Scanner scanner1 = new Scanner(System.in);
                String pathToFolder = scanner1.nextLine();

                File folder = new File(pathToFolder);
                if (folder.isDirectory()) {
                    File[] filesList = folder.listFiles((dir, name) -> name.endsWith(".xml"));
                    if (filesList.length == 0) {
                        System.out.println("No matching files in this directory");
                        return;
                    }
                    if (filesList.length > 1) {
                        filesList = folder.listFiles((dir, name) -> name.contains("hw"));
                    }
                    for (File file : filesList) {
                        List<Lines> lines = parser.process(file.getPath());

                        try (FileWriter fw = new FileWriter("<William>_<Shakespeare>_<Sonnet 130>.txt")) {
                            fw.write(lines.toString());
                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                    }
                } else {
                    System.out.println("It is not a directory");
                }
                scanner1.close();
                break;
            case 2:
                DomParser parser1 = new DomParser();

                System.out.println("Type in the path to folder with xml file: ");
                Scanner scanner2 = new Scanner(System.in);
                String pathToFolder1 = scanner2.nextLine();

                File folder1 = new File(pathToFolder1);
                if (folder1.isDirectory()) {

                    File[] filesList = folder1.listFiles((dir, name) -> name.endsWith(".xml"));
                    if (filesList.length == 0) {
                        System.out.println("No matching files in this directory");
                        return;
                    }
                    if (filesList.length > 1) {
                        filesList = folder1.listFiles((dir, name) -> name.contains("hw"));
                    }

                    for (File file : filesList) {
                        List<Lines> lines = parser1.process(file.getPath());

                        try (FileWriter fw = new FileWriter("<William>_<Shakespeare>_<Sonnet 130>.txt")) {
                            fw.write(lines.toString());
                        } catch (IOException e) {
                            System.out.println("Error");
                        }
                    }
                } else {
                    System.out.println("It is not a directory");
                }
                scanner2.close();
                break;
        }
        scanner.close();
    }
}
