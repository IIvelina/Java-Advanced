package Exercise;

import java.io.File;

public class task8GetFolderSize {
    public static void main(String[] args) {

        //1. достъп до папката -> път
        //2. обхождаме вс. файлове в мамката -> вз. разлера на вс. файл -> сумираме
        //3. печатаме общия размер

        String path = "D:\\JavaAdvanced\\9. Streams, Files and Directories\\javaProblemStreamsFilesAndDirectories\\StreamsFilesAndDirectories\\src\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int folderSize = 0;
        for (File file : allFiles) {
            folderSize+=file.length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
