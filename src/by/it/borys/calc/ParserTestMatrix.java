package by.it.borys.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ParserTestMatrix {
    @Test
    public void createAndPrintMatrix() throws CalcExeption {
        double[][] expected = {{1, 2, 3}, {7, 8, 9}, {4.3, 5.1, 6}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.3,5.1, 6.0}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcAddMatrix() throws CalcExeption {
        double[][] expected = {{2, 4, 6}, {8, 9, 10}, {5.3, 6.1, 7}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.3,5.1, 6.0}}+{{1,2,3},{1,1,1},{1,1,1}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcSubMatrix() throws CalcExeption {
        double[][] expected = {{0, 0, 0}, {6, 7, 8}, {3.3, 4.1, 5}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.3,5.1, 6.0}}-{{1,2,3},{1,1,1},{1,1,1}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcMulMatrix() throws CalcExeption {
        double[][] expected = {{6.0,7.0,8.0},{24.0,31.0,38.0},{15.6,20.1,24.6}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5.1, 6.0}}*{{1,2,3},{1,1,1},{1,1,1}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcMatrixAddScalar() throws CalcExeption {
        double[][] expected = {{4.0,5.0,6.0},{10.0,11.0,12.0},{7.5,8.1,9}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5.1, 6.0}}+3");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcMatrixSubScalar() throws CalcExeption {
        double[][] expected = {{-2,-1,0},{4.0,5.0,6.0},{1.5,2,3}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}-3");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcMatrixMulScalar() throws CalcExeption {
        double[][] expected = {{3.0,6.0,9.0},{21.0,24.0,27.0},{13.5,15,18}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}*3");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcMatrixDivScalar() throws CalcExeption {
        double[][] expected = {{0.5,1.0,1.5},{3.5,4,4.5},{2.25,2.5,3}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}/2");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test
    public void checkCalcMatrixMulVector() throws CalcExeption {
        double[] expected = {50,45};
        Parser parser = new Parser();
        Var calc = parser.calc("{{1,2,3,4},{1,2,2,4}}*{5,5,5,5}");
        double[] v = ((Vector) calc).getValue();
        assertArrayEquals(expected,v,1e-8);
    }
}