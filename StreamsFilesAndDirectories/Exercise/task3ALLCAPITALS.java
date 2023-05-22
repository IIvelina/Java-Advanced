package Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

public class task3ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        String pathWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputTask4Ex";
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite));

        //съхраняваме всички редове:
        List<String> allLines = Files.readAllLines(Path.of(pathRead));

        //обхождаме всеки един ред от списъка с редовете:
        for (String line : allLines) {
            bw.write(line.toUpperCase());
            bw.newLine();
        }
        bw.close();
    }
}
