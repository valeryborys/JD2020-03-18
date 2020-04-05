package by.it.tolstik.jd01_08;

import java.util.Arrays;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replace('{', ' ');
        StringBuilder sb = new StringBuilder(strMatrix);
        Pattern p = Pattern.compile("},");
        String[] str = p.split(sb);
        this.value = new double[str.length][];
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replaceAll("}", "").trim();
            String[] strArr = str[i].split(",");
            this.value[i] = new double[strArr.length];
            for (int j = 0; j < strArr.length; j++) {
                this.value[i][j] = Double.parseDouble(strArr[j]);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value).replaceAll("\\[", "{").replaceAll("\\]", "}");
    }
}
