package by.it.gutkovsky.jd01_08;

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

    Matrix(String strMatrix) {
//        String text = strMatrix;
        String text = strMatrix.replaceAll("\\.", "A"); // замена . на "А" - чтобы случайно не удалить
        String[] strMatrixArrayTemp = text.split("},"); // массив строк

        String[] MatrixArrayFirst = strMatrixArrayTemp[0].split(","); // каждую строку разбиваю на отдельные элементы
        String[] MatrixArraySecond = strMatrixArrayTemp[1].split(",");

        StringBuilder[] firstMatrix = new StringBuilder[MatrixArrayFirst.length];
        Pattern pattern = Pattern.compile("\\p{Punct}");

        // удаление всех знаков пунктуации из первого массива
        for (int i = 0; i < MatrixArrayFirst.length; i++) {
            StringBuilder sb = new StringBuilder(MatrixArrayFirst[i]);
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                int pos = matcher.start();
                sb.setCharAt(pos, ' ');
                firstMatrix[i] = sb;
            }
            firstMatrix[i] = sb; // если в строке нет совпадений по паттерну - ее просто копируем
        }

        // удаление всех знаков пунктуации из первого массива
        StringBuilder[] SecondMatrix = new StringBuilder[MatrixArraySecond.length];
        for (int i = 0; i < MatrixArraySecond.length; i++) {
            StringBuilder sb = new StringBuilder(MatrixArraySecond[i]);
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                int pos = matcher.start();
                sb.setCharAt(pos, ' ');
                SecondMatrix[i] = sb;
            }
            SecondMatrix[i] = sb; // если в строке нет совпадений по паттерну - ее просто копируем
        }

        // меняю обратно точку на А
        Pattern pat = Pattern.compile("A");
        for (int i = 0; i < firstMatrix.length; i++) {
            StringBuilder sb = new StringBuilder(firstMatrix[i]);
            Matcher matcher = pat.matcher(sb);
            while (matcher.find()) {
                int pos = matcher.start();
                sb.setCharAt(pos, '.');
                firstMatrix[i] = sb;
            }
        }

        for (int i = 0; i < SecondMatrix.length; i++) {
            StringBuilder sb = new StringBuilder(SecondMatrix[i]);
            Matcher matcher = pat.matcher(sb);
            while (matcher.find()) {
                int pos = matcher.start();
                sb.setCharAt(pos, '.');
                SecondMatrix[i] = sb;
            }
        }

        // копирование массива из StringBuilder в  String - чтобы удилаить лишние пробелы (trim())
        String[] firstMatrixString = new String[firstMatrix.length];
        for (int i = 0; i < firstMatrixString.length; i++) {
            firstMatrixString[i] = firstMatrix[i].toString();
        }

        String[] secondMatrixString = new String[SecondMatrix.length];
        for (int i = 0; i < secondMatrixString.length; i++) {
            secondMatrixString[i] = SecondMatrix[i].toString();
        }

        // из двух массивов типа String  делаю два массива типа double
        double[] firstMatrixArray = new double[firstMatrixString.length];
        for (int i = 0; i < firstMatrixArray.length; i++) {
            firstMatrixArray[i] = Double.parseDouble(firstMatrixString[i].trim());
        }

        double[] secondMatrixArray = new double[secondMatrixString.length];
        for (int i = 0; i < secondMatrixArray.length; i++) {
            secondMatrixArray[i] = Double.parseDouble(secondMatrixString[i].trim());
        }

        // копирую дваа одномерных массива в один двумерный
        double[][] result = new double[2][firstMatrixArray.length];

        System.arraycopy(firstMatrixArray, 0, result[0], 0, firstMatrixArray.length);
        System.arraycopy(secondMatrixArray, 0, result[1], 0, secondMatrixArray.length);

//        System.out.println(Arrays.deepToString(result)); // проверка стандартного вывода на печать


        this.value = result;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            // копирование матрицы
            double[][] matrixResultSum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSum[i] = Arrays.copyOf(this.value[i], this.value.length);
            }

//            for (int i = 0; i < matrixResultSum.length; i++) {
//                for (int j = 0; j < matrixResultSum.length; j++) {
//                    matrixResultSum[i][j] = this.value[i][j];
//                }
//            }

            for (int i = 0; i < matrixResultSum.length; i++) {
                for (int j = 0; j < matrixResultSum.length; j++) {
                    matrixResultSum[i][j] = matrixResultSum[i][j] + ((Scalar) other).getValue();
                }
            }

            return new Matrix(matrixResultSum);
        }
        if (other instanceof Matrix) {
            // копирование матрицы
            double[][] matrixResultSum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSum[i] = Arrays.copyOf(this.value[i], this.value.length);
            }

