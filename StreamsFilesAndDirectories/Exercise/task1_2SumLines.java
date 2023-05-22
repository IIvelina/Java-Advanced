package Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task1_2SumLines {
    public static void main(String[] args) {
        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            List<String> allLines = Files.readAllLines(Path.of(path));
            for (String line : allLines) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    char current = line.charAt(i);
                    sum += current;
                }
                System.out.println(sum);
            }
        }catch (IOException ex){
            System.out.println("Error while reading a file!");
        }
    }
}
