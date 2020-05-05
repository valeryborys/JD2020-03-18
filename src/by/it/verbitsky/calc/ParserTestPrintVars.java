package by.it.verbitsky.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestPrintVars {
    static Var varA;

    //Scalar
    @Test
    public void checkPrintScalar() {
        System.out.println("Test Print Scalar");
        String expected = "10.0";
        Parser parser = new Parser();
        varA = new Scalar(10);
        String actual = varA.toString();
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual);
    }

    //Vector
    @Test
    public void checkPrintVector() {
        System.out.println("Test Print Vector");
        String expected = "{1.5, 2.7, 33.1}";
        Parser parser = new Parser();
        varA = new Vector(new double[]{1.5, 2.7, 33.1});
        String actual = varA.toString();
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    //Matrix
    @Test
    public void checkPrintMatrix() {
        System.out.println("Test Create Scalar from double value");
        String expected = "{{4.5, 5.0, 6.1}, {1.0, 2.7, 3.9}}";
        Parser parser = new Parser();
        varA = new Matrix(new double[][]{{4.5, 5, 6.1}, {1, 2.7, 3.9}});
        String actual = varA.toString();
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }
}