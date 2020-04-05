package by.it.borys.jd01_08;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        String[] rows = strMatrix.split("}");
        for (int i = 0; i < rows.length; i++) {
            StringBuilder sb = new StringBuilder(rows[i]);
            Pattern p1 = Pattern.compile("\\s*+[^0-9.]+\\s*");
            Matcher m1 = p1.matcher(sb);
            int pos = 0;
            while (m1.find(pos)) {
                int start = m1.start();
                int end = m1.end();
                sb.replace(start, end, " ");
                pos = start + 1;
            }
            rows[i] = sb.toString().trim();
        }
        int[] countcols = new int[rows.length];
        String[][] cols = new String[rows.length][];
        double[][] matrix = new double[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            cols[i] = rows[i].split(" ");
            countcols[i] = cols[i].length;
            matrix[i] = new double[countcols[i]];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Double.parseDouble(cols[i][j]);
            }
            this.value = matrix;
        }


    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length) {
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < res.length; i++) {
                if (this.value[i].length == ((Matrix) other).value[i].length) {
                    res[i] = new double[this.value[i].length];
                    for (int j = 0; j < res[i].length; j++) {
                        res[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                    }
                } else return super.add(other);
            }
            return new Matrix(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
       if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length) {
           double[][] res = new double[this.value.length][];
           for (int i = 0; i < res.length; i++) {
               if (this.value[i].length == ((Matrix) other).value[i].length) {
                   res[i] = new double[this.value[i].length];
                   for (int j = 0; j < res[i].length; j++) {
                       res[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                   }
                } else return super.add(other);
            }
            return new Matrix(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[] res = new double[((Vector) other).getValue().length];
            for (int i = 0; i < this.value.length; i++) {
                if (this.value[i].length == ((Vector) other).getValue().length) {
                    for (int j = 0; j < this.value[i].length; j++) {
                        res[i] += this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                } else return super.mul(other);
            }
            return new Vector(res);
        } else if (other instanceof Matrix) {
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                if (this.value[i].length == ((Matrix) other).value.length) {
                    res[i] = new double[((Matrix) other).value[i].length];
                    for (int j = 0; j < ((Matrix) other).value.length; j++) {
                        for (int k = 0; k < ((Matrix) other).value.length; k++) {
                            res[i][j] = res[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                } else return super.mul(other);
            }
            return new Matrix(res);
        }
        else return super.mul(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        String delimiter1 = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiter1).append("{");
            String delimiter2 = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter2).append(value[i][j]);
                delimiter2 = ", ";
            }
            sb.append("}");
            delimiter1 = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
