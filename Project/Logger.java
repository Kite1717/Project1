package Project;

import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        BufferedReader bf  = null;
        HashSet<String> currentlog = new HashSet<>();
        //The HashSet does not add the same element again
        HashMap<HashSet<String>,String> logs = new HashMap<>();
        LocalDate now = LocalDate.now();
        try{
            bf = new BufferedReader(new FileReader(file));

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return;
        }
        try {
            while (bf.ready()) {
                //I threw logs into the HashSet s the specific of each day
                String s = bf.readLine();
                if (logs.size() == 0 || !logs.containsValue(s.substring(0, 11))) {
                    logs.put(addLog(file, s.substring(0, 11)), s.substring(0, 11));
                }
            }
            bf.close();

        }
        catch (IOException e)
        {
            e.getMessage();
        }

        // size and today logs
        for(HashSet<String> item : logs.keySet())
        {
            if(logs.get(item).contains(now.toString()))
                currentlog = item;
            System.out.println(logs.get(item) + " : " + item.size() + " exceptions occurred.");
        }


        System.out.println("\nPress Enter to see the details today...");
        Scanner s = new Scanner(System.in);

        //You can reach all the keyboard keys from the KeyEvent class
        if(s.nextLine().contains(String.valueOf(KeyEvent.VK_ENTER)));

        // Today logs
        for (String item : currentlog)
            System.out.println(item);



    }
    // Add to HashSet
    private static HashSet<String> addLog(File file, String date) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(file));
        HashSet<String> ret = new HashSet<>();
        while (bf.ready())
        {

            String s = bf.readLine();
            if(s.substring(0,11).equals(date))
                ret.add(s);
        }
        bf.close();
        return  ret;
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
