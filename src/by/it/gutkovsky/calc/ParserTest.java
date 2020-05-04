package by.it.gutkovsky.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkCalcWithScalarAdd() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual,1e-8);
    }

    @Test
    public void checkNextCalcWithScalarAdd() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        Var varA = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual,1e-8);
    }
}