//            for (int i = 0; i < matrixResultSum.length; i++) {
//                for (int j = 0; j < matrixResultSum.length; j++) {
//                    matrixResultSum[i][j] = this.value[i][j];
//                }
//            }
            if (matrixResultSum.length == ((Matrix) other).value.length && matrixResultSum[0].length == ((Matrix) other).value.length) {

                for (int i = 0; i < matrixResultSum.length; i++) {
                    for (int j = 0; j < matrixResultSum.length; j++) {
                        matrixResultSum[i][j] = matrixResultSum[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(matrixResultSum);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            // копирование матрицы
            double[][] matrixResultSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSub[i] = Arrays.copyOf(this.value[i], this.value.length);
            }

//            for (int i = 0; i < matrixResultSub.length; i++) {
//                for (int j = 0; j < matrixResultSum.length; j++) {
//                    matrixResultSub[i][j] = this.value[i][j];
//                }
//            }

            for (int i = 0; i < matrixResultSub.length; i++) {
                for (int j = 0; j < matrixResultSub.length; j++) {
                    matrixResultSub[i][j] = matrixResultSub[i][j] - ((Scalar) other).getValue();
                }
            }

            return new Matrix(matrixResultSub);
        }
        if (other instanceof Matrix) {
            // копирование матрицы
            double[][] matrixResultSub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultSub[i] = Arrays.copyOf(this.value[i], this.value.length);
            }

//            for (int i = 0; i < matrixResultSub.length; i++) {
//                for (int j = 0; j < matrixResultSub.length; j++) {
//                    matrixResultSub[i][j] = this.value[i][j];
//                }
//            }
            if (matrixResultSub.length == ((Matrix) other).value.length && matrixResultSub[0].length == ((Matrix) other).value.length) {

                for (int i = 0; i < matrixResultSub.length; i++) {
                    for (int j = 0; j < matrixResultSub.length; j++) {
                        matrixResultSub[i][j] = matrixResultSub[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(matrixResultSub);
            }
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] matrixResultMult = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixResultMult[i] = Arrays.copyOf(this.value[i], this.value.length);
            }

            for (int i = 0; i < matrixResultMult.length; i++) {
                for (int j = 0; j < matrixResultMult.length; j++) {
                    matrixResultMult[i][j] = matrixResultMult[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(matrixResultMult);
        }

        if (other instanceof Vector) {
            if (this.value[0].length == ((Vector) other).getValue().length) {
                double[] multipliedMatrix = new double[this.value.length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                        multipliedMatrix[i] = multipliedMatrix[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                    }
                }
                return new Vector(multipliedMatrix);
            }
        }

        if (other instanceof Matrix) {
            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value.length) {
                double[][] multipliedMatrix = new double[this.value.length][((Matrix) other).value[0].length];
                for (int i = 0; i < this.value.length; i++) {
                    for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                        for (int k = 0; k < this.value.length; k++) {
                            multipliedMatrix[i][j] = multipliedMatrix[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }
                }
                return new Matrix(multipliedMatrix);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {

        if (other instanceof Scalar){
            if (((Scalar) other).getValue() != 0){
                double[][] resultDivMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < resultDivMatrix.length; i++) {
                    for (int j = 0; j < resultDivMatrix.length; j++) {
                        resultDivMatrix[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(resultDivMatrix);
            }
        }

        return super.div(other);
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

        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if ((j != value[0].length - 1)) sb.append(", ");
                else sb.append("}");
            }
            if (i != value.length - 1) sb.append(", ");

        }

        sb.append("}");

        return sb.toString();
    }

//    @Override
//    public String toString() {
//        if (value == null)
//            return "null";
//        int iMaxRow = value.length - 1;
//        int jMaxColumn = value[0].length - 1;
//        if (iMaxRow == -1 && jMaxColumn == -1) {
//            return "{}";
//        }
//
//        StringBuilder sb = new StringBuilder("{ ");
//        for (int i = 0; i < value.length; i++) {
//            sb.append("{ ");
//            for (int j = 0; j < value[0].length; j++) {
//                sb.append(value[i][j]);
//                if ((j != value[0].length - 1)) sb.append(", ");
//                else sb.append(" }");
//            }
//            if (i != value.length - 1) sb.append(", ");
//
//        }
//
//        sb.append(" }");
//
//        return sb.toString();
//    }
}


