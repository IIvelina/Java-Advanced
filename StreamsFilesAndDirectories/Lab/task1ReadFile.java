package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class task1ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int currentByte = inputStream.read();
        while (currentByte >= 0){ //значи, че потока все още не е свършил
            //79 -> двуична бройна система ("1001111")
            System.out.print(Integer.toBinaryString(currentByte) + " ");
            currentByte = inputStream.read();
        }
        inputStream.close();
    }
}
