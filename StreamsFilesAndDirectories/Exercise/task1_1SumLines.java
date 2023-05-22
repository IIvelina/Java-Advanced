package Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task1_1SumLines {
    public static void main(String[] args) throws IOException {

        //1. прочитам всички редове от файла
        //2. обхождам всеки един ред -> намирам сулата от ascii -> отпечатвам

        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        for (String line : allLines) {
            int sum = 0;
            //намирам сулата от ascii
            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                sum += current;
            }
            System.out.println(sum);
        }
    }
}
