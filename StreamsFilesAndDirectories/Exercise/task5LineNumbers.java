package Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task5LineNumbers {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        String pathWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputTask5Ex";
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite));

        List<String> allLines = Files.readAllLines(Path.of(pathRead));

        int count = 1;
        for (String line : allLines) {
            bw.write(count + ". " + line);
            bw.newLine();
            count++;
        }
        bw.close();
    }
}
