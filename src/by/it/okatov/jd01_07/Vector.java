package by.it.okatov.jd01_07;

import java.util.Arrays;


@SuppressWarnings("ALL")
class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    /*void Show(double[] value)
    {
        for (double v : value) {
            System.out.println(v);
        }
    }*/

    Vector(String strValue) {
        for (char ch : strValue.toCharArray()) {
            if (ch == '{' || ch == '}') {
                strValue = strValue.replace(Character.toString(ch), "");
            }
        }
        String[] strArray = Arrays.copyOf(strValue.split(","), strValue.split(",").length);
        value = new double[strArray.length];

        for (int j = 0; j < value.length; j++) {
            this.value[j] = Double.parseDouble(strArray[j]);
        }
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    //Спросить про AtomicReference в Java и в этом методе - нужно ли и когда?
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i < (value.length - 1)) {
                sb.append(", ");
            } else {
                sb.append("}");
            }
        }
        return sb.toString();
    }
}
