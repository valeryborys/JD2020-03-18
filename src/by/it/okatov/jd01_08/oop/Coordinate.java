package by.it.okatov.jd01_08.oop;

public class Coordinate {
    float CoordX;
    float CoordY;

    public float getCoordX() {
        return CoordX;
    }

    public float getCoordY() {
        return CoordY;
    }

    public void setCoordX(float coordX) {
        CoordX = coordX;
    }

    public void setCoordY(float coordY) {
        CoordY = coordY;
    }

    public Coordinate(float coordX, float coordY) {
        CoordX = coordX;
        CoordY = coordY;
    }

    public Coordinate() {
        this.setCoordX(0.0f);
        this.setCoordY(0.0f);
    }

    @Override
    public String toString() {
        return "Houston, my current coordinates are:\n {" + "CoordX=" + getCoordX() + ", CoordY=" + getCoordY() + '}';
    }
}
