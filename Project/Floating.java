package Project;

class Floating extends Number {

    public Floating(double val) {
        setValue(val);
    }

    static boolean isFloating(double val) {
        return val % 1.0 != 0;
    }
}