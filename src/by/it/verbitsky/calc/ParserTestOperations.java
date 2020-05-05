package by.it.verbitsky.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ParserTestOperations {
    CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ParserTestOperations.class, CalcFiles.LOG_FILENAME));

    @Test
    public void checkCalcSum() throws Exception {
        System.out.println("Test scalar sum");
        double expected = 5;
        Parser parser = new Parser();
        Var varA = parser.calc("2+3", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcSub() throws Exception {
        System.out.println("Test scalar sub");
        double expected = 1;
        Parser parser = new Parser();
        Var varA = parser.calc("5-4", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcMul() throws Exception {
        System.out.println("Test scalar mul");
        double expected = 20;
        Parser parser = new Parser();
        Var varA = parser.calc("5*4", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcDiv() throws Exception {
        System.out.println("Test scalar mul");
        double expected = 5;
        Parser parser = new Parser();
        Var varA = parser.calc("20/4", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcDivByZero() {
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
    }
}
