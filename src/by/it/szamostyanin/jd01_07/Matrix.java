package by.it.szamostyanin.jd01_07;
import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
}