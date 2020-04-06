package by.it.borys.jd01_09;

public interface Pattern {

    static final String OPERATION = "[*/+-]";
    static final String SCALAR = "-?[0-9\\.]+";
    static final String VECTOR = "[{]((-?[0-9\\.]+)*,?)*[}]";
    static final String MATRIX = "[{]([{]((-?[0-9\\.]+)*,?)*[}],?)+[}]";
}
