package by.it.verbitsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTestMatrixOperations {
    CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ParserTestMatrixOperations.class, CalcFiles.LOG_FILENAME));


    //check add operation
    @Test
    public void checkCalcSumMatrixAndMatrix() throws Exception {
        System.out.println("Test sum: {{1,2},{1,2}} + {{3,4},{3,4}}");
        double[][] expected = {{4, 6}, {4, 6}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{1,2},{1,2}} + {{3,4},{3,4}}", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    //Check sub operation
    @Test
    public void checkCalcSubMatrixAndScalar() throws Exception {
        System.out.println("Test sub: {{20,10}, {15,5}} - 5");
        double[][] expected = {{15, 5}, {10, 0}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{20,10}, {15,5}} - 5", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    @Test
    public void checkCalcSubMatrixAndMatrix() throws Exception {
        System.out.println("Test sum: {{1,2},{1,2}} - {{3,4},{3,4}}");
        double[][] expected = {{-2, -2}, {-2, -2}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{1,2},{1,2}} - {{3,4},{3,4}}", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    //Check mul operation
    @Test
    public void checkCalcMulMatrixAndVector() throws Exception {
        System.out.println("Test mul: {{1,2},{3,4}} * {5,6}");
        double[] expected = {17, 39};
        Parser parser = new Parser();
        Var varA = parser.calc("{{1,2},{3,4}} * {5,6}", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcMulMatrixAndMatrix() throws Exception {
        System.out.println("Test mul: {{1,2},{1,2}} * {{2,2},{2,2}}");
        double[][] expected = {{6, 6}, {6, 6}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{1,2},{1,2}}*{{2,2},{2,2}}", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    //Check div operation
    @Test
    public void checkCalcDivMatrixAndScalar() throws Exception {
        System.out.println("Test div: {{2,4},{6,8}} / 2 ");
        double[][] expected = {{1, 2}, {3, 4}};
        Parser parser = new Parser();
        Var varA = parser.calc("{{2,4}, {6,8}} / 2", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }
}
