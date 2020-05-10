package by.it.szamostyanin.Calc;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ParserTestScalar {


    @Test
    public void checkSum() throws Exception {
        double expected = 6;
        Parser parser = new Parser();
        Var varA = parser.calc("3+3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkSum2() throws Exception {
        double[] expected = {3, 4};
        Parser parser = new Parser();
        Var varA = parser.calc("1+{2,3}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkSum3() throws Exception {
        double[][] expected = {{6, 9}, {5, 7}};
        Parser parser = new Parser();
        Var varA = parser.calc("3+{{3,6},{2,4}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkSub() throws Exception {
        double expected = 8;
        Parser parser = new Parser();
        Var varA = parser.calc("10-2");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkSub1() throws Exception {
        double[] expected = {4, 4};
        Parser parser = new Parser();
        Var varA = parser.calc("8-{4,4}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkSub3() throws Exception {
        double[][] expected = {{7, 5}, {3, 1}};
        Parser parser = new Parser();
        Var varA = parser.calc("9-{{2,4},{6,8}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkMul() throws Exception {
        double expected = 4;
        Parser parser = new Parser();
        Var varA = parser.calc("2*2");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMul2() throws Exception {
        double[] expected = {4, 6};
        Parser parser = new Parser();
        Var varA = parser.calc("2*{2,3}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMul3() throws Exception {
        double[][] expected = {{4, 8}, {12, 16}};
        Parser parser = new Parser();
        Var varA = parser.calc("2*{{2,4},{6,8}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkDiv() throws Exception {
        double expected = 1;
        Parser parser = new Parser();
        Var varA = parser.calc("5/5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }
}
