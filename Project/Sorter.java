package Project;

import java.util.ArrayList;

public class Sorter {
    private ArrayList<Number> Numbers;

    /**
     * @return Sorted list
     * @see java.util.ArrayList
     */
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
        Number minValue;
        int minIndex;
        for (int i = 0; i < getNumbers().size() - 1; i++) {
            minIndex = i;
            minValue = getNumbers().get(i);
            for (int j = i; j < getNumbers().size(); j++) {
                if (minValue.compareTo(Numbers.get(j)) > 0) {
                    minValue = Numbers.get(j);
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