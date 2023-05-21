package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class task3CopyBytes {
    public static void main(String[] args) throws IOException {

        Set<Integer> set = Set.of(10, 32);

        String inputPath = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(inputPath);

        String outputPath = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputTask3";

        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int currentByte = inputStream.read();
        while (currentByte >= 0){
            boolean isSet = set.contains(currentByte);
            if (isSet){
                outputStream.write(currentByte);
            }else {
                String digits = String.valueOf(currentByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            }
            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
