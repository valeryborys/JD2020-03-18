package by.it.okatov.calc;

import by.it.okatov.calc.globalization.IError;
import by.it.okatov.calc.globalization.ResourceManager;

import java.util.Arrays;


@SuppressWarnings("ALL")
class Vector extends Var {
    ResourceManager manager = ResourceManager.INSTANCE;
    private double[] value;

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

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] += otherValue;
            }

            return new Vector(vectorValue);
        } else if (other instanceof Vector) {
            double[] otherValue = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            if (otherValue.length != vectorValue.length) {
                throw new CalcException(
                        String.format(
                                manager.getString(IError.msgErrorIncompatibleSizes),
                                manager.getString(IError.msgErrorVector),
                                new Vector(otherValue),
                                manager.getString(IError.msgErrorVector),
                                new Vector(vectorValue)
                        ));
            }
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] += otherValue[i];
            }
            return new Vector(vectorValue);
        } else {
            return super.add(other);
        }
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] -= otherValue;
            }

            return new Vector(vectorValue);
        } else if (other instanceof Vector) {
            double[] otherValue = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            if (otherValue.length != vectorValue.length) {
                throw new CalcException(
                        String.format(
                                manager.getString(IError.msgErrorIncompatibleSizes),
                                manager.getString(IError.msgErrorVector),
                                new Vector(otherValue),
                                manager.getString(IError.msgErrorVector),
                                new Vector(vectorValue)
                        ));
            }
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] -= otherValue[i];
            }
            return new Vector(vectorValue);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] *= otherValue;
            }

            return new Vector(vectorValue);
        } else if (other instanceof Vector) {
            double[] otherValue = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            double scalarMultiplication = 0;
            if (otherValue.length != vectorValue.length) {
                throw new CalcException(
                        String.format(
                                manager.getString(IError.msgErrorIncompatibleSizes),
                                manager.getString(IError.msgErrorVector),
                                new Vector(otherValue),
                                manager.getString(IError.msgErrorVector),
                                new Vector(vectorValue)
                        ));
            }
            for (int i = 0; i < vectorValue.length; i++) {
                scalarMultiplication += vectorValue[i] * otherValue[i];
            }

            return new Scalar(scalarMultiplication);
        } else {

            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            if (otherValue == 0) {
                throw new CalcException(manager.getString(IError.msgErrorDivisionByZero));
            }
            double[] vectorValue = Arrays.copyOf(getValue(), getValue().length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] /= otherValue;
            }

            return new Vector(vectorValue);
        } else {
            return super.div(other);
        }

    }


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
