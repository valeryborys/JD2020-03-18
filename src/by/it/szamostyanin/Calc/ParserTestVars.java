package by.it.szamostyanin.Calc;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;
public class ParserTestVars {

    @Test
    public void checkScalarFromDouble() {
        double expected = 15;
        Parser parser = new Parser();
        Var varA = new Scalar(15);
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorFromDouble() {
        double[] expected = {2, 2, 2};
        Parser parser = new Parser();
        Var varA = new Vector(new double[]{2, 2, 2});
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMatrixFromDouble() {
        double[][] expected = {{4, 4, 4}, {4, 4, 4}};
        Parser parser = new Parser();
        Var varA = new Matrix(new double[][]{{4, 4, 4}, {4, 4, 4}});
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkScalarFromScalar() {
        double expected = 35;
        Parser parser = new Parser();
        Var varA = new Scalar(35);
        Var varB = new Scalar((Scalar) varA);
        double actual = Double.parseDouble(varB.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorFromVector() {
        double[] expected = {5, 15, 25};
        Parser parser = new Parser();
        Var varA = new Vector("{5,15,25}");
        Var varB = new Vector((Vector) varA);
        double[] actual = ((Vector) varB).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMatrixFromMatrix() {
        double[][] expected = {{2, 4, 6}, {2, 4, 6}};
        Parser parser = new Parser();
        Var varA = new Matrix("{{2,4,6}, {2,4,6}}");
        Var varB = new Matrix((Matrix) varA);
        double[][] actual = ((Matrix) varB).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void checkScalarFromString() {
        double expected = 8;
        Parser parser = new Parser();
        Var varA = new Scalar("8");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkVectorFromString() {
        double[] expected = {3, 6, 9};
        Parser parser = new Parser();
        Var varA = new Vector("{3,6,9}");
        double[] actual = ((Vector) varA).getVector();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkMatrixFromString() {
        double[][] expected = {{1, 2, 3}, {1, 2, 3}};
        Parser parser = new Parser();
        Var varA = new Matrix("{{1,2,3}, {1,2,3}}");
        double[][] actual = ((Matrix) varA).getMatrix();
        assertTrue(Arrays.deepEquals(actual, expected));
    }
}