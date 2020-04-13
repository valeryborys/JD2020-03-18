package by.it.zambrano.jd01_09;


import java.util.Arrays;
import java.util.regex.Pattern;

public class Matrix extends Var {

      private double[][] value;

        Matrix(double[][] value) {
            this.value = value;
        }

        Matrix(String strMatrix) {
            strMatrix = strMatrix.replace('{', ' ');
            StringBuilder sb = new StringBuilder(strMatrix);
            Pattern p = Pattern.compile("},");
            String[] str = p.split(sb);
            this.value = new double[str.length][];
            for (int i = 0; i < str.length; i++) {
                str[i] = str[i].replaceAll("}", "").trim();
                String[] strArr = str[i].split(",");
                this.value[i] = new double[strArr.length];
                for (int j = 0; j < strArr.length; j++) {
                    this.value[i][j] = Double.parseDouble(strArr[j]);
                }
            }
        }

        Matrix(Matrix matrix) {
            this.value = Arrays.copyOf(matrix.value, matrix.value.length);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < value.length; i++) {
                String s = "";
                sb.append("{");
                for (int j = 0; j < value[0].length; j++) {
                    sb.append(s).append(value[i][j]);
                    s = ", ";
                }
                if (i < value.length - 1) {
                    sb.append("}, ");
                } else {
                    sb.append("}");
                }
            }
            sb.append("}");
            return sb.toString();
        }
    }

