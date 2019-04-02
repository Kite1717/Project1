package Project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        File file = null;
        Scanner scanner = new Scanner(System.in);
        File logFile = new File("LogFile.txt");


        // parse args
        for (String s: args) {
            if (s.contains("--logfile=")) {
                logFile = new File(s.substring("--logfile=".length()));
                if (!logFile.isFile()) {
                    System.out.println("Invalid filepath for logfile!");
                    return;
                }

                Logger.ReadLogFile(logFile);
                return;
            }
            else if (s.contains("--filepath=")) {
                String filePath = s.substring("--filepath=".length());
                file = new File(filePath);
                if (!file.isFile()) file = null;
                break;
            }
        }

        // get filepath if not initialized
        while (file == null) {
            System.out.print("Type a valid file path: ");
            String input = scanner.nextLine();
            file = new File(input);

            if (!file.isFile()) {
                System.out.println("File doesn't exists.");
                file = null;
            }
        }

        // run the program
        Converter converter = new Converter();
        converter.readFile(file);
        converter.printStatistics();
        converter.WriteLog(logFile);

        // print sorted inputs
        Sorter sorter = new Sorter(converter.getNums());
        System.out.println("\nValid inputs as sorted:");
        ArrayList<Number> arrayList = sorter.getNumbers();
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.printf("%d-) %.2f%n", i+1, arrayList.get(i).getValue());
        }
    }
}
