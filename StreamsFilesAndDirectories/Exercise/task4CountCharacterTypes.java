package Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class task4CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        String pathWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputTask4_1Ex";
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite));


        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        List<String> allLines = Files.readAllLines(Path.of(pathRead));

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if (currentSymbol == ' '){
                    continue;
                }
                //•	a, e, i, o, u
                if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'i'
                || currentSymbol == 'o' || currentSymbol == 'u'){
                    vowelsCount++;
                    //(! , . ?)
                }else if (currentSymbol == '(' || currentSymbol == ',' || currentSymbol == '.'
                || currentSymbol == '?' || currentSymbol == '!' || currentSymbol == ')'){
                    punctuationCount++;
                }else {
                    consonantsCount++;
                }
            }
        }
        bw.write("Vowels: " + vowelsCount);
        bw.newLine();
        bw.write("Other symbols: " + consonantsCount);
        bw.newLine();
        bw.write("Punctuation: " + punctuationCount);

        bw.close();
    }
}
