package by.it.szamostyanin.jd01_07;
import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    /*Vector(String[] strVector) {
        this.value = (strVector);
    }*/

    @Override
    public String toString() {
        return "Vector{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
