package by.it.verbitsky.calc;

import java.util.Arrays;

class Matrix extends Var {
    public double[][] getMatrix() {
        return matrix;
    }

    private double[][] matrix;

    Matrix(double[][] value) {
        this.matrix = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this.matrix = Arrays.copyOf(matrix.getMatrix(), matrix.getMatrix().length);
    }

    Matrix(String strMatrix) {
        double[][] array = getArrayFromString(strMatrix.substring(1, strMatrix.length() - 1));
        this.matrix = Arrays.copyOf(array, array.length);
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double[] doubles : matrix) {
            stringBuilder.append("{");
            for (int j = 0; j < doubles.length; j++) {
                if (j == doubles.length - 1) {
                    stringBuilder.append(doubles[j]);
                } else {
                    stringBuilder.append(doubles[j]).append(", ");
                }
            }
            stringBuilder.append("}, ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).trimToSize();
        stringBuilder.setCharAt(stringBuilder.length() - 1, '}');
        return stringBuilder.toString();
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
            //сравнить кол-во столбцов слева и кол-во строк справа
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
                return new Matrix(matrix);
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
