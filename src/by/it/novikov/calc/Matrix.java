package by.it.novikov.calc;


class Matrix extends  Var implements Operation {
    private double[][] values;

    public double[][] getValues() {
        return values;
    }

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
        public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = new double[values.length][values[0].length];
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = values[i][j] + s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            double[][] first = this.values;
            double[][] second = ((Matrix) other).getValues();
            double[][] result = new double[first.length][first[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = first[i][j] + second[i][j];
                }
            }
            return new Matrix(result);
        }

        return super.add(other);
    }



    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = new double[values.length][values[0].length];
            double s = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = values[i][j] - s;
                }
            }
            return new Matrix(result);
        }
        if (other instanceof Matrix) {
            double[][] first = this.values;
            double[][] second = ((Matrix) other).getValues();
            double[][] result = new double[first.length][first[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = first[i][j] - second[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = new double[values.length][values[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = values[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector) {
            double[] result = new double[((Vector) other).getValues().length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i] += this.values[i][j] * ((Vector) other).getValues()[j];
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix && this.values.length == ((Matrix) other).getValues()[0].length) {
            double[][] first = this.values;
            double[][] second = ((Matrix) other).getValues();
            double[][] result = new double[this.values.length][((Matrix) other).getValues()[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    for (int r = 0; r < result.length; r++) {
                        result[i][r] += first[i][j] * second[j][r];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] result = new double[values.length][values[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = values[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.div(other);
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