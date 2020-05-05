package by.it.gutkovsky.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkCalcWithScalars() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected,actual,1e-8);
    }
    @Test
    public void checkNextCalcWithScalars() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test
    public void checkCalcNextB1WithScalars() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        parser.calc("B = 25.55");
        Var varB1 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(varB1.toString());
        assertEquals(expected,actual,1e-8);
    }

    @Test
    public void checkCalcNextB2WithScalars() throws Exception {
        //B2=A/2-1 (выведет на экран 2.65)
        double expected = 2.65;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB1 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(varB1.toString());
        assertEquals(expected,actual,1e-8);
    }

}