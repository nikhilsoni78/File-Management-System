import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BasicTest {
    public static void main(String[] args) throws IOException {
//        File file = new File("./Folders/new.txt");
//        if(file.createNewFile()){
//            System.out.println("File Created : " + file.getName());
//        }else {
//            System.out.println("File " + file.getName()+ " Already Exits");
//        }
//        File file = new File("./Folders");
//        if(file.mkdir()){
//            System.out.println("Directory Created in  : " + file.getPath());
//        }else{
//            System.out.println("Directory already Exists " + file.getPath());
//        }

//        try(FileWriter fileWriter = new FileWriter("./Folders/new.txt")){
//            fileWriter.write("This is the Initial Statement");
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }
        try(FileReader fileReader = new FileReader("./Folders/new.txt")){
        while (fileReader.ready()){
            int content = fileReader.read();
            System.out.print((char) content);
        }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
