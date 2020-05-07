package by.it.borys.calc;

public class CalcExeption extends Exception {
        public CalcExeption() {
        this(ResMan.res.get(Messages.unknownerr));
    }
    public CalcExeption(String message) {
        super(ResMan.res.get(Messages.err)+message);
    }

    public CalcExeption(String message, Throwable cause) {
        super(ResMan.res.get(Messages.err)+message, cause);
    }

    public CalcExeption(Throwable cause) {
        this(ResMan.res.get(Messages.unknownerr), cause);
    }
}
