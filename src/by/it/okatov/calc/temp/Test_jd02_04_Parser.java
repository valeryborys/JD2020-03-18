package by.it.okatov.calc.temp;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test_jd02_04_Parser {

    //Да, тут в названии метода прямое нарушение code-style, но метод
    //checkScalarsPlainExpression - ОБЯЗАТЕЛЬНО должен выполниться раньше,
    //чем метод checkScalarsMemorizableExpression()
    @Test(timeout = 1500)
    public void Test1_1_checkScalarsExpression() throws CalcException {
        //A = 2 + 5.3 | A = 7.3
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());

        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test1_1_checkScalarsExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test1_2_checkScalarsExpression() throws CalcException {
        //B = A * 3.5 | A = 7.3 B = 25.55
        double expected = 25.55;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test1_2_checkScalarsExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test1_3_checkScalarsExpression() throws CalcException {
        //B1 = B + 0.11 * -5 | B = A * 3.5 | A = 7.3 B = 25.55 B1 = 25
        double expected = 25;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        parser.calc("B = 25.55");
        Var varB1 = parser.calc("B1 = B + 0.11 * -5");
        double actual = Double.parseDouble(varB1.toString());
        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test1_3_checkScalarsExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test1_4_checkScalarsExpression() throws CalcException {
        //B2 = A/2-1 | A = 7.3 B2 = 2.65
        double expected = 2.65;
        Parser parser = new Parser();
        parser.calc("A = 7.3");
        Var varB2 = parser.calc("B2 = A/2-1");
        double actual = Double.parseDouble(varB2.toString());
        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test1_4_checkScalarsExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }


    @Test(timeout = 1500)
    public void Test1_5_checkVectorsExpression() throws CalcException {
        //VectorA = {1,2,3} + {1,2,3}
        double[] expected = {2, 4, 6};
        Parser parser = new Parser();
        Var vect = parser.calc("VA = {1,2,3} + {1,2,3}");
        double[] actual = ((Vector) vect).getValue();
        assertArrayEquals(expected, actual, 1e-8);
        Vector vExpected = new Vector(expected);
        Vector vActual = new Vector(actual);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%s%n  Полученное:%s%n%n",
                "Test1_5_checkVectorsExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test1_6_checkVectorsExpression() throws CalcException {
        //VectorB = VectorA + {1,2,3}/2-0.11 | VectorA = {2,4,6} VectorB = {1.39,2.89,4.39}
        double[] expected = {2.39, 4.89, 7.39};
        Parser parser = new Parser();
        parser.calc("VA = {2,4,6}");
        Var vect = parser.calc("VB = VA + {1,2,3}/2-0.11");
        double[] actual = ((Vector) vect).getValue();
        assertArrayEquals(expected, actual, 1e-8);
        Vector vExpected = new Vector(expected);
        Vector vActual = new Vector(actual);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%s%n  Полученное:%s%n%n",
                "Test1_6_checkVectorsExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test2_1_checkScalarsBracesExpression() throws CalcException {
        //X = 1+2*(3+4/2-(1+2))*2+1 | X = 10
        double expected = 10.0;
        Parser parser = new Parser();
        Var varX = parser.calc("X = 1+2*(3+4/2-(1+2))*2+1");
        double actual = Double.parseDouble(varX.toString());
        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test2_1_checkScalarsBracesExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test2_2_checkScalarsBracesExpression() throws CalcException {
        //C = B + (A*2) | A = 7.3 B = 25.55 | C = 58.4
        double expected = 40.15;
        Parser parser = new Parser();
        Var varC = parser.calc("C = B + (A*2)");
        double actual = Double.parseDouble(varC.toString());
        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test2_2_checkScalarsBracesExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test2_3_checkScalarsBracesExpression() throws CalcException {
        //D = ((C - 0.15) - 20)/(7 - 5) | C = 58.4
        double expected = 10;
        Parser parser = new Parser();
        Var varC = parser.calc("D = ((C - 0.15) - 20)/(7 - 5)");
        double actual = Double.parseDouble(varC.toString());
        assertEquals(expected, actual, 1e-8);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%f%n  Полученное:%f%n%n",
                "Test2_3_checkScalarsBracesExpression()",
                expected,
                actual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test2_4_checkVectorsBracesExpression() throws CalcException {
        //E = {2,3} * (D/2) | D = {10,15}
        double[] expected = {10, 15};
        Parser parser = new Parser();
        //parser.calc("VA = {2,4,6}");
        Var vect = parser.calc("E = {2,3} * (D/2)");
        double[] actual = ((Vector) vect).getValue();
        assertArrayEquals(expected, actual, 1e-8);
        Vector vExpected = new Vector(expected);
        Vector vActual = new Vector(actual);
        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое:%s%n  Полученное:%s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_1_checkMatrixAddScalar() throws CalcException {
        //MatrixA = {{1,2,3},{3,2,1}} + 8 | MatrixA = {{9,10,11},{11,10,9}}
        double[][] expected = {{9, 10, 11}, {11, 10, 9}};
        Parser parser = new Parser();
        Var matrix = parser.calc("MatrixA = {{1,2,3},{3,2,1}} + 8");
        double[][] actual = ((Matrix) matrix).getValue();
        Object[] oEx = new Object[]{expected};
        Object[] oAc = new Object[]{actual};
        assertArrayEquals(oEx, oAc);
        Matrix vExpected = new Matrix(expected);
        Matrix vActual = new Matrix(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное: %s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_2_checkMatrixAddMatrix() throws CalcException {
        //MatrixB = MatrixA + {{2,2,2},{3,2,2} | MatrixA = {{9,10,11},{11,10,9}}
        //MatrixB = {{11,12,13},{14,12,11}}
        double[][] expected = {{11, 12, 13}, {14, 12, 11}};
        Parser parser = new Parser();
        parser.calc("MatrixA = {{9,10,11},{11,10,9}}");
        Var matrix = parser.calc("MatrixB = MatrixA + {{2,2,2},{3,2,2}}");
        double[][] actual = ((Matrix) matrix).getValue();
        Object[] oEx = new Object[]{expected};
        Object[] oAc = new Object[]{actual};
        assertArrayEquals(oEx, oAc);
        Matrix vExpected = new Matrix(expected);
        Matrix vActual = new Matrix(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное: %s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_3_checkMatrixSubScalar() throws CalcException {
        //MatrixC = MatrixB - 8 | MatrixB = {{11,12,13},{14,12,11}}
        //MatrixC = {{3,4,5},{6,4,3}}
        double[][] expected = {{3, 4, 5}, {6, 4, 3}};
        Parser parser = new Parser();
        parser.calc("MatrixB = {{11,12,13},{14,12,11}}");
        Var matrix = parser.calc("MatrixC = MatrixB - 8");
        double[][] actual = ((Matrix) matrix).getValue();

        System.out.println("\nassertTrue(Arrays.deepEquals(expected,actual))");
        assertTrue(Arrays.deepEquals(expected, actual));


        System.out.println("\nassertArrayEquals(Object[] expected,Object[] actual)");
        Object[] oEx = new Object[]{expected};
        Object[] oAc = new Object[]{actual};
        assertArrayEquals(oEx, oAc);


        Matrix vExpected = new Matrix(expected);
        Matrix vActual = new Matrix(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное: %s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_4_checkMatrixSubMatrix() throws CalcException {
        //MatrixD = MatrixC - MatrixA | MatrixA = {{9,10,11},{11,10,9}} | MatrixC = {{3,4,5},{6,4,3}}
        //MatrixB = {{-6,-6,-6},{-5,-6,-6}}
        double[][] expected = {{-6, -6, -6}, {-5, -6, -6}};
        Parser parser = new Parser();
        parser.calc("MatrixA = {{9,10,11},{11,10,9}}");
        parser.calc("MatrixC = {{3,4,5},{6,4,3}}");
        Var matrix = parser.calc("MatrixD = MatrixC - MatrixA");

        double[][] actual = ((Matrix) matrix).getValue();
        Object[] oEx = new Object[]{expected};
        Object[] oAc = new Object[]{actual};
        assertArrayEquals(oEx, oAc);
        Matrix vExpected = new Matrix(expected);
        Matrix vActual = new Matrix(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное:%s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_5_checkMatrixMulScalar() throws CalcException {
        //MatrixE = (MatrixA*-1) + (MatrixC*8)| MatrixA = {{9,10,11},{11,10,9}} | MatrixC = {{3,4,5},{6,4,3}}
        //MatrixC = {{15,22,29},{37,22,15}}
        double[][] expected = {{15, 22, 29}, {37, 22, 15}};
        Parser parser = new Parser();
        parser.calc("MatrixA = {{9,10,11},{11,10,9}}");
        parser.calc("MatrixC = {{3,4,5},{6,4,3}}");
        Var matrix = parser.calc("MatrixE = (MatrixA*-1) + (MatrixC*8)");
        double[][] actual = ((Matrix) matrix).getValue();

        System.out.println("\nassertTrue(Arrays.deepEquals(expected,actual))");
        assertTrue(Arrays.deepEquals(expected, actual));


        System.out.println("\nassertArrayEquals(Object[] expected,Object[] actual)");
        Object[] oEx = new Object[]{expected};
        Object[] oAc = new Object[]{actual};
        assertArrayEquals(oEx, oAc);


        Matrix vExpected = new Matrix(expected);
        Matrix vActual = new Matrix(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное:%s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_6_checkMatrixMulMatrix() throws CalcException {
        //MatrixF = (MatrixA*-1) * (MatrixF1*8)| MatrixA = {{9,10,11},{11,10,9}} | MatrixF1 = {{3,4},{5,6},{7,8}}
        //MatrixA = {{-9,-10,-11},{-11,-10,-9}} | MatrixF1 = {{24,32},{40,48},{56,64}}}
        //MatrixF = {{-1232,-1472},{-1168,-1408}}}
        double[][] expected = {{-1232, -1472}, {-1168, -1408}};
        Parser parser = new Parser();
        parser.calc("MatrixA = {{9,10,11},{11,10,9}}");
        parser.calc("MatrixF1 = {{3,4},{5,6},{7,8}}");
        Var matrix = parser.calc("MatrixE = (MatrixA*-1) * (MatrixF1*8)");
        double[][] actual = ((Matrix) matrix).getValue();

        System.out.println("\nassertTrue(Arrays.deepEquals(expected,actual))");
        assertTrue(Arrays.deepEquals(expected, actual));


        System.out.println("\nassertArrayEquals(Object[] expected,Object[] actual)");
        Object[] oEx = new Object[]{expected};
        Object[] oAc = new Object[]{actual};
        assertArrayEquals(oEx, oAc);


        Matrix vExpected = new Matrix(expected);
        Matrix vActual = new Matrix(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное:%s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500)
    public void Test3_7_checkMatrixMulVector() throws CalcException {
        //VectorG = MatrixF * (VectorD*-1) | MatrixF = {{-1232,-1472},{-1168,-1408}} | VectorD = {10,15}
        //VectorG = {29840,35840}
        double[] expected = {34400, 32800};
        Parser parser = new Parser();
        parser.calc("MatrixF = {{-1232,-1472},{-1168,-1408}}");
        parser.calc("VectorD = {10,15}");
        Var vector = parser.calc("VectorG = MatrixF * (VectorD*-1) ");
        double[] actual = ((Vector) vector).getValue();

        System.out.println("\nassertArrayEquals(Object[] expected,Object[] actual)");
        assertArrayEquals(expected, actual, 1e-8);

        Vector vExpected = new Vector(expected);
        Vector vActual = new Vector(actual);

        String message = String.format(
                "%s%nТест пройден успешно. Значения:%n  Ожидаемое: %s%n  Полученное:%s%n%n",
                "Test2_4_checkVectorsBracesExpression()",
                vExpected,
                vActual
        );
        System.out.println(message);
    }

    @Test(timeout = 1500, expected = CalcException.class)
    public void Test3_8_checkMatrixDivision() throws CalcException {
        Var A;
        Var B;
        Var calc;
        Parser parser = new Parser();

        calc = parser.calc("A = {{1,2,3},{3,2,1},{2,3,1}}");
        A = new Matrix(((Matrix) calc).getValue());

        //-------------------------------Matrix/Scalar-------------------------------
        calc = parser.calc("B = 5");
        B = new Scalar(((Scalar) calc).getValue());
        calc = parser.calc("A/B");

        //-------------------------------Matrix/Vector-------------------------------
        calc = parser.calc("C = {5,2,3}");
        B = new Scalar(((Scalar) calc).getValue());
        calc = parser.calc("A/B");
        //-------------------------------Matrix/Matrix-------------------------------
        calc = parser.calc("D = {{1,2,3},{4,5,6},{7,8,9}}");
        B = new Scalar(((Scalar) calc).getValue());
        calc = parser.calc("A/B");
    }

    @Test(timeout = 1500)
    public void Test4_1_checkVariables() {

    }
}