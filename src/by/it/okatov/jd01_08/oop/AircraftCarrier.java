package by.it.okatov.jd01_08.oop;

public class AircraftCarrier extends WarShip {

    String sShipName;
    boolean isAnchorDropped;
    boolean isMoored;

    public void setsShipName(String sShipName) {
        this.sShipName = sShipName;
    }

    public String getsShipName() {
        return this.sShipName = "Sweet Home Alabama";
    }

    public boolean isAnchorDropped() {
        return this.isAnchorDropped;
    }

    public void setAnchorDropped(boolean anchorDropped) {
        this.isAnchorDropped = anchorDropped;
    }

    public boolean isMoored() {
        return this.isMoored;
    }

    public void setMoored(boolean moored) {
        this.isMoored = moored;
    }

    @Override
    public Coordinate move(int speed) {
        if (speed > 0) {
            Coordinate coord = new Coordinate();
            float coordChangeX = coord.getCoordX();
            float coordChangeY = coord.getCoordY();

            coordChangeX += speed;
            coordChangeY += speed;

            coord.setCoordX(coordChangeX);
            coord.setCoordY(coordChangeY);
            return coord;
        } else {
            return super.move(speed);
        }
    }

    @Override
    public boolean dropAnchor(boolean isAlreadyDropped) {
        if (!isAlreadyDropped) {
            System.out.println("Performing anchor drop!");
            setAnchorDropped(true);
            return isAnchorDropped();
        } else {
            setAnchorDropped(false);
            return super.dropAnchor(isAnchorDropped());
        }
    }

    @Override
    public void signal() {
        super.signal();
    }

    @Override
    public void moor() {
        if (!isMoored) {
            System.out.println("Performing mooring!\n");
            setMoored(true);
        } else {
            setMoored(false);
            super.moor();
        }

    }

    @Override
    public String sendCurrentCoordinateToHQ() {
        return super.sendCurrentCoordinateToHQ();
    }

    @Override
    public void startCombatDuty() {
        super.startCombatDuty();
    }

    @Override
    public void endCombatDuty() {
        super.endCombatDuty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AircraftCarrier:\n");
        sb.append("{Name: ").append(sShipName).append("}\n");
        sb.append("{Coordinates: ").append(sendCurrentCoordinateToHQ()).append("}\n");
        sb.append("{Anchor dropped: ").append(isAnchorDropped()).append("}\n");
        sb.append("{Mooring status: ").append(isMoored()).append("}\n");
        return sb.toString();
    }
}
