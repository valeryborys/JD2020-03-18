package by.it.tolstik.jd01_08.oop;

class Help extends Book implements Edition{
    @Override
    public void equalGenre() {

    }

    @Override
    public boolean equalAuthor() {
        return false;
    }

    @Override
    public int maxPages() {
        return 0;
    }

    @Override
    public int minPages() {
        return 0;
    }

    @Override
    public boolean isEmptyRandomAuthor() {
        return false;
    }

    @Override
    public void printAllBooksName() {

    }

    @Override
    public void printAllBooksInfo() {

    }
}
