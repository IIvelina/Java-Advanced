package Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task1_4SumLines {
    public static void main(String[] args) throws IOException {
        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        allLines.stream()
                .map(line -> line.toCharArray())//всеки един ред става масив от символи
                .forEach(arr -> {
                    int sum = 0;
                    for (char symbol : arr) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}
