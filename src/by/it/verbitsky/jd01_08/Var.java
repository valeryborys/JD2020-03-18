package by.it.verbitsky.jd01_08;

abstract class Var implements Operation {
    @Override
    public String toString() {
        return " Abstract Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Вызван метод ADD Абстрактного класса VAR");
        System.out.printf("\nOperation 'add' impossible  with arguments: %s and %s ", this.toString(), other.toString());
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("\nOperation 'sub' impossible  with arguments: %s and %s ", this.toString(), other.toString());
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("\nOperation 'mul' impossible  with arguments: %s and %s ", this.toString(), other.toString());
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("\nOperation 'div' impossible  with arguments: %s and %s ", this.toString(), other.toString());
        return null;
    }

}
