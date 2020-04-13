package by.it.sinevich.jd01_09;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            sb.append(delimiter).append(v);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }
    @Override
    public Var sub(Var other){
        double[] res = Arrays.copyOf(value, value.length);
        if(other instanceof Scalar){
            for (int i = 0; i < value.length; i++) {
                res[i]=res[i]-((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            for (int i = 0; i < value.length; i++) {
                res[i]=res[i]-((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.sub(this);
    }
    @Override
    public Var mul(Var other){
        double[] res = Arrays.copyOf(value, value.length);
        if(other instanceof Scalar){
            for (int i = 0; i < value.length; i++) {
                res[i]=res[i]*(((Scalar) other).getValue());
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            for (int i = 0; i < value.length; i++) {
                res[i]=res[i]*((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.mul(this);
    }
    @Override
    public Var div(Var other){
        double[] res = Arrays.copyOf(value, value.length);
        if(other instanceof Scalar) {
            for (int i = 0; i < value.length; i++) {
                res[i]=res[i]/((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if(other instanceof Vector){
            return super.div(this);
        }
        else
            return super.div(this);
    }
    //Спросить почему вывод вектора из строки не работает. Метод toString
}