package by.it.szamostyanin.Calc;

import org.junit.Test;
import static org.junit.Assert.*;
public class ParserTestVector {

    @Test
    public void checkSum() throws Exception {
        double[] expected = {10, 10};
        Parser parser = new Parser();
        Var varA = parser.calc("{2,4} + {8,6}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkSub() throws Exception {
        double[] expected = {10, 20};
        Parser parser = new Parser();
        Var varA = parser.calc("{14,24}-4");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkSub2() throws Exception {
        double[] expected = {-6, -2};
        Parser parser = new Parser();
        Var varA = parser.calc("{2,4}-{8,6}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMul() throws Exception {
        double expected = 30;
        Parser parser = new Parser();
        Var varA = parser.calc("{2,4}*{3,6}");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkDiv() throws Exception {
        double[] expected = {1, 1};
        Parser parser = new Parser();
        Var varA = parser.calc("{5,5}/5");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }
}
