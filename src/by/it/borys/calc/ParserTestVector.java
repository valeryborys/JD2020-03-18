package by.it.borys.calc;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTestVector {

    @Test
    public void createAndPrintVector() throws CalcExeption {
        String expected = "{78.8, 8.0, 9.85}";
        Parser parser = new Parser();
        Var calc = parser.calc("{78.8  ,  8, 9.85}");
        String v = calc.toString();
        assertEquals(expected,v);
    }
    @Test
    public void checkCalcAddVectors() throws CalcExeption {
        double[] expected = {2,4,6};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}+{1,2,3}");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcSubVectors() throws CalcExeption {
        double[] expected = {2,4,6};
        Parser parser = new Parser();
        Var calc = parser.calc("V={3,5,7}-{1,1,1}");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcMulVectors() throws CalcExeption {
        double expected = 68;
        Parser parser = new Parser();
        Var calc = parser.calc("{2,4,6}*{3,5,7}");
        double actual = ((Scalar)calc).getValue();
        assertEquals(expected,actual,1e-8);
    }

    @Test
    public void checkCalcVectorAddScalar() throws CalcExeption {
        double[] expected = {13,14,15};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}+12");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcVectorSubScalar() throws CalcExeption {
        double[] expected = {-11,-10,-9};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}-12");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcVectorMulScalar() throws CalcExeption {
        double[] expected = {2,4,6};
        Parser parser = new Parser();
        parser.calc("D=8");
        parser.calc("E=4");
        Var calc = parser.calc("V={1,2,3}*(D/E)");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcVectorDivScalar() throws CalcExeption {
        double[] expected = {0.5,1,1.5};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}/2");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcVectorWithBrackets() throws CalcExeption {
        double[] expected = {10,15};
        Parser parser = new Parser();
        parser.calc("D=10");
        Var calc = parser.calc("E={2,3}*(D/2)");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
}
