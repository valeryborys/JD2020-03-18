package by.it.gutkovsky.jd01_08.oop;

interface Publication {
    //1
    Book print(String other);
    //2
    void read(Book other);
    //3
    Book printNewEdition (Book other);
    //4
    Book sell (Book other);
    //5
    Book buy(Book other);
    //6
    void store(Book other);
    //7
    Book borrow(Book other);

}
