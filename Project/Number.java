package Project;
import java.lang.Double;

abstract class Number implements Comparable<Number> {
    private Double Value;

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        if (Value == null) Value = value;
        else throw new  UnsupportedOperationException("You can't set Value twice!");
    }

    public int compareTo(Number other) {
        return getValue().compareTo(other.getValue());
    }

    public String toString() { return Value.toString(); }

}
