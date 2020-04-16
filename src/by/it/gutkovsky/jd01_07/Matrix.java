package by.it.gutkovsky.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix other) {
        for (int i = 0; i < other.value.length; i++) {
            this.value = Arrays.copyOf(other.value, other.value.length);
        }
    }

    /*
        Matrix(String strMatrix) {
            String text = strMatrix.replaceAll("\\.", "A");
            System.out.println(text);

            // определение количества элементов
            int element = 0;
            StringBuilder sb = new StringBuilder(text);
            Pattern pattern1 = Pattern.compile(",");
            Matcher matcher1 = pattern1.matcher(sb);
            while (matcher1.find()){
                element++;
            }

            int elementCount = element+1;
            System.out.println("количество элементов "+elementCount);

            // разбиваю текс на массив строк
            String[] textArray = text.split("},");
            int rowCount = textArray.length; // число строк
            System.out.println("число строк " + rowCount);

            int columnCount = elementCount/rowCount; //число столбцов
            System.out.println("число столбцов " + columnCount);
            int j = 0;


            String[][] stringArray = new String[rowCount][columnCount];

            Pattern pattern = Pattern.compile("\\b\\dA?\\d?\\b");
            for (int i = 0; i < textArray.length; i++) {
                StringBuilder sb1 = new StringBuilder(textArray[i]);
                Matcher matcher = pattern.matcher(sb1);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    stringArray[i][j] =  sb1.substring(start, end);
                    j++;
                }
                j = 0;
            }

            // возвращаем точку обратно
            String[][] stringArray2 = new String[stringArray.length][stringArray[0].length];
            for (int i = 0; i < stringArray.length; i++) {
                for (int k = 0; k < stringArray.length; k++) {
                    stringArray2[i][k] = stringArray[i][k].replace('A','.');
                }
            }

            // перевод массива String в double

            double[][] result = new double[stringArray2.length][stringArray2[0].length];
            for (int i = 0; i < stringArray2.length; i++) {
                for (int k = 0; k < stringArray2.length; k++) {
                    result[i][k] = Double.parseDouble(stringArray2[i][k]);
                }
            }

            this.value = result;
        }
    */
    Matrix(String strMatrix) {
        String text = strMatrix.replaceAll("\\{", "");
        StringBuilder textCopy = new StringBuilder(text);
        Pattern pattern = Pattern.compile("},");
        String[] arrayOfRow = pattern.split(textCopy);

//        System.out.println(Arrays.toString(arrayOfRow));
//        System.out.println(arrayOfRow[0]);
//        System.out.println(arrayOfRow[1]);

        this.value = new double[arrayOfRow.length][];
        for (int i = 0; i < arrayOfRow.length; i++) {
            String row = arrayOfRow[i].replaceAll("}", "").trim();
            String[] column = row.split(",");
            this.value[i] = new double[column.length];
            for (int j = 0; j < column.length; j++) {
                this.value[i][j] = Double.parseDouble(column[j]);
            }
        }

//        System.out.println(Arrays.deepToString(this.value));
    }

    @Override
    public String toString() {
        if (value == null)
            return "null";
        int iMaxRow = value.length - 1;
        int jMaxColumn = value[0].length - 1;
        if (iMaxRow == -1 && jMaxColumn == -1) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < value.length; i++) {
            sb.append("{ ");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if ((j != value[0].length - 1)) sb.append(", ");
                else sb.append(" }");
            }
            if (i != value.length - 1) sb.append(", ");

        }

        sb.append(" }");

        return sb.toString();
    }
}


