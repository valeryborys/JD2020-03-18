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
    @Test
    public void checkCalcWithVectorsAdd() throws Exception {
        double [] expected = {2,4,6};
        Parser parser = new Parser();
        Var varV1 = parser.calc("V={1,2,3}+{1,2,3}");
        double[] actual = ((Vector) varV1).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcWithVectorsSub() throws Exception {
        double [] expected = {2,4,6};
        Parser parser = new Parser();
        Var varV2 = parser.calc("V={3,6,9}-{1,2,3}");
        double[] actual = ((Vector) varV2).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcWithVectorsMul() throws Exception {
        double expected = 42.0;
        Parser parser = new Parser();
        Var varV3 = parser.calc("V={3,6,9}*{1,2,3}");
        double actual = Double.parseDouble(varV3.toString());
        assertEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcWithVectorsDiv() throws Exception {
        double[] expected = {1.5,3.0,4.5};
        Parser parser = new Parser();
        Var varV4 = parser.calc("V = {3,6,9}/2");
        double[] actual = ((Vector) varV4).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }

}