package by.it.tolstik.calc;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class ParserTest {

    @Test(timeout = 5000)
    public void a1_createAndPrintScalar() throws CalcException {
        String expected = "322.0";
        Parser parser = new Parser();
        Var calc = parser.calc("A=322");
        String v = calc.toString();
        assertEquals(expected, v);

    }

    @Test(timeout = 5000)
    public void a1_checkCalcWithScalar1() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkCalcWithScalar2() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        Var varA = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkCalcWithScalar3() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        Var varA = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkCalcWithScalar4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        Var varA = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkAddScalarWithScalar() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        Var varA = parser.calc("5+5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkSubScalarWithScalar() throws Exception {
        double expected = 0;
        Parser parser = new Parser();
        Var varA = parser.calc("5-5");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkMulScalarWithScalar() throws Exception {
        double expected = 36;
        Parser parser = new Parser();
        Var varA = parser.calc("6*6");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a1_checkDivScalarWithScalar() throws Exception {
        double expected = 2;
        Parser parser = new Parser();
        Var varA = parser.calc("4/2");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    // Для векторов
    @Test(timeout = 5000)
    public void checkCalcScalarAndScalarInBrackets() throws Exception {
        double expected = 40.15;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        parser.calc("B = 25.55");
        Var varC = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(varC.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void checkCalcNextScalarAndScalarInBrackets() throws Exception {
        double expected = 10.0;
        Parser parser = new Parser();
        parser.calc("C = 40.15");
        Var varD = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(varD.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void checkCalcVectorAndScalarInBrackets() throws Exception {
        double[] expected = {10.0, 15.0};
        Parser parser = new Parser();
        parser.calc("D=10");
        Var varE = parser.calc("E={2,3}*(D/2)");
        double[] actual = ((Vector) varE).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcWithVector4() throws Exception {
        double[] expected = {2, 4, 6};
        Parser parser = new Parser();
        Var vector = parser.calc("{1,2,3}+{1,2,3}");
        double[] actual = ((Vector) vector).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    //для матриц
    @Test(timeout = 5000)
    public void a3_checkCalcWithMatrix1() throws Exception {
        double[][] expected = {{2.0, 4.0}, {2.0, 4.0}};
        Parser parser = new Parser();
        Var matrix = parser.calc("{{1,2},{1,2}}+{{1,2},{1,2}}");
        double[][] actual = ((Matrix) matrix).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test(timeout = 5000)
    public void a2_checkCalcScalarAddVector() throws Exception {
        double[] expected = {9, 10, 11};
        Parser parser = new Parser();
        Var calc = parser.calc("V=8+{1,2,3}");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcScalarSubVector() throws Exception {
        double[] expected = {-7.0, -6.0, -5.0};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}-8");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcScalarMulVector() throws Exception {
        double[] expected = {8, 16, 24};
        Parser parser = new Parser();
        Var calc = parser.calc("V=8*{1,2,3}");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a3_checkCalcScalarAddMatrix() throws Exception {
        double[][] expected = {{11.0, 12.0, 13.0}, {17.0, 18.0, 19.0}, {14.5, 15.1, 16}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z=10+{{1, 2,3}, {7 ,8.0 ,9},{4.5,5.1, 6.0}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }

    @Test(timeout = 5000)
    public void a3_checkCalcScalarSubMatrix() throws Exception {
        double[][] expected = {{-9.0, -8.0, -7.0}, {-3.0, -2.0, -1.0}, {-5.5, -5.0, -4.0}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}-10");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }

    @Test(timeout = 5000)
    public void a3_checkCalcScalarMulMatrix() throws Exception {
        double[][] expected = {{10.0, 20.0, 30.0}, {70.0, 80.0, 90.0}, {45, 50, 60}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z=10*{{1.0, 2.0, 3.0}, {7.0, 8.0, 9.0}, {4.5, 5.0, 6.0}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }

    @Test(timeout = 5000)
    public void a2_createAndPrintVector() throws CalcException {
        String expected = "{1.0, 2.0, 3.0}";
        Parser parser = new Parser();
        Var calc = parser.calc("{1,2,3}");
        String v = calc.toString();
        assertEquals(expected, v);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcAddVectors() throws CalcException {
        double[] expected = {2, 4, 6};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}+{1,2,3}");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcSubVectors() throws CalcException {
        double[] expected = {2, 4, 7};
        Parser parser = new Parser();
        Var calc = parser.calc("V={3,5,7}-{1,1,0}");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcMulVectors() throws CalcException {
        double expected = 34;
        Parser parser = new Parser();
        Var calc = parser.calc("{1,2,3}*{3,5,7}");
        double actual = ((Scalar) calc).getValue();
        assertEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcVectorAddScalar() throws CalcException {
        double[] expected = {51, 52, 53};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}+50");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcVectorSubScalar() throws CalcException {
        double[] expected = {-11, -10, -9};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}-12");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcVectorMulScalar() throws CalcException {
        double[] expected = {2, 4, 6};
        Parser parser = new Parser();
        Var calc = parser.calc("V={1,2,3}*2");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test(timeout = 5000)
    public void a2_checkCalcVectorDivScalar() throws CalcException {
        double[] expected = {4.5, 4.0, 3.5};
        Parser parser = new Parser();
        Var calc = parser.calc("V={9,8,7}/2");
        double[] actual = ((Vector) calc).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }
    @Test(timeout = 5000)
    public void a3_createAndPrintMatrix() throws CalcException {
        String expected = "{{1.0, 3.0}, {1.0, 3.0}, {1.0, 3.0}}";
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1,3},{1,3},{1,3}}");
        String v = calc.toString();
        assertEquals(expected, v);
    }
    @Test(timeout = 5000)
    public void a3_checkCalcAddMatrix() throws CalcException {
        double[][] expected = {{2.0, 6.0}, {2.0, 6.0}, {2.0, 6.0}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1,3},{1,3},{1,3}}+{{1,3},{1,3},{1,3}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcSubMatrix() throws CalcException {
        double[][] expected = {{2.0, 0.0}, {2.0, 0.0}, {2.0, 0.0}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{3,3},{3,3},{3,3}}-{{1,3},{1,3},{1,3}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcMulMatrix() throws CalcException {
        double[][] expected = {{7.0, 21.0, -4.0}, {6.0, 18.0, 7.0}, {9.0, 27.0, -26.0}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1,3,3},{1,3,2},{1,3,5}}*{{1,3,2},{1,3,9},{1,3,-11}}");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcMatrixAddScalar() throws CalcException {
        double[][] expected = {{4.0,5.0,6.0},{10.0,11.0,12.0},{7.5,8.1,9}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5.1, 6.0}}+3");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcMatrixSubScalar() throws CalcException {
        double[][] expected = {{-2,-1,0},{4.0,5.0,6.0},{1.5,2,3}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}-3");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcMatrixMulScalar() throws CalcException {
        double[][] expected = {{3.0,6.0,9.0},{21.0,24.0,27.0},{13.5,15,18}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}*3");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcMatrixDivScalar() throws CalcException {
        double[][] expected = {{0.5,1.0,1.5},{3.5,4,4.5},{2.25,2.5,3}};
        Parser parser = new Parser();
        Var calc = parser.calc("Z={{1, 2,3}, {7 ,8.0 ,9},{4.5,5, 6.0}}/2");
        double[][] v = ((Matrix) calc).getValue();
        assertTrue(Arrays.deepEquals(expected, v));
    }
    @Test(timeout = 5000)
    public void a3_checkCalcMatrixMulVector() throws CalcException {
        double[] expected = {50,45};
        Parser parser = new Parser();
        Var calc = parser.calc("{{1,2,3,4},{1,2,2,4}}*{5,5,5,5}");
        double[] v = ((Vector) calc).getValue();
        assertArrayEquals(expected,v,1e-8);
    }
}

