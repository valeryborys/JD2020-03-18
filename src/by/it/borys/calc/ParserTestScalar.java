package by.it.borys.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTestScalar {
    @Test
    public void createAndPrintScalar() throws CalcExeption {
        String expected = "85.55";
        Parser parser = new Parser();
        Var calc = parser.calc("A=85.55");
        String v = calc.toString();
        assertEquals(expected, v);

    }

    @Test
    public void checkCalcAddScalars() throws CalcExeption {
        double expected = 7.3;
        Parser parser = new Parser();
        Var calc = parser.calc("A=2+5.3");
        double v = Double.parseDouble(calc.toString());
        assertEquals(expected,v,1e-8);

    }
    @Test
    public void checkCalcMulScalars() throws CalcExeption {
        double expected = 25.55;
        Parser parser = new Parser();
        parser.calc("A=7.3");
        Var calc = parser.calc("B=A*3.5");
        double v = Double.parseDouble(calc.toString());
        assertEquals(expected,v,1e-8);

    }
    @Test
    public void checkCalcDivScalars() throws CalcExeption {
        double expected = 11.12328767;
        Parser parser = new Parser();
        parser.calc("A=81.2");
        parser.calc("B=7.3");
        Var calc = parser.calc("C=A/B");
        double v = Double.parseDouble(calc.toString());
        assertEquals(expected,v,1e-8);

    }

    @Test
    public void checkCalcSubScalars() throws CalcExeption {
        double expected = 7.3;
        Parser parser = new Parser();
        Var calc = parser.calc("13.3-6.0");
        double v = Double.parseDouble(calc.toString());
        assertEquals(expected,v,1e-8);

    }
    @Test
    public void checkCalcScalarAddVector() throws CalcExeption {
        double[] expected = {9,10,11};
        Parser parser = new Parser();
        Var calc = parser.calc("V=8+{1,2,3}");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcScalarSubVector() throws CalcExeption {
        double[] expected = {7, 6, 5};
        Parser parser = new Parser();
        Var calc = parser.calc("V=8-{1,2,3}");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcScalarMulVector() throws CalcExeption {
        double[] expected = {8,16,24};
        Parser parser = new Parser();
        Var calc = parser.calc("V=8*{1,2,3}");
        double[] actual = ((Vector)calc).getValue();
        assertArrayEquals(expected,actual,1e-8);
    }
    @Test
    public void checkCalcScalarAddMatrix() throws CalcExeption {
        double[][] expected = {{11.0,12.0,13.0},{17.0,18.0,19.0},{14.5,15.1,16}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z=10+{{1, 2,3}, {7 ,8.0 ,9},{4.5,5.1, 6.0}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcScalarSubMatrix() throws CalcExeption {
        double[][] expected = {{9,8,7},{3,2,1},{5.5,5,4}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z=10-{{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcScalarMulMatrix() throws CalcExeption {
        double[][] expected = {{10.0,20.0,30.0},{70.0,80.0,90.0},{45,50,60}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z=10*{{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcScalarWithBrackets() throws CalcExeption {
        double expected = 10;
        Parser parser = new Parser();
        parser.calc("C=40.15");
        Var calc = parser.calc("D=((C-0.15)-20)/(7-5)");
        double v = Double.parseDouble(calc.toString());
        assertEquals(expected,v,1e-8);
    }
}