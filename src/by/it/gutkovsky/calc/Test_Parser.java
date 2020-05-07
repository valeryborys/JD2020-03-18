package by.it.gutkovsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test_Parser {

    // check Scalars

    @Test
    public void checkCalcWithScalars() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkNextCalcWithScalars() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcNextB1WithScalars() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        parser.calc("B = 25.55");
        Var varB1 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(varB1.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcNextB2WithScalars() throws Exception {
        //B2=A/2-1 (выведет на экран 2.65)
        double expected = 2.65;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB2 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(varB2.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcScalarsWithScalarsDiv() throws Exception {
        //B3=A/2 (выведет на экран 2.65)
        double expected = 3.65;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB2 = parser.calc("B2=A/2");
        double actual = Double.parseDouble(varB2.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcWithScalarSubVector() throws Exception {
        double[] expected = {-1.0, -4.0, -7.0};
        Parser parser = new Parser();
        Var varV8 = parser.calc("V = 2 - {3,6,9}");
        double[] actual = ((Vector) varV8).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    // TaskB
    @Test
    public void checkCalcScalarAndScalarInBrackets() throws Exception {
        //C=B+(A*2) (выведет на экран 40,15)
        double expected = 40.15;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        parser.calc("B = 25.55");
        Var varC = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(varC.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcNextScalarAndScalarInBrackets() throws Exception {
        //D=((C-0.15)-20)/(7-5) (выведет на экран 10)
        double expected = 10.0;
        Parser parser = new Parser();
        parser.calc("C = 40.15");
        Var varD = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(varD.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcVectorAndScalarInBrackets() throws Exception {
        //E={2,3}*(D/2) - result {10,15}
        double[] expected = {10.0, 15.0};
        Parser parser = new Parser();
        parser.calc("D=10");
        Var varE = parser.calc("E={2,3}*(D/2)");
        double[] actual = ((Vector) varE).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcMatrixAndScalarInBrackets() throws Exception {
        //F={{1,2,3},{4,5,6}}*(D/2) - result {10,15}
        double[][] expected = {{5.0, 10.0, 15.0}, {20.0, 25.0, 30.0}};
        Parser parser = new Parser();
        parser.calc("D=10");
        Var varF = parser.calc("F={{1,2,3},{4,5,6}}*(D/2)");
        double[][] actual = ((Matrix) varF).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    // check Vectors

    // 1) Vector with Vector
    @Test
    public void checkCalcWithVectorsAddVector() throws Exception {
        double[] expected = {4, 6, 8};
        Parser parser = new Parser();
        Var varV1 = parser.calc("V={1,2,3}+{1,2,3}+2");
        double[] actual = ((Vector) varV1).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcWithVectorsSubVector() throws Exception {
        double[] expected = {1, 3, 5};
        Parser parser = new Parser();
        Var varV2 = parser.calc("V={3,6,9}-{1,2,3}-1");
        double[] actual = ((Vector) varV2).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcWithVectorsMulVector() throws Exception {
        double expected = 84.0;
        Parser parser = new Parser();
        Var varV3 = parser.calc("V={3,6,9}*{1,2,3}*2");
        double actual = Double.parseDouble(varV3.toString());
        assertEquals(expected, actual, 1e-8);
    }

    // 2) Vector with Scalar

    @Test
    public void checkCalcWithVectorsAddScalar() throws Exception {
        double[] expected = {5.0, 8.0, 11.0};
        Parser parser = new Parser();
        Var varV4 = parser.calc("V = {3,6,9}+2");
        double[] actual = ((Vector) varV4).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcWithVectorsSubScalar() throws Exception {
        double[] expected = {1.0, 4.0, 7.0};
        Parser parser = new Parser();
        Var varV5 = parser.calc("V = {3,6,9}-2");
        double[] actual = ((Vector) varV5).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcWithVectorsMulScalar() throws Exception {
        double[] expected = {6.0, 12.0, 18.0};
        Parser parser = new Parser();
        Var varV6 = parser.calc("V = {3,6,9}*2");
        double[] actual = ((Vector) varV6).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCalcWithVectorsDivScalar() throws Exception {
        double[] expected = {1.5, 3.0, 4.5};
        Parser parser = new Parser();
        Var varV7 = parser.calc("V = {3,6,9}/2");
        double[] actual = ((Vector) varV7).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    // check Matrix

    // 1) Matrix with Matrix
    @Test
    public void checkCalcWithMatrixAddMatrix() throws Exception {
        //Object matrix = c.newInstance(new Object[]{new double[][]{{1, 2}, {3, 4}}});
        double[][] expected = {{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}};
        Parser parser = new Parser();
        Var varM1 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} + {{1,2,3},{4,5,6},{7,8,9}}");
        double[][] actual = ((Matrix) varM1).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void checkCalcWithMatrixSubMatrix() throws Exception {
        double[][] expected = {{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}};
        Parser parser = new Parser();
        Var varM2 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} - {{1,2,3},{4,5,6},{7,8,9}}");
        double[][] actual = ((Matrix) varM2).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void checkCalcWithMatrixMulMatrix() throws Exception {
        double[][] expected = {{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}};
        Parser parser = new Parser();
        Var varM3 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} * {{1,2,3},{4,5,6},{7,8,9}}");
        double[][] actual = ((Matrix) varM3).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    //2 Matrix with Vector
    @Test
    public void checkCalcWithMatrixMulVector() throws Exception {
        double[] expected = {14.0, 32.0, 50.0};
        Parser parser = new Parser();
        Var varM4 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} * {1, 2, 3}");
        double[] actual = ((Vector) varM4).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }
    // Matrix with Scalar

    @Test
    public void checkCalcWithMatrixAddScalar() throws Exception {
        double[][] expected = {{0.0, 1.0, 2.0}, {3.0, 4.0, 5.0}, {6.0, 7.0, 8.0}};
        Parser parser = new Parser();
        Var varM5 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} +-1");
        double[][] actual = ((Matrix) varM5).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void checkCalcWithMatrixSubScalar() throws Exception {
        double[][] expected = {{2.0, 3.0, 4.0}, {5.0, 6.0, 7.0}, {8.0, 9.0, 10.0}};
        Parser parser = new Parser();
        Var varM6 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} - -1");
        double[][] actual = ((Matrix) varM6).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void checkCalcWithMatrixMulScalar() throws Exception {
        double[][] expected = {{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}, {-7.0, -8.0, -9.0}};
        Parser parser = new Parser();
        Var varM7 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} * -1");
        double[][] actual = ((Matrix) varM7).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }

    @Test
    public void checkCalcWithMatrixDivScalar() throws Exception {
        double[][] expected = {{-1.0, -2.0, -3.0}, {-4.0, -5.0, -6.0}, {-7.0, -8.0, -9.0}};
        Parser parser = new Parser();
        Var varM8 = parser.calc("W = {{1,2,3},{4,5,6},{7,8,9}} / -1");
        double[][] actual = ((Matrix) varM8).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
    }


}