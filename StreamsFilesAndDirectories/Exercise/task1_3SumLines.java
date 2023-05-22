package Exercise;

import java.io.*;

public class task1_3SumLines {
    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream inputStream = new FileInputStream("D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try (reader) {
            String line = reader.readLine();
            while (line != null){
                long sum = 0;
                for(char c : line.toCharArray()){
                    sum += c;
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
