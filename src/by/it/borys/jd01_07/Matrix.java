package by.it.borys.jd01_07;


class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        String delimiter1 = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiter1).append("{");
            String delimiter2 = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter2).append(value[i][j]);
                delimiter2 = ", ";
                }
            sb.append("}");
            delimiter1 = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
