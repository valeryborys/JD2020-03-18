package by.it.szamostyanin.Calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestPrint {

    @Test
    public void checkPrintScalar() {
        System.out.println("Test Scalar");
        String expected = "20.0";
        Parser parser = new Parser();
        Var varA = new Scalar(20);
        String actual = varA.toString();
        System.out.print("actual = " + actual + "\n" + "expected = " + expected);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPrintVector() {
        System.out.println("Test Vector");
        String expected = "{1.1, 2.2, 3.3}";
        Parser parser = new Parser();
        Var varA = new Vector(new double[]{1.1, 2.2, 3.3});
        String actual = varA.toString();
        System.out.print("actual = " + actual + "\n" + "expected = " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }

    @Test
    public void checkPrintMatrix() {
        System.out.println("Test Matrix");
        String expected = "{{2.2, 4.4, 6.6}, {1.1, 3.3, 5.5}}";
        Parser parser = new Parser();
        Var varA = new Matrix(new double[][]{{2.2, 4.4, 6.6}, {1.1, 3.3, 5.5}});
        String actual = varA.toString();
        System.out.print("actual = " + actual + "\n" + "expected = " + expected);
        assertEquals(expected, actual);
        System.out.println();
    }
}