package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class task2WriteToFile {
    public static void main(String[] args) throws IOException {

        String partRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String pathWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputTask2";

        FileInputStream inputStream = new FileInputStream(partRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);

        int currentByte = inputStream.read(); //ascii кода на прочетения символ
        while (currentByte >= 0){
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol != ',' && currentSymbol != '?' && currentSymbol != '!'){
                outputStream.write(currentSymbol);
            }
            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
