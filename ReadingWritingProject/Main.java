package ReadingWritingProject;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("./ReadingWritingProject/", "student.txt");
        if (file.createNewFile()) {
            System.out.println("Created :" + file.getName());
        } else {
            System.out.println("Already Exists " + file.getName());
        }


        try (InputStreamReader reader = new InputStreamReader(System.in);
             OutputStreamWriter writer = new FileWriter("./ReadingWritingProject/student.txt")) {
            while (reader.ready()) {
                int content = reader.read();
                writer.write(content);
                System.out.print(content);
            }
        }
    }
}
