package by.it.tolstik.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test(timeout = 5000)
    public void checkCalcWithScalar1() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test(timeout = 5000)
    public void checkCalcWithScalar2() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        Var varA = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test(timeout = 5000)
    public void checkCalcWithScalar3() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        Var varA = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test(timeout = 5000)
    public void checkCalcWithScalar4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        Var varA = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected,actual,1e-8);
    }
}