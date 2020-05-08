package by.it.verbitsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTestTaskB {
    CalcLogger logger = new CalcLogger(CalcMemoryManager.getFullPath(ParserTestTaskB.class, CalcFiles.LOG_FILENAME));
    static Var varA;
    static Var varB;
    static Var varC;
    static Var varD;
    static Var varE;

    @Test
    public void checkCalcB1() throws Exception {
        System.out.println("Test B1");
        double expected = 40.15;
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        varB = parser.calc("B=A*3.5", logger);
        varC = parser.calc("B+(A*2)", logger);
        System.out.println("VarA = " + varA + " VarB = " + varB + " varC = " + varC);
        double actual = Double.parseDouble(varC.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcB2() throws Exception {
        System.out.println("Test B2");
        double expected = 10;
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        varB = parser.calc("B=A*3.5", logger);
        varC = parser.calc("C=B+(A*2)", logger);
        varD = parser.calc("((C-0.15)-20)/(7-5)", logger);
        System.out.println("VarA = " + varA + " VarB = " + varB + " varC = " + varC + " varD = " + varD);
        double actual = Double.parseDouble(varD.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcB3() throws Exception {
        System.out.println("Test B3");
        double[] expected = {10, 15};
        Parser parser = new Parser();
        varA = parser.calc("A=2+5.3", logger);
        varB = parser.calc("B=A*3.5", logger);
        varC = parser.calc("C=B+(A*2)", logger);
        varD = parser.calc("D=((C-0.15)-20)/(7-5)", logger);
        varE = parser.calc("{2,3}*(D/2)", logger);
        System.out.println("VarA = " + varA + " VarB = " + varB +
                " varC = " + varC + " varD = " + varD + " varE = " + varE);
        double[] actual = ((Vector) varE).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
    }


}
