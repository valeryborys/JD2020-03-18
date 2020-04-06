package by.it.tolstik.jd01_08.oop;

abstract class Player implements Technic {

    private final String model;
    private boolean exist;

    Player(String model, boolean exist) {
        this.model = model;
        this.exist = exist;
    }

    public String getModel() {
        return model;
    }

    public boolean getExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    @Override
    public String toString() {
        return "Переопредели метод";
    }
}
