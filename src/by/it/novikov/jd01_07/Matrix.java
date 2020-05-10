package by.it.novikov.jd01_07;

class Matrix extends Var {
    double[][] values;

    public Matrix(double[][] values) {
        this.values = new double[values.length][0];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = new double[values[i].length];
            System.arraycopy(values[i], 0, this.values[i], 0, values[i].length);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.values);
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.trim().replace(" ", "");
        String[] rows = strMatrix.split("},");
        for (int i = 0; i < rows.length; i++) {
            rows[i] = rows[i].replace("{", "").replace("}", "");
        }
        values = new double[rows.length][0];
        for (int i = 0; i < rows.length; i++) {
            String[] strArray = rows[i].split(",");
            values[i] = new double[strArray.length];
            for (int j = 0; j < strArray.length; j++) {
                values[i][j] = Double.parseDouble(strArray[j]);
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{");
        String rowsDelimiter = "";
        for (double[] value : values) {
            result.append(rowsDelimiter);
            String delimiter = "";
            result.append("{");
            for (int j = 0; j < values.length; j++) {
                result.append(delimiter).append(value[j]);
                delimiter = ", ";
            }
            rowsDelimiter = ", ";
            result.append("}");
        }
        result.append("}");
        return result.toString();
    }
}