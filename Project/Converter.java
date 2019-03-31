package Project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Converter {
    private Integer totalCount;
    private Integer getTotalCount() {
        return totalCount;
    }
    private void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    private ArrayList<Number> Nums;
    public ArrayList<Number> getNums() {
        return Nums;
    }

    private Logger Log;
    public void WriteLog(File file) {
        Log.WriteToFile(file);
    }

    /**
     * Convert value to Number.
     *
     * @param val Value to convert
     * @return Number representing val
     * @see Number
     */
    public static Number convertToNumber(double val) {
        if (Floating.isFloating(val)) return new Floating(val);
        else if (Decimal.isDecimal(val)) return new Decimal(val);
        else throw new IllegalArgumentException();
    }

    /**
     * Convert a single String to Number and add to list. If not a Number, return null.
     *
     * @param str String to convert
     * @return Number representing string or null
     * @see Number
     */
    private Number convert(String str) {
        setTotalCount(getTotalCount() + 1);

        StringBuilder strResult = new StringBuilder();
        char[] charArray = str.trim().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if ('0' <= charArray[i] && charArray[i] <= '9') strResult.append(charArray[i]);
            else if (i == 0 && (charArray[i] == '-' || charArray[i] == '+')) strResult.append(charArray[i]);
            else {
                Log.add("Exception, not a numeric value: " + str);
                return null;
            }
        }

        Number result = convertToNumber(Double.valueOf(strResult.toString()));
        getNums().add(result);

        return result;
    }

    /**
     * Read file and convert every line at specified file.
     *
     * @param file absolute path of file
     * @return all current cached Number objects in this object
     * @see java.util.ArrayList
     */
    public ArrayList<Number> readFile(File file) {
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                convert(reader.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getNums();
    }


    /**
     * Print current statistics.
     */
    public void printStatistics() {
        Double percentageOfSuccess = (getNums().size() / (double)getTotalCount()) * 100;
        Double percentageOfFailure = 100 - percentageOfSuccess;

        System.out.printf("Read %d lines.%n %d (%.2f%%) valid and %d (%.2f%%) invalid inputs.%n",
                getTotalCount(), getNums().size(), percentageOfSuccess,
                getTotalCount() - getNums().size(), percentageOfFailure);
}

    public Converter() {
        totalCount = 0;
        Nums = new ArrayList<>();
        Log = new Logger();
    }

}
