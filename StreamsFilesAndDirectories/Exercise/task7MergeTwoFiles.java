package Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task7MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String pathInputOneRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathInputTwoRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        String pathOutputWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputTask7";
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathOutputWrite));

        List<String> allLinesOne = Files.readAllLines(Path.of(pathInputOneRead));
        List<String> allLinesTwo = Files.readAllLines(Path.of(pathInputTwoRead));

        for (String line : allLinesOne) {
            for (int i = 0; i < line.length(); i++) {
                bw.write(line);
                bw.newLine();
            }
        }
        for (String line : allLinesTwo) {
            for (int i = 0; i < line.length(); i++) {
                bw.write(line);
                bw.newLine();
            }
        }
        bw.close();
    }
}
