package by.it.okatov.jd01_08;

import java.util.Arrays;


@SuppressWarnings("ALL")
class Vector extends Var {
    private double[] value;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                value[i] += otherValue;
            }

            return new Vector(value);
        } else if (other instanceof Vector) {
            double[] otherValue = ((Vector) other).value;
            double[] vectorValue = Arrays.copyOf(value, value.length);
            if (otherValue.length != vectorValue.length) {
                System.out.println("Size!");
                return null;
            }
            for (int i = 0; i < value.length; i++) {
                value[i] += otherValue[i];
            }
            return new Vector(value);
        } else {
            return super.add(other);
        }
        //return super.add(other);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                value[i] -= otherValue;
            }

            return new Vector(value);
        } else if (other instanceof Vector) {
            double[] otherValue = ((Vector) other).value;
            double[] vectorValue = Arrays.copyOf(value, value.length);
            if (otherValue.length != vectorValue.length) {
                System.out.println("Size!");
                return null;
            }
            for (int i = 0; i < value.length; i++) {
                value[i] -= otherValue[i];
            }
            return new Vector(value);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(value, value.length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] *= otherValue;
            }

            return new Vector(vectorValue);
        } else if (other instanceof Vector) {
            double[] otherValue = ((Vector) other).value;
            double[] vectorValue = Arrays.copyOf(value, value.length);
            double scalarMultiplication = 0;
            if (otherValue.length != vectorValue.length) {
                System.out.println("Size!");
                return null;
            }
            for (int i = 0; i < vectorValue.length; i++) {
                scalarMultiplication += vectorValue[i] * otherValue[i];
            }

            return new Scalar(scalarMultiplication);
        } else {
            double[][] otherValue = ((Matrix) other).getValue();
            double[] vectorValue = Arrays.copyOf(value, value.length);
            double[] resVector = new double[vectorValue.length];
            if (otherValue.length != vectorValue.length) {
                System.out.println("Error!");
                return null;
            }
            for (int i = 0; i < otherValue.length; i++) {
                for (int j = 0; j < otherValue[i].length; j++) {
                    resVector[i] += otherValue[i][j] * vectorValue[j];
                }
            }
            return new Vector(resVector);

        }
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    //Спросить про AtomicReference в Java и в этом методе - нужно ли и когда?
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
