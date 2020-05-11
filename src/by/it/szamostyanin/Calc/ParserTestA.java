package by.it.szamostyanin.Calc;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTestA {

    @Test
    public void checkA() throws Exception {
        double expectedA = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double resultA = Double.parseDouble(varA.toString());   //напряму проверять toString не корректно
        assertEquals(expectedA, resultA, 1e-8);   //дельта обязательна из-за округления на разных процессорах
    }

    @Test
    public void checkB() throws Exception {
        double expectedB = 25.55;
        Parser parser = new Parser();
        Var varB = parser.calc("B=A*3.5");
        double resultB = Double.parseDouble(varB.toString());
        assertEquals(expectedB, resultB, 1e-8);
    }

    @Test
    public void checkB1() throws Exception {
        double expectedB1 = 25;
        Parser parser = new Parser();
        Var varB1 = parser.calc("B1=B+0.11*-5");
        double resultB1 = Double.parseDouble(varB1.toString());
        assertEquals(expectedB1, resultB1, 1e-8);
    }

    @Test
    public void checkB2() throws Exception {
        double expectedB2 = 2.65;
        Parser parser = new Parser();
        Var varB2 = parser.calc("B2=A/2-1");
        double resultB2 = Double.parseDouble(varB2.toString());
        assertEquals(expectedB2, resultB2, 1e-8);
    }
}