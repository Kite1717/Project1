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
        // according to description of problem, command-line inputs are valid
        for (String s: args) {
            if (s.contains("--logfile=")) {
                logFile = new File(s.substring("--logfile=".length()));
                Logger.ReadLogFile(logFile);
                return;
            }
            else if (s.contains("--filepath=")) {
                String filePath = s.substring("--filepath=".length());
                file = new File(filePath);
            }
        }

        // get filepath if not initialized
        while (file == null) {
            System.out.print("Type a valid file path: ");
            String input = scanner.nextLine();
            try {
                file = new File(input);
                break;
            } catch (Exception e) {
                System.out.println("Invalid file path.");
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
