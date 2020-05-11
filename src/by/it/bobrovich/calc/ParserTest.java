package by.it.bobrovich.calc;

import org.junit.Test;

import java.util.Arrays;

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
        Var varB = parser.calc("C=B+(A*2)");
        double value = Double.parseDouble(varB.toString());
        assertEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestB2() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        Var varB = parser.calc("D=((C-0.15)-20)/(7-5)");
        double value = Double.parseDouble(varB.toString());
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

    @Test
    public void calcTestMatrixScalar1() throws Exception {
        double[][] expected = {{3, 5}, {7, 9}};
        Parser parser = new Parser();
        Var varC = parser.calc("{{3,5},{7,9}}+5-5");
        double[][] value = ((Matrix) varC).getValue();
        assertTrue(Arrays.deepEquals(expected, value));
    }

    @Test
    public void calcTestMatrixScalar2() throws Exception {
        double[][] expected = {{15, 25}, {35, 45}};
        Parser parser = new Parser();
        Var varC = parser.calc("{{3,5},{7,9}}*5");
        double[][] value = ((Matrix) varC).getValue();
        assertTrue(Arrays.deepEquals(expected, value));
    }

    @Test
    public void calcTestMatrixVector() throws Exception {
        double[] expected = {66.0, 130.0};
        Parser parser = new Parser();
        Var varC = parser.calc("{{3,5},{7,9}}*{7,9}");
        double[] value = ((Vector) varC).getValue();
        assertArrayEquals(expected, value, 1e-8);
    }

    @Test
    public void calcTestMatrixMatrix1() throws Exception {
        double[][] expected = {{6, 10}, {14, 18}};
        Parser parser = new Parser();
        Var varC = parser.calc("{{3,5},{7,9}}+{{3,5},{7,9}}");
        double[][] value = ((Matrix) varC).getValue();
        assertTrue(Arrays.deepEquals(expected, value));
    }

    @Test
    public void calcTestMatrixMatrix2() throws Exception {
        double[][] expected = {{0, 0}, {0, 0}};
        Parser parser = new Parser();
        Var varC = parser.calc("{{3,5},{7,9}}-{{3,5},{7,9}}");
        double[][] value = ((Matrix) varC).getValue();
        assertTrue(Arrays.deepEquals(expected, value));
    }

    @Test
    public void calcTestMatrixMatrix3() throws Exception {
        double[][] expected = {{44, 60}, {84, 116}};
        Parser parser = new Parser();
        Var varC = parser.calc("{{3,5},{7,9}}*{{3,5},{7,9}}");
        double[][] value = ((Matrix) varC).getValue();
        assertTrue(Arrays.deepEquals(expected, value));
    }
}