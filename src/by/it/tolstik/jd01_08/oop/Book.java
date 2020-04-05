package by.it.tolstik.jd01_08.oop;

abstract class Book {
    String name;
    String author;
    String genre;
    int yearProduce;
    int amountPages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearProduce() {
        return yearProduce;
    }

    public void setYearProduce(int yearProduce) {
        this.yearProduce = yearProduce;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(int amountPages) {
        this.amountPages = amountPages;
    }

    @Override
    public String toString() {
        return name + "\n" +
                author + "\n" +
                genre + "\n" +
                "Колличество страниц: " + amountPages + "\n" +
                "Год выпуска " + yearProduce;
    }
}
