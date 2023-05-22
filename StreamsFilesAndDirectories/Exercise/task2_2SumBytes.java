package Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class task2_2SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0;

        byte[] allBytes = Files.readAllBytes(Path.of(path));

        for (byte ascii : allBytes){
            if (ascii != 10 && ascii != 13) {
                sum += ascii;
            }
        }
        System.out.println(sum);
    }
}
