package by.it.szamostyanin.Calc;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;
public class ParserTestMatrix {

    @Test
    public void checkSum() throws Exception {
        double[][] expected = {{6, 8}, {10, 12}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{2,4},{6,8}} + {{4,4},{4,4}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkSub() throws Exception {
        double[][] expected = {{3, 6}, {8, 12}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{6,9}, {11,15}} - 3");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkSub2() throws Exception {
        double[][] expected = {{1, 2}, {2, 2}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{2,4},{6,8}} - {{1,2},{4,6}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkMul() throws Exception {
        double[] expected = {16, 21};
        Parser parser = new Parser();
        Var varA = parser.calc("{{2,4},{3,5}} * {2,3}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMul2() throws Exception {
        double[][] expected = {{2, 2}, {2, 2}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{1,1},{1,1}}*{{1,1},{1,1}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }


    @Test
    public void checkDiv() throws Exception {
        double[][] expected = {{2, 3}, {4, 5}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{4,6}, {8,10}} / 2");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }
}
