package Project;

import java.util.ArrayList;

public class Sorter {
    private ArrayList<Number> Numbers;
    // return sorted list
    public ArrayList<Number> getNumbers() {
        return Numbers;
    }
    public void setNumbers(ArrayList<Number> numbers) {
        Numbers = numbers;
    }

    /**
     * Sort numbers in Numbers permanently.
     * Time complexity: O(n^2).
     */
    public void Sort() {
        double minValue;
        int minIndex;
        for (int i = 0; i < getNumbers().size() - 1; i++) {
            minIndex = i;
            minValue = getNumbers().get(i).getValue();
            for (int j = i; j < getNumbers().size(); j++) {
                if (minValue > Numbers.get(j).getValue()) {
                    minValue = Numbers.get(j).getValue();
                    minIndex = j;
                }
            }
            // swap i and j
            Number temp = Numbers.get(i);
            Numbers.set(i, Numbers.get(minIndex));
            Numbers.set(minIndex, temp);
        }
    }

    public Sorter(ArrayList<Number> numbers) {
        setNumbers(new ArrayList<>(numbers));
        Sort();
    }
}