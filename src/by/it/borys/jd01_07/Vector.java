package by.it.borys.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector (Vector vector){
        this.value = vector.value;
    }

    Vector (String strVector){
        StringBuilder strArr = new StringBuilder(strVector);
        Pattern p1 = Pattern.compile("\\s*+[^0-9.-]+\\s*");
        Matcher m1 = p1.matcher(strArr);
        int pos=0;
        while (m1.find(pos)){
            int start = m1.start();
            int end = m1.end();
            strArr.replace(start,end," ");
            pos=start+1;
        }
        String string = strArr.toString().trim();
        String[] strArray = string.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] =Double.parseDouble(strArray[i]);
        }
        this.value = array;

    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append('{');
      String delimeter = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimeter).append(value[i]);
            delimeter = ", ";

        }
        sb.append('}');
        return sb.toString();
    }
}
