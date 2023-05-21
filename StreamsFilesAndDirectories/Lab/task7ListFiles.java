package Lab;

import java.io.File;

public class task7ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File current : files) {
                if (!current.isDirectory()) {
                    System.out.printf("%s: [%s]\n", current.getName(), current.length());
                }
            }
        }
    }
}

