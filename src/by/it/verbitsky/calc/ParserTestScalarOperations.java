package by.it.verbitsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTestScalarOperations {
    CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ParserTestScalarOperations.class, CalcFiles.LOG_FILENAME));


    //check add operation
    @Test
    public void checkCalcSumScalarAndScalar() throws Exception {
        System.out.println("Test sum: 2 + 3");
        double expected = 5;
        Parser parser = new Parser();
        Var varA = parser.calc("2+3", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcSumScalarAndVector() throws Exception {
        System.out.println("Test sum: 2 + {1,2}");
        double[] expected = {3, 4};
        Parser parser = new Parser();
        Var varA = parser.calc("2+{1,2}", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcSumScalarAndMatrix() throws Exception {
        System.out.println("Test sum: 1 + {{2,3},{4,5}}");
        double[][] expected = {{3, 4}, {5, 6}};
        Parser parser = new Parser();
        Var varA = parser.calc("1+{{2,3},{4,5}}", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    //Check sub operation
    @Test
    public void checkCalcSubScalarAndScalar() throws Exception {
        System.out.println("Test sub: 5 - 4");
        double expected = 1;
        Parser parser = new Parser();
        Var varA = parser.calc("5-4", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcSubScalarAndVector() throws Exception {
        System.out.println("Test sub: 10 - {20,20}");
        double[] expected = {-10, -10};
        Parser parser = new Parser();
        Var varA = parser.calc("10-{20,20}", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcSubScalarAndMatrix() throws Exception {
        System.out.println("Test sub: 10 - {{2,3},{4,5}}");
        double[][] expected = {{8, 7}, {6, 5}};
        Parser parser = new Parser();
        Var varA = parser.calc("10-{{2,3},{4,5}}", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    //Check mul operation
    @Test
    public void checkCalcMul() throws Exception {
        System.out.println("Test mul: 5 * 4");
        double expected = 20;
        Parser parser = new Parser();
        Var varA = parser.calc("5*4", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcMulScalarAndVector() throws Exception {
        System.out.println("Test mul: 3 * {2,4}");
        double[] expected = {6, 12};
        Parser parser = new Parser();
        Var varA = parser.calc("3*{2,4}", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcMulScalarAndMatrix() throws Exception {
        System.out.println("Test mul: 2 * {{2,3},{4,5}}");
        double[][] expected = {{4, 6}, {8, 10}};
        Parser parser = new Parser();
        Var varA = parser.calc("2*{{2,3},{4,5}}", logger);
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    //Check div operation
    @Test
    public void checkCalcDivScalarAndScalar() throws Exception {
        System.out.println("Test div: 20/4 ");
        double expected = 5;
        Parser parser = new Parser();
        Var varA = parser.calc("20/4", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcDivScalarByZero() {
        System.out.println("Test scalar div by zero");
        Parser parser = new Parser();
        Class<CalcException> errorClass = CalcException.class;
        try {
            parser.calc("20/0", logger);
            fail("Exception not thrown");
        } catch (CalcException e) {
            System.out.println("Passed. Class of error was thrown: " + e.getClass());
            assertEquals(e.getClass(), errorClass);
        }
        System.out.println();
    }
}
