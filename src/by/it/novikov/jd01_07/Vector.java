package by.it.novikov.jd01_07;



class Vector extends Var {
    double[] values;

    public Vector(double[] values) {
        this.values = values;
    }

    public Vector(Vector vector) {
        this.values = vector.values;
    }

    public Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0);
        String[] strArray = sb.toString().split(",");
        double[] doubleArray = new double[strArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(strArray[i]);
        }
        this.values = doubleArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double d : values) {
            sb.append(delimiter).append(d);
            delimiter = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}