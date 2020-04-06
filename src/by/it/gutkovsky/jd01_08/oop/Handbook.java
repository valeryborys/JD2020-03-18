package by.it.gutkovsky.jd01_08.oop;

class Handbook extends Book {
    private String handBookName;

    Handbook(String handBookName){
        this.handBookName = handBookName;
    }

    @Override
    public Book print(String other) {
        this.handBookName = other;
        System.out.println(this.handBookName + "  was printed");
        return new Handbook(this.handBookName);
    }
}
