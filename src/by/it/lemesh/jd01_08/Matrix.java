package by.it.lemesh.jd01_08;

import java.util.Arrays;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] sum = value.clone();
            for (int i = 0; i < sum.length; i++) {
                sum[i] = value[i].clone();
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[i].length; j++) {
                    sum[i][j] = sum[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(sum);
        } else if ((other instanceof Matrix) && (value.length == ((Matrix) other).value.length)) {
            double[][] sum = value.clone();
            for (int i = 0; i < sum.length; i++) {
                sum[i] = value[i].clone();
            }
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = sum[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sum);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] sub = value.clone();
            for (int i = 0; i < sub.length; i++) {
                sub[i] = value[i].clone();
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);
        } else if ((other instanceof Matrix) && (this.value.length == ((Matrix) other).value.length)) {
            double[][] sub = value.clone();
            for (int i = 0; i < sub.length; i++) {
                sub[i] = value[i].clone();
            }
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] mul = value.clone();
            for (int i = 0; i < mul.length; i++) {
                mul[i] = value[i].clone();
            }
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

    Matrix(double[][] value) {
        this.value = value;
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

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            String s = "";
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(s).append(value[i][j]);
                s = ", ";
            }
            if (i < value.length - 1) {
                sb.append("}, ");
            } else {
                sb.append("}");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
