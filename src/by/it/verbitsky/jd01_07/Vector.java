package by.it.verbitsky.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] vector;

    Vector(double[] array) {
        this.vector = Arrays.copyOf(array, array.length);
    }

    Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.getVector(), vector.getVector().length);
    }

    Vector(String strVector) {
        this.vector = getVectorFromString(strVector);
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

    private double[] getVector() {
        return vector;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double v : getVector()) {
            stringBuilder.append(v).append(", ");
        }
        stringBuilder.setCharAt(stringBuilder.length() - 2, '}');
        stringBuilder.deleteCharAt(stringBuilder.length() - 1).trimToSize();
        return stringBuilder.toString();
    }
}
