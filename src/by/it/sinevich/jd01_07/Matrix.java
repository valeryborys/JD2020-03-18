package by.it.sinevich.jd01_07;

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
}
