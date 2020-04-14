package by.it.borys.jd01_07;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        String[] rows = strMatrix.split("}");
        for (int i = 0; i < rows.length; i++) {
            StringBuilder sb = new StringBuilder(rows[i]);
            Pattern p1 = Pattern.compile("\\s*+[^0-9.-]+\\s*");
            Matcher m1 = p1.matcher(sb);
            int pos=0;
            while (m1.find(pos)){
                int start = m1.start();
                int end = m1.end();
                sb.replace(start,end," ");
                pos=start+1;
            }
            rows[i]=sb.toString().trim();
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
