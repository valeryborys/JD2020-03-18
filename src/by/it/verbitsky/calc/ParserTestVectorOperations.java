package by.it.verbitsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTestVectorOperations {
    CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ParserTestVectorOperations.class, CalcFiles.LOG_FILENAME));


    //check add operation

    @Test
    public void checkCalcSumVectorAndVector() throws Exception {
        System.out.println("Test sum: {1,2} + {3,4}");
        double[] expected = {4, 6};
        Parser parser = new Parser();
        Var varA = parser.calc("{1,2} + {3,4}", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    //Check sub operation
    @Test
    public void checkCalcSubVectorAndScalar() throws Exception {
        System.out.println("Test sub: {20,10} - 5");
        double[] expected = {15, 5};
        Parser parser = new Parser();
        Var varA = parser.calc("{20,10}-5", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCalcSubVectorAndVector() throws Exception {
        System.out.println("Test sub: {1,2} - {3,4}");
        double[] expected = {-2, -2};
        Parser parser = new Parser();
        Var varA = parser.calc("{1,2}-{3,4}", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    //Check mul operation
    @Test
    public void checkCalcMulScalarAndVector() throws Exception {
        System.out.println("Test mul: {3,2} * {2,4}");
        double expected = 14;
        Parser parser = new Parser();
        Var varA = parser.calc("{3,2}*{2,4}", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
        System.out.println();
    }

    //Check div operation
    @Test
    public void checkCalcDivVectorAndScalar() throws Exception {
        System.out.println("Test div: {2,4} / 2 ");
        double[] expected = {1, 2};
        Parser parser = new Parser();
        Var varA = parser.calc("{2,4}/2", logger);
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

}
