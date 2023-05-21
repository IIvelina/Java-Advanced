package Lab;

import java.io.*;

public class task5_2WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {


        FileInputStream fileInputStream = new FileInputStream("D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputTask5")));


        int count = 1;
        String line = reader.readLine();
        while (line != null)  {
            if (count % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }
            line = reader.readLine();
            count++;
        }
        writer.close();
        reader.close();
    }
}