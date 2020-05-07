package by.it.okatov.calc;

import java.util.Arrays;

public class Matrix extends Var {
    private final double[][] value;

    public double[][] getValue() {
        return this.value;
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(String strMatrix) {
        String[] strTempArray = strMatrix.split("},");


        for (int i = 0; i < strTempArray.length; i++) {
            for (char ch : strTempArray[i].toCharArray()) {
                if (ch == '{' || ch == '}') {
                    strTempArray[i] = strTempArray[i].replace(Character.toString(ch), "");
                }
            }
        }
        String[][] strTempArray2D = new String[strTempArray.length][strTempArray[0].split(",").length];
        for (int i = 0; i < strTempArray2D.length; i++) {
            System.arraycopy(strTempArray[i].split(","), 0, strTempArray2D[i], 0, strTempArray2D[i].length);
        }

        value = new double[strTempArray.length][strTempArray[0].split(",").length];


        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(strTempArray2D[i][j]);
            }
        }

    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }


    @Override
    public Var add(Var other) throws CalcException {
        return super.add(other);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform addition on empty matrix!\n"
            );
        }

        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double[][] otherValue = Arrays.copyOf(matrix.getValue(), matrix.getValue().length);
        if (matrixValue.length != otherValue.length || matrixValue[0].length != otherValue[0].length) {
            throw new CalcException(
                    String.format(
                            "Matrix %s and Matrix %s have incompatible sizes%n",
                            new Matrix(matrixValue),
                            new Matrix(otherValue)
                    )
            );
        }
        double[][] resMatrix = new double[matrixValue.length][otherValue[0].length];
        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < matrixValue[0].length; j++) {
                resMatrix[i][j] = matrixValue[i][j] + otherValue[i][j];
            }
        }

        return new Matrix(resMatrix);
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform addition on empty matrix!\n"
            );
        }

        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double scalarValue = scalar.getValue();

        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < matrixValue[0].length; j++) {
                matrixValue[i][j] += scalarValue;
            }
        }

        return new Matrix(matrixValue);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        return super.add(vector);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        return super.mul(other);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform multiplication on empty matrix!\n"
            );
        }

        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double[][] otherValue = Arrays.copyOf(matrix.getValue(), matrix.getValue().length);
        if (matrixValue[0].length != otherValue.length) {
            throw new CalcException(
                    String.format(
                            "Matrix %s and Matrix %s have incompatible sizes%n",
                            new Matrix(matrixValue),
                            new Matrix(otherValue)
                    ));
        }
        double[][] resMatrix = new double[matrixValue.length][otherValue[0].length];

        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < otherValue[0].length; j++) {
                for (int k = 0; k < otherValue.length; k++) {
                    resMatrix[i][j] += matrixValue[i][k] * otherValue[k][j];
                }
            }
        }

        return new Matrix(resMatrix);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform multiplication on empty matrix!\n"
            );
        }

        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double otherValue = scalar.getValue();
        double[][] resMatrix = new double[matrixValue.length][matrixValue[0].length];

        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < matrixValue[0].length; j++) {
                resMatrix[i][j] = matrixValue[i][j] * otherValue;
            }
        }

        return new Matrix(resMatrix);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform multiplication on empty matrix!\n"
            );
        }

        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double[] otherValue = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        double[] resVector = new double[otherValue.length];
        if (matrixValue[0].length != otherValue.length) {
            throw new CalcException(
                    String.format(
                            "Vector %s and Matrix %s have incompatible sizes%n",
                            new Vector(otherValue),
                            new Matrix(matrixValue)
                    ));
        }
        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < matrixValue[i].length; j++) {
                resVector[i] += matrixValue[i][j] * otherValue[j];
            }
        }
        return new Vector(resVector);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return super.sub(other);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform subtraction on empty matrix!\n"
            );
        }
        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double[][] otherValue = Arrays.copyOf(matrix.getValue(), matrix.getValue().length);
        if (matrixValue.length != otherValue.length || matrixValue[0].length != otherValue[0].length) {
            throw new CalcException(
                    String.format(
                            "Matrix %s and Matrix %s have incompatible sizes%n",
                            new Matrix(matrixValue),
                            new Matrix(otherValue)
                    )
            );
        }
        double[][] resMatrix = new double[matrixValue.length][otherValue[0].length];
        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < matrixValue[0].length; j++) {
                resMatrix[i][j] = matrixValue[i][j] - otherValue[i][j];
            }
        }

        return new Matrix(resMatrix);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform subtraction on empty matrix!\n"
            );
        }
        double[][] matrixValue = Arrays.copyOf(getValue(), getValue().length);
        double otherValue = scalar.getValue();

        for (int i = 0; i < matrixValue.length; i++) {
            for (int j = 0; j < matrixValue[0].length; j++) {
                matrixValue[i][j] -= otherValue;
            }
        }

        return new Matrix(matrixValue);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        return super.sub(vector);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public Var div(Matrix matrix) throws CalcException {
        return super.div(matrix);
    }

    @Override
    public Var div(Scalar scalar) throws CalcException {
        return super.div(scalar);
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        return super.div(vector);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");


        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(value[i][j]);
                if (j < (value[i].length - 1)) {
                    sb.append(", ");
                } else {
                    sb.append("}");
                }
            }
            if (i < (value.length - 1)) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }
        return sb.toString();
    }
}
