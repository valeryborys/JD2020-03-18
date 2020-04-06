package by.it.bobrovich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    public Matrix(String strMaxtrix) {
        int i1 = 0;
        StringBuilder sb = new StringBuilder(strMaxtrix);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            int position = matcher.start();
            sb.setCharAt(position, ' ');
            i1 += 1;
        }
        String[] matrix = sb.toString().trim().split(",");
        double[][] value1 = new double[(i1 - 2) / 2][(i1 - 2) / 2];
        for (int i = 0, k = 0; i < value1.length; i++) {
            for (int j = 0; j < value1.length; j++) {
                if (k < (Math.pow(value1.length, 2))) {
                    value1[i][j] = Double.parseDouble(matrix[k]);
                    k++;
                }
            }
        }
        value = Arrays.copyOf(value1, value1.length);
    }

    @Override
    public Var add(Var other) {
        double[][] newMatrix = new double[this.value.length][this.value[0].length];
        if (other instanceof Matrix) {
            if ((this.value[0].length == ((Matrix) other).value[0].length) && (this.value.length == ((Matrix) other).value.length)) {
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        newMatrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(newMatrix);
            } else {
                System.out.println("Impossible operation");
                return null;
            }
        } else if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    newMatrix[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(newMatrix);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[][] newMatrix = new double[this.value.length][this.value[0].length];
        if (other instanceof Matrix) {
            if ((this.value[0].length == ((Matrix) other).value[0].length) && (this.value.length == ((Matrix) other).value.length)) {
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < this.value[0].length; j++) {
                        newMatrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(newMatrix);
            } else {
                System.out.println("Impossible operation");
                return null;
            }
        } else if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    newMatrix[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(newMatrix);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value[0].length) {
                double[][] newMatrix = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            newMatrix[i][j] = newMatrix[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(newMatrix);
            } else {
                System.out.println("Impossible operation");
                return null;
            }
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).getValue().length) {
                double[] newVector = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        newVector[i] = newVector[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(newVector);
            } else {
                System.out.println("Impossible operation");
                return null;
            }
        } else {
            double[][] newMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    newMatrix[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(newMatrix);
        }
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double[][] newMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    newMatrix[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(newMatrix);
        }else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder();
        matrix.append("{{");
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                if (j < value.length - 1) {
                    matrix.append(value[i][j]).append(", ");
                } else {
                    matrix.append(value[i][j]).append("}");
                }
            }
            if (i < value.length - 1) {
                matrix.append(", {");
            } else {
                matrix.append("}");
            }
        }
        return matrix.toString();
    }
}
