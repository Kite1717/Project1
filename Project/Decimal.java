package Project;

class Decimal extends Number {

    public Decimal(Integer val) {
        setValue(val.doubleValue());
    }

    public Decimal(Double val) {
        setValue(val);
    }

    static boolean isDecimal(double value) {
        return value % 1.0 == 0;
    }
}