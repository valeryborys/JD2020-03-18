package by.it.okatov.calc;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }


    Vector(String strValue) {
        for (char ch : strValue.toCharArray()) {
            if (ch == '{' || ch == '}') {
                strValue = strValue.replace(Character.toString(ch), "");
            }
        }
        String[] strArray = Arrays.copyOf(strValue.split(","), strValue.split(",").length);
        value = new double[strArray.length];

        for (int j = 0; j < value.length; j++) {
            this.value[j] = Double.parseDouble(strArray[j]);
        }
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }


    //region [addition]
    @Override
    public Var add(Var other) throws CalcException {
        return super.add(other);
    }

    @Override
    public Var add(Matrix matrix) throws CalcException {
        return super.add(matrix);
    }

    @Override
    public Var add(Scalar scalar) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform addition on empty vector!\n"
            );
        }

        double otherValue = scalar.getValue();
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        for (int i = 0; i < vectorValue.length; i++) {
            vectorValue[i] += otherValue;
        }

        return new Vector(vectorValue);
    }

    @Override
    public Var add(Vector vector) throws CalcException {
        if (this.value.length == 0) {
            throw new CalcException(
                    "It's impossible to perform addition on empty vector!\n"
            );
        }

        double[] otherValue = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        if (otherValue.length != vectorValue.length) {
            throw new CalcException(
                    String.format(
                            "Vector %s and Matrix %s have incompatible sizes%n",
                            new Vector(otherValue),
                            new Vector(vectorValue)
                    ));
        }
        for (int i = 0; i < vectorValue.length; i++) {
            vectorValue[i] += otherValue[i];
        }
        return new Vector(vectorValue);
    }
    //endregion


    //region [multiplication]
    @Override
    public Var mul(Var other) throws CalcException {
        return super.mul(other);
    }

    @Override
    public Var mul(Matrix matrix) throws CalcException {
        return super.mul(matrix);
    }

    @Override
    public Var mul(Scalar scalar) throws CalcException {
        double otherValue = scalar.getValue();
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        for (int i = 0; i < vectorValue.length; i++) {
            vectorValue[i] *= otherValue;
        }

        return new Vector(vectorValue);
    }

    @Override
    public Var mul(Vector vector) throws CalcException {
        double[] otherValue = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        double scalarMultiplication = 0;
        if (otherValue.length != vectorValue.length) {
            throw new CalcException(
                    String.format(
                            "Vector %s and Matrix %s have incompatible sizes%n",
                            new Vector(otherValue),
                            new Vector(vectorValue)
                    ));
        }
        for (int i = 0; i < vectorValue.length; i++) {
            scalarMultiplication += vectorValue[i] * otherValue[i];
        }

        return new Scalar(scalarMultiplication);
    }
    //endregion


    //region [subtraction]
    @Override
    public Var sub(Var other) throws CalcException {
        return super.sub(other);
    }

    @Override
    public Var sub(Matrix matrix) throws CalcException {
        return super.sub(matrix);
    }

    @Override
    public Var sub(Scalar scalar) throws CalcException {
        double otherValue = scalar.getValue();
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        for (int i = 0; i < vectorValue.length; i++) {
            vectorValue[i] -= otherValue;
        }

        return new Vector(vectorValue);
    }

    @Override
    public Var sub(Vector vector) throws CalcException {
        double[] otherValue = Arrays.copyOf(vector.getValue(), vector.getValue().length);
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        if (otherValue.length != vectorValue.length) {
            throw new CalcException(
                    String.format(
                            "Vector %s and Matrix %s have incompatible sizes%n",
                            new Vector(otherValue),
                            new Vector(vectorValue)
                    ));
        }
        for (int i = 0; i < vectorValue.length; i++) {
            vectorValue[i] -= otherValue[i];
        }
        return new Vector(vectorValue);
    }
    //endregion


    //region [division]
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
        double otherValue = scalar.getValue();
        if (otherValue == 0) {
            throw new CalcException(String.format(
                    "ERROR! Division by zero: Scalar equals to %s",
                    otherValue
            ));
        }
        double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
        for (int i = 0; i < vectorValue.length; i++) {
            vectorValue[i] /= otherValue;
        }

        return new Vector(vectorValue);
    }

    @Override
    public Var div(Vector vector) throws CalcException {
        return super.div(vector);
    }
    //endregion


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i < (value.length - 1)) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }
        return sb.toString();
    }
}
