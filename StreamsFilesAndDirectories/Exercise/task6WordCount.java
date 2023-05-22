package Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class task6WordCount {
    public static void main(String[] args) throws IOException {

        String pathReadWords = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathReadText = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";


        List<String> allWords = Files.readAllLines(Path.of(pathReadWords));
        List<String> allText = Files.readAllLines(Path.of(pathReadText));

        Map<String, Integer> countWords = new HashMap<>();

        for (String lineWordWords : allWords) {
            Arrays.stream(lineWordWords.split("\\s+"))
                    .forEach( word -> {
                        countWords.put(word, 0);
                    });
        }
        for (String line : allText) {
            Arrays.stream(line.split("\\s+"))
                    .forEach( word -> {
                        if (countWords.containsKey(word)){
                            countWords.put(word, countWords.get(word) + 1);
                        }
                    });
        }

        PrintWriter writer = new PrintWriter("D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputTask6Ex");

        countWords.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry ->  writer.println(entry.getKey() + " - " + entry.getValue()));

       writer.close();
    }
}
