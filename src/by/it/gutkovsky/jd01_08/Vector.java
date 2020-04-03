package by.it.gutkovsky.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
        //{1.0, 2.0, 3.0}
        String strVector1 = strVector.replace("{", "");
        String strVector2 = strVector1.replace("}", "");
        String[] strVectorArrayTemp = strVector2.split(",");
        double[] strVectorArray = new double[strVectorArrayTemp.length];

        for (int i = 0; i < strVectorArrayTemp.length; i++) {
            strVectorArray[i] = Double.parseDouble(strVectorArrayTemp[i].trim());
        }
        this.value = Arrays.copyOf(strVectorArray, strVectorArray.length);

    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double otherValue = ((Scalar) other).getValue();
            double[] vectorValue = Arrays.copyOf(value, value.length);
            for (int i = 0; i < vectorValue.length; i++) {
                vectorValue[i] = vectorValue[i] + otherValue;
            }
            return new Vector(vectorValue);
        } else if (other instanceof Vector) {
            double[] vectorValue = Arrays.copyOf(this.value, this.value.length);

            if (vectorValue.length == ((Vector) other).value.length) {
                for (int i = 0; i < vectorValue.length; i++) {
                    vectorValue[i] = vectorValue[i] + ((Vector) other).value[i];
                }
                return new Vector(vectorValue);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] resultVectorSub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resultVectorSub.length; i++) {
                resultVectorSub[i] = resultVectorSub[i] - ((Scalar) other).getValue();
            }
            return new Vector(resultVectorSub);
        } else if (other instanceof Vector) {
            double[] resultVectorSub = Arrays.copyOf(this.value, this.value.length);
            if (resultVectorSub.length == ((Vector) other).value.length) {
                for (int i = 0; i < resultVectorSub.length; i++) {
                    resultVectorSub[i] = resultVectorSub[i] - ((Vector) other).value[i];
                }
                return new Vector(resultVectorSub);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] resultVectorMult = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resultVectorMult.length; i++) {
                resultVectorMult[i] = resultVectorMult[i] * ((Scalar) other).getValue();
            }
            return new Vector(resultVectorMult);
        } else if (other instanceof Vector) {
            if (this.value.length == ((Vector) other).value.length) {
                double[] resultVectorMult = Arrays.copyOf(this.value, this.value.length);
                double resultMult = 0;
                for (int i = 0; i < resultVectorMult.length; i++) {
                    resultMult = resultMult + resultVectorMult[i] * ((Vector) other).value[i];
                }
                return new Scalar(resultMult);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double[] divResult = Arrays.copyOf(this.value, this.value.length);
                for (int i = 0; i < divResult.length; i++) {
                    divResult[i] = divResult[i]/((Scalar) other).getValue();
                }
                return new Vector(divResult);
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        // вывод {1.0, 2.0, 4.0}

        if (value == null)
            return "null";
        int iMax = value.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(value[i]);
            if (i == iMax) return b.append('}').toString();
            else b.append(", ");
        }

    }
}
