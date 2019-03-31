package Project;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Converter {
    private Integer totalCount;
    private ArrayList<Number> Nums;
    private Logger Log;

    private Integer getTotalCount() {
        return totalCount;
    }
    private void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public ArrayList<Number> getNums() {
        return Nums;
    }

    public void WriteLog(File file) {
        Log.WriteToFile(file);
    }

    public static Number convertToNumber(double val) {
        if (Floating.isFloating(val)) return new Floating(val);
        else if (Decimal.isDecimal(val)) return new Decimal(val);
        else throw new IllegalArgumentException();
    }

    /**
     * Convert a single String to Number and add to list. If not a Number, return null;
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
     * @return boolean value indicating operation success
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

    public void printStatistics() {
        Double percentageOfSuccess = getNums().size() / (double)getTotalCount();
        Double percentageOfFailure = 1 - percentageOfSuccess;

        System.out.println("Read " + getTotalCount().toString() + " lines. \n" + getNums().size() +
                " (" + percentageOfSuccess.toString() + "%)" +
                " valid and " + (getTotalCount() - getNums().size()) + " (" +
            percentageOfFailure.toString() + "%)" + " invalid inputs.");
}

    public Converter() {
        totalCount = 0;
        Nums = new ArrayList<>();
        Log = new Logger();
    }

}