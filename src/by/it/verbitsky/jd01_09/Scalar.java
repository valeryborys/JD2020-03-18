package by.it.verbitsky.jd01_09;

//class Scalar extends Var implements ScalarOperations {
class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar obj) {
        this.value = obj.value;
    }

    Scalar(String s) {
        this.value = Double.parseDouble(s);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }

    //------------------------------------------------------------------------------

   /*
    public Var add(Var other) {
        System.out.println("Scalar add");
       // System.out.println(other.getClass());
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() + ((Scalar) other).getValue());
        }

        if (other instanceof Vector) {
            Vector vector = new Vector(Arrays.copyOf(((Vector) other).getVector(), ((Vector) other).getVector().length));
            for (int i = 0; i < vector.getVector().length; i++) {
                vector.getVector()[i]+=getValue();
            }
            return vector;
        }

        if (other instanceof Matrix) {
        Matrix matrix = new Matrix(Arrays.copyOf(((Matrix) other).getMatrix(), ((Matrix) other).getMatrix().length));
            for (double[] doubles : matrix.getMatrix()) {
                for (int j = 0; j < doubles.length; j++) {
                    doubles[j]+=getValue();
                }
            }
            return matrix;
        }
       return super.add(other);
    }
*/

    //Сложение
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() + ((Scalar) other).getValue());
        } else {
            return other.add(this);
        }
    }

    //Вычитание
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() - ((Scalar) other).getValue());
        } else {
            return other.sub(new Scalar(-1).mul(other).add(this));
        }
    }

    //Умножение
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.getValue() * ((Scalar) other).getValue());
        } else {
            return other.mul(this);
        }
    }

    //Деление
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() != 0)
                return new Scalar(this.getValue() / ((Scalar) other).getValue());
        }
        return super.div(other);
    }


/*
    // методы для динамической связки (полиморфизма)
    @Override
    public Var add(Scalar operand) {
        //System.out.println("Сложение скаляра и скаляра");
        return new Scalar(this.getValue() + operand.getValue());
    }

    @Override
    public Var add(Vector operand) {
        //System.out.println("Сложение Скаляра и вектора");
        Vector vector = new Vector(Arrays.copyOf(operand.getVector(), operand.getVector().length));
        for (double element : vector.getVector()) {
            element += this.getValue();
        }
        return vector;
    }

    @Override
    public Var add(Matrix operand) {
        //System.out.println("Сложение скаляра и матрицы");
        Matrix matrix = new Matrix(Arrays.copyOf(operand.getMatrix(), operand.getMatrix().length));
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[i].length; j++) {
                matrix.getMatrix()[i][j] += this.getValue();
            }
        }
        return matrix;
    }*/
}


























