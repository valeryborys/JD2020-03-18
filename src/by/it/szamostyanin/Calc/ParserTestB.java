package by.it.szamostyanin.Calc;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTestB {

    @Test
    public void checkC() throws Exception {
        double expected = 40.15;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        Var varB = parser.calc("B=A*3.5");
        Var varC = parser.calc("B+(A*2)");
        double actual = Double.parseDouble(varC.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkD() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        Var varB = parser.calc("B=A*3.5");
        Var varC = parser.calc("C=B+(A*2)");
        Var varD = parser.calc("((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(varD.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkE() throws Exception {
        double[] expected = {10, 15};
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        Var varB = parser.calc("B=A*3.5");
        Var varC = parser.calc("C=B+(A*2)");
        Var varD = parser.calc("D=((C-0.15)-20)/(7-5)");
        Var varE = parser.calc("{2,3}*(D/2)");
        double[] actual = ((Vector) varE).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }
}
