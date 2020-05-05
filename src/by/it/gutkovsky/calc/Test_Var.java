package by.it.gutkovsky.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test_Var {

    @Test
    public void createVarScalar() throws Exception {
        double expected = 10;
        Var scalar = Var.createVar("10");
        double actual = ((Scalar) scalar).getValue();
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void createVarScalarCheckToString() throws Exception {
        String expected = "10.0";
        Var scalar = Var.createVar("10");
        String actual = scalar.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createVarVector() throws Exception {
        double[] expected = {1.0, 2.0, 3.0};
        Var vector = Var.createVar("{1,2,3}");
        double[] actual = ((Vector) vector).getValue();
        assertArrayEquals(expected, actual, 1e-8);
    }

    @Test
    public void createVarVectorCheckToString() throws Exception {
        String expected = "{1.0, 2.0, 3.0}";
        Var vector = Var.createVar("{1,2,3}");
        String actual = vector.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createVarMatrix1() throws Exception {
        double[][] expected = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        Var matrix = Var.createVar("{{1,2,3},{4,5,6}}");
        double[][] actual = ((Matrix) matrix).getValue();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void createVarMatrix1CheckToString() throws Exception {
        String expected = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}}";
        Var matrix = Var.createVar("{{1,2,3},{4,5,6}}");
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createVarMatrix2() throws Exception {
        double[][] expected = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Var matrix = Var.createVar("{{1,2,3},{4,5,6},{7,8,9}}");
        double[][] actual = ((Matrix) matrix).getValue();
        assertTrue(Arrays.deepEquals(actual, expected));
    }

    @Test
    public void createVarMatrix2CheckToString() throws Exception {
        String expected = "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}";
        Var matrix = Var.createVar("{{1,2,3},{4,5,6},{7,8,9}}");
        String actual = matrix.toString();
        assertEquals(expected, actual);
    }


}