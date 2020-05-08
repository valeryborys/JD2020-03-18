package by.it.borys.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;
    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {

        this.value = value;
    }


    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        StringBuilder strArr = new StringBuilder(strVector);
        Pattern p1 = Pattern.compile("\\s*+[^0-9.-]+\\s*");
        Matcher m1 = p1.matcher(strArr);
        int pos = 0;
        while (m1.find(pos)) {
            int start = m1.start();
            int end = m1.end();
            strArr.replace(start, end, " ");
            pos = start + 1;
        }
        String string = strArr.toString().trim();
        String[] strArray = string.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
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

    @Override
    public Var add(Var other) throws CalcExeption {
       if (other instanceof Scalar){
           double[] res = Arrays.copyOf(this.value,this.value.length);
           for (int i = 0; i < res.length; i++) {
               res[i] = res[i]+((Scalar) other).getValue();
           }
           return new Vector(res);
       }
       else if (other instanceof Vector && this.value.length==((Vector) other).value.length){
           double[] res = new double[this.value.length];
           for (int i = 0; i < res.length; i++) {
               res[i] = this.value[i]+((Vector) other).value[i];
           }
           return new Vector(res);
       }
       else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
          if (other instanceof Scalar){
              double[] res = Arrays.copyOf(this.value, this.value.length);
              for (int i = 0; i < res.length; i++) {
                  res[i] = res[i] - ((Scalar) other).getValue();
              }
              return new Vector(res);
          }
          else if(other instanceof Vector && this.value.length==((Vector) other).value.length){
              double[] res = Arrays.copyOf(this.value, this.value.length);
              for (int i = 0; i < res.length; i++) {
                  res[i] = res[i] - ((Vector) other).value[i];
              }
              return new Vector(res);
          }
          else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]*((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector && this.value.length==((Vector) other).value.length){
            double[] res = new double[this.value.length];
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] = this.value[i]*((Vector) other).value[i];
                sum +=res[i];
            }
            return new Scalar(sum);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar && ((Scalar) other).getValue()!=0){
            double[] res = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]/((Scalar) other).getValue();
            }
            return new Vector(res);
        }
    return super.div(other);
    }

}
