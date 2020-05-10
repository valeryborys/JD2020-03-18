package by.it.szamostyanin.Calc;

import java.util.Arrays;

class Matrix extends Var {
    private static ResMan res = ConsoleRunner.getRes();

    private double[][] value;

    public double[][] getMatrix() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);

    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix) {
        double[][] array = getArrayFromString(strMatrix.substring(1, strMatrix.length() - 1));
        this.value = Arrays.copyOf(array, array.length);
    }

    private double[][] getArrayFromString(String str) {
        String[] strings = str.split("},");
        double[][] array = new double[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            array[i] = getVectorFromString(strings[i]);
        }
        return array;
    }

    private double[] getVectorFromString(String strVector) {
        strVector = strVector.replaceAll("[{}\\s]", "");
        String[] strings = strVector.split(",");
        double[] array = new double[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        return array;
    }

    @Override
    public String toString() {
        if (this.value == null) {
            System.out.println(res.getString(ErrorMessages.NULL_VALUE) + "\n");
        } else {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < value.length; i++) {
                sb.append("{");
                for (int j = 0; j < value.length; j++) {
                    sb.append(value[i][j]);
                    if (j == value.length - 1) {
                        sb.append("}");
                    } else {
                        sb.append(", ");
                    }
                }
                if (i == value.length - 1) {
                    sb.append("}");
                } else {
                    sb.append(",");
                }

            }
            return sb.toString();
        }
        return null;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[][] matrix = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] += scalar;
                }
            }
            return new Matrix(matrix);
        } else {
            if (other instanceof Matrix) {
                if (this.getMatrix().length == ((Matrix) other).getMatrix().length) {
                    if (this.getMatrix()[0].length == ((Matrix) other).getMatrix()[0].length) {
                        double[][] matrixLeft = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
                        double[][] matrixRight = Arrays.copyOf(((Matrix) other).getMatrix(), ((Matrix) other).getMatrix().length);
                        double[][] matrixRes = new double[this.getMatrix().length][this.getMatrix()[0].length];
                        for (int i = 0; i < matrixLeft.length; i++) {
                            for (int j = 0; j < matrixLeft[i].length; j++) {
                                matrixRes[i][j] = matrixLeft[i][j] + matrixRight[i][j];
                            }
                        }
                        return new Matrix(matrixRes);
                    }
                }
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[][] matrix = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] -= scalar;
                }
            }
            return new Matrix(matrix);
        } else {
            if (other instanceof Matrix) {
                if (this.getMatrix().length == ((Matrix) other).getMatrix().length) {
                    if (this.getMatrix()[0].length == ((Matrix) other).getMatrix()[0].length) {
                        double[][] matrixLeft = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
                        double[][] matrixRight = Arrays.copyOf(((Matrix) other).getMatrix(), ((Matrix) other).getMatrix().length);
                        double[][] matrixRes = new double[this.getMatrix().length][this.getMatrix()[0].length];
                        for (int i = 0; i < matrixLeft.length; i++) {
                            for (int j = 0; j < matrixLeft[i].length; j++) {
                                matrixRes[i][j] = matrixLeft[i][j] - matrixRight[i][j];
                            }
                        }
                        return new Matrix(matrixRes);
                    }
                }
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            double[][] matrix = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] *= scalar;
                }
            }
            return new Matrix(matrix);
        }
        if (other instanceof Vector) {
            if (((Vector) other).getVector().length == this.getMatrix().length) {
                double[] vector = Arrays.copyOf(((Vector) other).getVector(), ((Vector) other).getVector().length);
                double[][] matrix = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
                double[] res = mul(matrix, vector);
                return new Vector(res);
            }
        }
        if (other instanceof Matrix) {
            if (this.getMatrix().length == ((Matrix) other).getMatrix()[0].length) {
                double[][] matrixLeft = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
                double[][] matrixRight = Arrays.copyOf(((Matrix) other).getMatrix(), ((Matrix) other).getMatrix().length);
                double[][] res = mul(matrixLeft, matrixRight);
                return new Matrix(res);
            }
            return super.mul(other);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalar = ((Scalar) other).getValue();
            if (scalar != 0) {
                double[][] matrix = Arrays.copyOf(this.getMatrix(), this.getMatrix().length);
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] /= scalar;
                    }
                }
            }
        }
        return super.div(other);
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] array = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    array[i][j] = array[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return array;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] array = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                array[i] = array[i] + matrix[i][j] * vector[j];
            }
        }
        return array;
    }
}