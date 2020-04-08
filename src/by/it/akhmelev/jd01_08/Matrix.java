package by.it.akhmelev.jd01_08;

import java.util.Arrays;

public class Matrix extends Var{

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strValue) {
    }

    public Matrix(Matrix matrix) {
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
