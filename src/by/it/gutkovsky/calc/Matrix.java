package by.it.gutkovsky.calc;

import java.util.Arrays;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix other) {
//        for (int i = 0; i < other.value.length; i++) {
        this.value = Arrays.copyOf(other.value, other.value.length);
//        }
    }

/*
        Matrix(String strMatrix) {
            String text = strMatrix.replaceAll("\\.", "A");
            //        System.out.println(text);

            // определение количества элементов
            int element = 0;
            StringBuilder sb = new StringBuilder(text);
            Pattern pattern1 = Pattern.compile(",");
            Matcher matcher1 = pattern1.matcher(sb);
            while (matcher1.find()) {
                element++;
            }

            int elementCount = element + 1;
            //        System.out.println("количество элементов "+elementCount);

            // разбиваю текс на массив строк
            String[] textArray = text.split("},");
            int rowCount = textArray.length; // число строк
            //        System.out.println("число строк " + rowCount);

            int columnCount = elementCount / rowCount; //число столбцов
            //        System.out.println("число столбцов " + columnCount);
            int j = 0;


            String[][] stringArray = new String[rowCount][columnCount];

            Pattern pattern = Pattern.compile("\\b\\dA?\\d?\\b");
            for (int i = 0; i < textArray.length; i++) {
                StringBuilder sb1 = new StringBuilder(textArray[i]);
                Matcher matcher = pattern.matcher(sb1);
                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    stringArray[i][j] = sb1.substring(start, end);
                    j++;
                }
                j = 0;
            }

            // возвращаем точку обратно
            String[][] stringArray2 = new String[stringArray.length][stringArray[0].length];
            for (int i = 0; i < stringArray.length; i++) {
                for (int k = 0; k < stringArray.length; k++) {
                    stringArray2[i][k] = stringArray[i][k].replace('A', '.');
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
        this.value = new double[arrayOfRow.length][];
        for (int i = 0; i < arrayOfRow.length; i++) {
            String row = arrayOfRow[i].replaceAll("}", "").trim();
            String[] column = row.split(",");
            this.value[i] = new double[column.length];
            for (int j = 0; j < column.length; j++) {
                this.value[i][j] = Double.parseDouble(column[j]);
            }
        }
    }

    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            // копирование матрицы
            double[][] matrixResultSum = Arrays.copyOf(this.value, this.value.length);

            for (int i = 0; i < matrixResultSum.length; i++) {
                for (int j = 0; j < matrixResultSum[0].length; j++) {
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

            if (this.value.length == ((Matrix) other).value.length && this.value[0].length == ((Matrix) other).value.length) {
                for (int i = 0; i < matrixResultSum.length; i++) {
                    for (int j = 0; j < matrixResultSum[0].length; j++) {
                        matrixResultSum[i][j] = matrixResultSum[i][j] + ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(matrixResultSum);
            } else throw new CalcException("Incompatible size");
        }
        return super.add(other);
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            // копирование матрицы
            double[][] matrixResultSub = Arrays.copyOf(this.value, this.value.length);

            for (int i = 0; i < matrixResultSub.length; i++) {
                for (int j = 0; j < matrixResultSub[0].length; j++) {
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

            if (matrixResultSub.length == ((Matrix) other).value.length && matrixResultSub[0].length == ((Matrix) other).value[0].length) {
                for (int i = 0; i < matrixResultSub.length; i++) {
                    for (int j = 0; j < matrixResultSub[0].length; j++) {
                        matrixResultSub[i][j] = matrixResultSub[i][j] - ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(matrixResultSub);
            } else throw new CalcException("Incompatible size");
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            // копирование матрицы
            double[][] matrixResultMult = Arrays.copyOf(this.value, this.value.length);

            for (int i = 0; i < matrixResultMult.length; i++) {
                for (int j = 0; j < matrixResultMult[0].length; j++) {
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
            } else throw new CalcException("Incompatible size");
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
            } else throw new CalcException("Incompatible size");
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {

        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0) {
                double[][] resultDivMatrix = new double[this.value.length][this.value[0].length];
                for (int i = 0; i < resultDivMatrix.length; i++) {
                    for (int j = 0; j < resultDivMatrix.length; j++) {
                        resultDivMatrix[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                    }
                }
                return new Matrix(resultDivMatrix);
            }
            throw new CalcException("Division by zero is impossible");
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


