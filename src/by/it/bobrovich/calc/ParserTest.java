package by.it.bobrovich.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void calc() throws CalcException {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double value = Double.parseDouble(varA.toString());
        assertEquals(expected, value, 1e-8);
    }
}