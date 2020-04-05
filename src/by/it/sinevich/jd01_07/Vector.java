package by.it.sinevich.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;
    public Vector(double[] value){
        this.value=value;
    }
    public Vector(Vector vector){
        this.value=vector.value;
    }
    public Vector(String strVector){
        }



   @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
       for (double v : value) {
           sb.append(delimiter).append(v);
           delimiter=", ";
       }
       sb.append("}");
       return sb.toString();
   }

}
