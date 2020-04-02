package by.it.szamostyanin.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double [][] value;

    Matrix(double[][]value){
        this.value=value;
    }

    Matrix(Matrix matrix){
        this.value=matrix.value;
    }

    /*Matrix(String strMatrix){
        this.value=;
    }*/

    @Override
    public String toString() {
        return "Matrix{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}
