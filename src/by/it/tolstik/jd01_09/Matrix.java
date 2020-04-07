package by.it.tolstik.jd01_09;

import java.util.Arrays;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] matrixResultSum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSum[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            for (int i = 0; i < matrixResultSum.length; i++) {
                for (int j = 0; j < matrixResultSum.length; j++) {
                    matrixResultSum[i][j] = matrixResultSum[i][j] + ((Scalar) other).getValue();
                }
            }

            return new Matrix(matrixResultSum);
        }
        if (other instanceof Matrix) {
            double[][] matrixResultSum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSum[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            if (matrixResultSum.length == ((Matrix) other).value.length && matrixResultSum[0].length == ((Matrix) other).value.length) {

                for (int i = 0; i < matrixResultSum.length; i++) {
                    for (int j = 0; j < matrixResultSum.length; j++) {
                        matrixResultSum[i][j] = matrixResultSum[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(matrixResultSum);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] matrixResultSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSub[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            for (int i = 0; i < matrixResultSub.length; i++) {
                for (int j = 0; j < matrixResultSub.length; j++) {
                    matrixResultSub[i][j] = matrixResultSub[i][j] - ((Scalar) other).getValue();
                }
            }

            return new Matrix(matrixResultSub);
        }
        if (other instanceof Matrix) {
            double[][] matrixResultSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSub[i] = Arrays.copyOf(this.value[i], this.value.length);
            }
            if (matrixResultSub.length == ((Matrix) other).value.length && matrixResultSub[0].length == ((Matrix) other).value.length) {

                for (int i = 0; i < matrixResultSub.length; i++) {
                    for (int j = 0; j < matrixResultSub.length; j++) {
                        matrixResultSub[i][j] = matrixResultSub[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(matrixResultSub);
            }
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] mul = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j] = mul[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);
        } else if ((other instanceof Matrix) && (this.value.length == ((Matrix) other).value.length)) {
            double[][] mul = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        mul[i][j] = mul[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mul);
        } else {
            double[] mul = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    mul[i] = mul[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mul);
        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
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
