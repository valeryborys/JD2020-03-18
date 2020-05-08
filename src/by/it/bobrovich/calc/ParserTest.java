package by.it.bobrovich.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calcTestA1() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestA2() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        Var varA = parser.calc("B=A*3.5");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestA3() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        Var varA = parser.calc("B1=B+0.11*-5");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestA4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        Var varA = parser.calc("B2=A/2-1");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestB1() throws Exception {
        double expected = 40.15;
        Parser parser = new Parser();
        Var varA = parser.calc("C=B+(A*2)");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestB2() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        Var varA = parser.calc("D=((C-0.15)-20)/(7-5)");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestB3() throws Exception {
        double[] expected = {10, 15};
        Parser parser = new Parser();
        Var varB = parser.calc("E={2,3}*(D/2)");
        double[] value = ((Vector) varB).getValue();
        assertArrayEquals(expected, value, 1e-8);
    }
}