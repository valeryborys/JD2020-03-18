package by.it.akhmelev.calc19;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkCalcWithScalars() throws Exception {
        double expected=7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test
    public void checkNextCalcWithScalars() throws Exception {
        double expected=25.55;
        Parser parser = new Parser();
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test
    public void checkCalcWithVectors() throws Exception {
        double[] expected={2,4,6};
        Parser parser = new Parser();
        Var vector = parser.calc("V={1,2,3}+{1,2,3}");
        double[] actual = ((Vector)vector).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
}