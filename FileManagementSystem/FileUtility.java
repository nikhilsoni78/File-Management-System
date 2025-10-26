package FileManagementSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {
    public static void createDirectory(String name) throws IOException {
        Path filePath = Paths.get(name);
        if(!Files.exists(filePath)){
            Files.createDirectories(filePath);
            System.out.println("Directory Created");
        }else System.out.println("Directory Already Exists");
    }

    public static void createFile(String name) throws IOException {
        Path filepath = Paths.get(name);
        if(!Files.exists(filepath)){
            Files.createFile(filepath);
            System.out.println("File Created Successfully");
        }else System.out.println("File Already Exists");
    }

    public static void writeFile(String path,String content) throws IOException {
        Path filePath = Paths.get(path);
        if(Files.exists(filePath)){
            Files.write(filePath,content.getBytes());
            System.out.println("file Write done");
        }else System.out.println("Invalid file path");

    }

    public static void readFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        if(Files.exists(filePath)){
            String s = Files.readString(filePath);
            System.out.println(s);
        }else System.out.println("Invalid path");
    }

    public static void deleteFile(String path) throws IOException {
        Path filePath =  Paths.get(path);
        if(Files.exists(filePath)){
            Files.deleteIfExists(filePath);
            System.out.println("File Deleted Successfully");
        }else System.out.println("Invalid Path");
    }
}
