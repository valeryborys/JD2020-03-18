package by.it.sinevich.calc;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;
    public Matrix(double[][] value){
        this.value = value;
    }
    public Matrix(Matrix matrix){
        this.value=matrix.value;
    }
    public Matrix(String strMatrix){

    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{");
        String delimiter;
        String delimiter1="{";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiter1);
            delimiter="";
            for (int j = 0; j < value.length; j++) {
                sb.append(delimiter).append(value[i][j]);
                delimiter=", ";
            }
            sb.append("}");
            if(i!=value.length-1) {
                sb.append(delimiter);
            }
        }
        sb.append("}");
        return sb.toString();
    }
    @Override
    public Var add(Var other){
        if(other instanceof Scalar){
            double[][] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j]=res[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix){
            double[][] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    res[i][j]=res[i][j]+((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else
            return super.add(this);
    }
}
