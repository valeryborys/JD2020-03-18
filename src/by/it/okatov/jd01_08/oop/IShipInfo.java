package by.it.okatov.jd01_08.oop;

public interface IShipInfo {
    Coordinate move(int speed);

    boolean dropAnchor(boolean isAlreadyDropped);

    void signal();

    void moor();

    String sendCurrentCoordinateToHQ();
}
