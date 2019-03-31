package Project;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Logger {
    private ArrayList<String> Logs;
    public ArrayList<String> getLogs() {
        return Logs;
    }

    public Logger() {
        Logs = new ArrayList<>();
    }

    /**
     * Read existing log file and print date and statistics of log file.
     *
     * @param file Previously initialized File object
     */
    public static void ReadLogFile(File file) {
        HashMap<String, Integer> ExceptionCount = new HashMap<>();
        Scanner reader;

        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, invalid file object!");
            e.printStackTrace();
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            // assuming date format is '2019-01-01'
            String date = line.substring(0, 11);

            if (ExceptionCount.containsKey(date)) ExceptionCount.put(date, ExceptionCount.get(date) + 1);
            else ExceptionCount.put(date, 1);
        }

        for (String date : ExceptionCount.keySet()) {
            System.out.printf("%s: %d exceptions occurred.%n", date, ExceptionCount.get(date));
        }
    }

    /**
     * Write *(by appending, not overwriting) list to a file line by line including date.
     * Assume you can invoke toString method from list items.
     *
     * @param file pre-created File object
     * @return boolean value indicating success status of operation
     */
    public boolean WriteToFile(File file) {
        BufferedWriter bf = null;

        try {
            bf = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        if(bf == null) return false;
        LocalDate now = LocalDate.now();
        try {
            for (String content : this.Logs) {
                bf.write(now.toString() + " ");
                bf.write(content);
                bf.newLine();
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * Add given parameter to Logs.
     *
     * @param log String to add Logs
     */
    public void add(String log) {
        if (log == null) {
            throw new IllegalArgumentException();
        }

        getLogs().add(log);
    }
}
