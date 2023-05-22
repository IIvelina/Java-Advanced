package Exercise;

import java.io.*;

public class task3_2ALLCAPITALS {
    public static void main(String[] args) throws IOException {

        String pathRead = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader br = new BufferedReader(new FileReader(pathRead));

        String pathWrite = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputTask4Ex";
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathWrite));

        String line = br.readLine();

        while (line != null){
            bw.write(line.toUpperCase());
            bw.newLine();
            line = br.readLine();
        }
        br.close();
        bw.close();
    }
}
