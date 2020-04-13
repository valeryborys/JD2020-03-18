package by.it.okatov.jd01_08.oop;

public abstract class WarShip implements IShipInfo {
    @Override
    public Coordinate move(int speed) {
        System.out.println("Movement is impossible, because movement speed is " + speed);
        return null;
    }

    @Override
    public boolean dropAnchor(boolean isAlreadyDropped) {
        System.out.println("Dropping of anchor is prohibited!");
        return false;
    }

    @Override
    public void signal() {
        System.out.println("Sending signals is impossible due to several reasons!");
    }

    @Override
    public void moor() {
        System.out.println("Mooring is impossible:\nNo suitable place to moor!");
    }

    @Override
    public String sendCurrentCoordinateToHQ() {
        return new Coordinate().toString();
    }

    public void startCombatDuty() {
        System.out.println("Cannot start combat duty!");
    }

    public void endCombatDuty() {
        System.out.println("Cannot end combat duty!");
    }
}
