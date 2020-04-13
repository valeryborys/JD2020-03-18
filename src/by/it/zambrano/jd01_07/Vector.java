package by.it.zambrano.jd01_07;


import java.util.Arrays;

class Vector extends Var {
        private double[] value;

        Vector(double[] value) {
            this.value = value;
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
            this.value = doubleArray;
        }

        Vector(Vector vector) {
            this.value = Arrays.copyOf(vector.value, vector.value.length);
        }
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder("{");
                String delimiter = "";
                for (double element : value) {
                    sb.append(delimiter).append(element);
                    delimiter = ", ";
                }
                sb.append("}");
                return sb.toString();
            }
        }


