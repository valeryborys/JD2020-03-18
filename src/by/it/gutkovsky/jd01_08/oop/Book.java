package by.it.gutkovsky.jd01_08.oop;

abstract class Book implements Publication {
    @Override
    public Book print(String other) {
        System.out.println("This book must be printed");
        return null;
    }

    @Override
    public void read(Book other) {
        System.out.println("Everyone have to read books");
    }

    @Override
    public Book printNewEdition(Book other) {
        System.out.println("New edition was printed");
        return null;
    }

    @Override
    public Book sell(Book other) {
        System.out.println("Book was sold");
        return null;
    }

    @Override
    public Book buy(Book other) {
        System.out.println("Book was bought ");
        return null;
    }

    @Override
    public void store(Book other) {
        System.out.println("bookshop");
    }

    @Override
    public Book borrow(Book other) {
        System.out.println("Book has been borrowed");
        return null;
    }

    @Override
    public String toString() {
        return "Abstract Book";
    }
}
