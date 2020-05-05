package by.it.verbitsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTestCreateVars {
    static Var varA;
    static Var varB;

    //Scalar
    @Test
    public void checkCreateScalarFromDouble() {
        System.out.println("Test Create Scalar from double value");
        double expected = 10;
        Parser parser = new Parser();
        varA = new Scalar(10);
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCreateScalarFromString() {
        System.out.println("Test Create Scalar from string value");
        double expected = 15;
        Parser parser = new Parser();
        varA = new Scalar("15");
        double actual = Double.parseDouble(varA.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkCreateScalarFromScalar() {
        System.out.println("Test Create Scalar from double value");
        double expected = 20;
        Parser parser = new Parser();
        varA = new Scalar(20);
        varB = new Scalar((Scalar) varA);
        double actual = Double.parseDouble(varB.toString());
        System.out.println("actual = " + actual + " expected = " + expected);
        assertEquals(expected, actual, 1e-8);
    }

    //Vector
    @Test
    public void checkCreateVectorFromDouble() {
        System.out.println("Test Create Scalar from double value");
        double[] expected = {1, 2, 3};
        Parser parser = new Parser();
        varA = new Vector(new double[]{1, 2, 3});
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCreateVectorFromString() {
        System.out.println("Test Create Scalar from double value");
        double[] expected = {10, 15, 20};
        Parser parser = new Parser();
        varA = new Vector("{10,15,20}");
        double[] actual = ((Vector) varA).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    @Test
    public void checkCreateVectorFromVector() {
        System.out.println("Test Create Scalar from double value");
        double[] expected = {13, 35, 49};
        Parser parser = new Parser();
        varA = new Vector("{13,35,49}");
        varB = new Vector((Vector) varA);
        double[] actual = ((Vector) varB).getVector();
        System.out.println("actual = " + Arrays.toString(actual) + " expected = " + Arrays.toString(expected));
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println();
    }

    //Matrix
    @Test
    public void checkCreateMatrixFromDouble() {
        System.out.println("Test Create Scalar from double value");
        double[][] expected = {{4, 5, 6}, {1, 2, 3}};
        Parser parser = new Parser();
        varA = new Matrix(new double[][]{{4, 5, 6}, {1, 2, 3}});
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    @Test
    public void checkCreateMatrixFromString() {
        System.out.println("Test Create Scalar from double value");
        double[][] expected = {{11, 32, 43}, {2, 4, 7}};
        Parser parser = new Parser();
        varA = new Matrix("{{11,32,43}, {2,4,7}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }

    @Test
    public void checkCreateMatrixFromMatrix() {
        System.out.println("Test Create Scalar from double value");
        double[][] expected = {{1, 2, 3}, {4, 5, 6}};
        Parser parser = new Parser();
        varA = new Matrix("{{1,2,3}, {4,5,6}}");
        varB = new Matrix((Matrix) varA);
        double[][] actual = ((Matrix) varB).getMatrix();
        System.out.println("actual = " + Arrays.deepToString(actual) + " expected = " + Arrays.deepToString(expected));
        assertTrue(Arrays.deepEquals(actual, expected));
        System.out.println();
    }


}