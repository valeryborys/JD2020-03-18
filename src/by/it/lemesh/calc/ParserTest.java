package by.it.lemesh.calc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkCalc_Test1() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var var1 = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(var1.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.printf("Тест_1 на скаляры ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    @Test
    public void checkCalc_Test2() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        Var var2 = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(var2.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.printf("Тест_2 на скаляры ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    @Test
    public void checkCalc_Test3() throws Exception {
        double expected = 25;
        Parser parser = new Parser();
        Var var3 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(var3.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.printf("Тест_3 на скаляры ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    @Test
    public void checkCalc_Test4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        Var var4 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(var4.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.printf("Тест_4 на скаляры ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    //****************************************************************

    @Test
    public void checkCalc_Test5() throws Exception {
        double expected = 40.15;
        Parser parser = new Parser();
        Var var5 = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(var5.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.printf("Тест_1 на приоритет операций ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    @Test
    public void checkCalc_Test6() throws Exception {
        double expected = 10;
        Parser parser = new Parser();
        Var var6 = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(var6.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.printf("Тест_2 на приоритет операций ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    @Test
    public void checkCalc_Test7() throws Exception {
        double[] expected = {10, 15};
        Parser parser = new Parser();
        Var var7 = parser.calc("E={2,3}*(D/2)");
        double[] actual = ((Vector) var7).getValue();
        assertArrayEquals(expected, actual, 1e-8);
        Var exp = new Vector(expected);
        Var act = new Vector(actual);
        System.out.printf("Тест_3 на приоритет операций ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

//********************************************************************

    @Test
    public void checkCalcWithMatrix_Test1() throws Exception {
        double[][] expected = {{6, 7, 8}, {9, 10, 11}};
        Parser parser = new Parser();
        Var matrix1 = parser.calc("A={{1,2,3},{4,5,6}}+5");
        double[][] actual = ((Matrix) matrix1).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
        Var exp = new Matrix(expected);
        Var act = new Matrix(actual);
        System.out.printf("Тест_1 на матрицы (матрица+скаляр) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    @Test
    public void checkCalcWithMatrix_Test2() throws Exception {
        double[][] expected = {{-16, -17, -18}, {-19, -20, -21}};
        Parser parser = new Parser();
        Var matrix2 = parser.calc("B=10-A");
        double[][] actual = ((Matrix) matrix2).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
        Var exp = new Matrix(expected);
        Var act = new Matrix(actual);
        System.out.printf("Тест_2 на матрицы (скаляр-матрица) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    @Test
    public void checkCalcWithMatrix_Test3() throws Exception {
        double[][] expected = {{48, 51, 54}, {57, 60, 63}};
        Parser parser = new Parser();
        Var matrix3 = parser.calc("C=B*-3");
        double[][] actual = ((Matrix) matrix3).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
        Var exp = new Matrix(expected);
        Var act = new Matrix(actual);
        System.out.printf("Тест_3 на матрицы (матрица*скаляр) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    @Test
    public void checkCalcWithMatrix_Test4() throws Exception {
        double[] expected = {59, 86};
        Parser parser = new Parser();
        Var matrix4 = parser.calc("D=A*{5,3,1}");
        double[] actual = ((Vector) matrix4).getValue();
        assertArrayEquals(expected, actual, 1e-8);
        Var exp = new Vector(expected);
        Var act = new Vector(actual);
        System.out.printf("Тест_4 на матрицы (матрица*вектор) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    @Test
    public void checkCalcWithMatrix_Test5() throws Exception {
        double[][] expected = {{-10, -10, -10}, {-10, -10, -10}};
        Parser parser = new Parser();
        Var matrix5 = parser.calc("C1=A+B");
        double[][] actual = ((Matrix) matrix5).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
        Var exp = new Matrix(expected);
        Var act = new Matrix(actual);
        System.out.printf("Тест_5 на матрицы (матрица+матрица) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    @Test
    public void checkCalcWithMatrix_Test6() throws Exception {
        double[][] expected = {{22, 24, 26}, {28, 30, 32}};
        Parser parser = new Parser();
        Var matrix6 = parser.calc("C2=A-B");
        double[][] actual = ((Matrix) matrix6).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
        Var exp = new Matrix(expected);
        Var act = new Matrix(actual);
        System.out.printf("Тест_6 на матрицы (матрица-матрица) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    @Test
    public void checkCalcWithMatrix_Test7() throws Exception {
        double[][] expected = {{57, 44, 31}, {84, 65, 46}};
        Parser parser = new Parser();
        Var matrix7 = parser.calc("E1=A*{{6,5,4},{3,2,1}}");
        double[][] actual = ((Matrix) matrix7).getValue();
        assertTrue(Arrays.deepEquals(expected, actual));
        Var exp = new Matrix(expected);
        Var act = new Matrix(actual);
        System.out.printf("Тест_7 на матрицы (матрица*матрицу) ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", exp, act);
    }

    //********************************************************************

    @Test
    public void checkScalarToString() throws Exception {
        double scalar = 55.0;
        String expected = Double.toString(scalar);
        String actual = new Scalar(scalar).toString();
        assertEquals(expected, actual);
        System.out.printf("Тест ScalarToString ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }

    @Test
    public void checkVectorToString() throws Exception {
        double[] vector = {1, 3, 5, 11};
        String expected = "{1.0, 3.0, 5.0, 11.0}";
        String actual = new Vector(vector).toString();
        assertEquals(expected, actual);
        System.out.printf("Тест VectorToString ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);

    }

    @Test
    public void checkMatrixToString() throws Exception {
        double[][] matrix = {{7, 8, 9}, {-1, 4, -6}};
        String expected = "{{7.0, 8.0, 9.0}, {-1.0, 4.0, -6.0}}";
        String actual = new Matrix(matrix).toString();
        assertEquals(expected, actual);
        System.out.printf("Тест MatrixToString ...\nОжидаемое значение:  %s\nПолученное значение: %s\nТест пройден успешно!\n\n", expected, actual);
    }
}