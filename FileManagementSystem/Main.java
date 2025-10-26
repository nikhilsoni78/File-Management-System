package FileManagementSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void display(){
        System.out.println("_________Please Select From the following_________");
        System.out.println("________________");
        System.out.println("1: Create File");
        System.out.println("________________");
        System.out.println("2: Read File");
        System.out.println("________________");
        System.out.println("3: Write File");
        System.out.println("________________");
        System.out.println("4: Delete File");
        System.out.println("________________");
        System.out.println("5: Create Directory");
        System.out.println("________________");
        System.out.println("6: List All Files");
        System.out.println("________________");
        System.out.println("7: Exit");
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        while (run){
            display();
            String choice =  scanner.next();
        switch (Integer.parseInt(choice)){
            case 1: {
                System.out.println("Enter File Name with file Extension");
                String name = scanner.next();
                try {
                    FileUtility.createFile(name);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 2: {
                System.out.println("Enter File Name");
                String name = scanner.next();

                try {
                    FileUtility.readFile(name);

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 3:{
                scanner.nextLine();
                System.out.println("Enter File Name");
                String name = scanner.nextLine();
                System.out.println("Enter Content");
                String content = scanner.nextLine();

                System.out.println("Do you want to (1) Overwrite or (2) Append?");
                int option = scanner.nextInt();
                scanner.nextLine(); // consume newline
                try {
                    if (option == 1) {
                        Files.writeString(Paths.get(name), content,StandardOpenOption.CREATE);
                        System.out.println("File Written successfully!");

                    } else {
                        Files.writeString(Paths.get(name), content, StandardOpenOption.APPEND);
                        System.out.println("File updated successfully!");

                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 4:{
                System.out.println("Enter File Name");
                String name = scanner.next();
                try {
                    if(Files.isDirectory(Paths.get(name))){
                        System.out.println("Do you want to delete a directory");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        String ans = scanner.next();
                        if(ans.equals("1")){
                            FileUtility.deleteFile(name);
                            break;
                        }else {
                            break;
                        }
                    }
                    else {
                        FileUtility.deleteFile(name);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 5: {
                System.out.println("Enter Directory name");
                String name = scanner.next();
                try {
                    FileUtility.createDirectory(name);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 6: {
                System.out.println("List of All Files are : ");
                Path path = Paths.get("./");
                try(Stream<Path> list = Files.list(path)){
                    list.forEach(path1 -> System.out.println(path1.toAbsolutePath()));
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case 7: {
                System.out.println(" Exiting File Management System. Goodbye!");
                run = false;
                break;
            }

            default:{
                System.out.println("Invalid Input");
                break;
            }

        }
        }
    }
}
