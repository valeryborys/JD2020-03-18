package by.it.verbitsky.calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTestTaskA {
    CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ParserTestTaskA.class, CalcFiles.LOG_FILENAME));
    static Var varA;
    static Var varB;
    static Var varB1;
    static Var varB2;

    @Test
    public void checkCalcA1() throws Exception {
        System.out.println("Test A1");
        double expected = 7.3;
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcA2() throws Exception {
        System.out.println("Test A2");
        double expected = 25.55;
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        varB = parser.calc("B=A*3.5", logger);
        System.out.println("VarA = " + varA + " VarB = " + varB);
        double actual = Double.parseDouble(varB.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcA3() throws Exception {
        System.out.println("Test A3");
        double expected = 25;
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        varB = parser.calc("B=A*3.5", logger);
        varB1 = parser.calc("B+0.11*-5", logger);
        System.out.println("VarA = " + varA + " VarB = " + varB + " varB1 = " + varB1);
        double actual = Double.parseDouble(varB1.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcA4() throws Exception {
        System.out.println("Test A4");
        double expected = 2.65;
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        varB = parser.calc("B=A*3.5", logger);
        varB1 = parser.calc("B+0.11*-5", logger);
        varB2 = parser.calc("B2=A/2-1", logger);
        System.out.println("VarA = " + varA + " VarB = " + varB + " varB1 = " + varB1 + " varB2 = " + varB2);
        double actual = Double.parseDouble(varB2.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }
}
