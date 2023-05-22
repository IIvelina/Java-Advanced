package Exercise;

import java.io.*;
import java.nio.file.Path;

public class task2SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        long sum = 0;

        BufferedReader br = new BufferedReader(new FileReader(path));

        String line = br.readLine(); // взимаме ред по ред

        while (line != null){
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                sum+=currentSymbol;
            }
            line = br.readLine();
        }
        System.out.println(sum);
    }
}
