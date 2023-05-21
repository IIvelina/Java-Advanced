package Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class task4_2ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String partRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(partRead);

        Scanner scanner = new Scanner(inputStream);

        String pathWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputTask4";
        FileOutputStream outputStream = new FileOutputStream(pathWrite);
        PrintWriter writer = new PrintWriter(outputStream);

        //hasNext -> true: ако не сме стигнали до края на файла
        //hasNext -> false: ако сме стигнали до края да файла
        while (scanner.hasNext()){ //докато не сме стигнали края на файла
            if (scanner.hasNextInt()){ //имаме ли следващо цяло число
                //ако има следващо цяло число го вземи
                int number = scanner.nextInt(); //чете до следващото цяло число
                writer.println(number);
            }
            scanner.next(); //премени към следващото прочитане
        }
        writer.close();
    }
}
