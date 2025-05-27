import org.junit.Test;
import org.example.Calculator;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {

    @Test
    public void testConvertRechenoperationPlus() {
        String result = Calculator.ConvertRechenoperation(Calculator.Rechenoperation.ADDITION);
        assertEquals("+", result);
    }

    @Test
    public void testConvertRechenoperationMinus() {
        String result = Calculator.ConvertRechenoperation(Calculator.Rechenoperation.SUBTRAKTION);
        assertEquals("-", result);
    }

    @Test
    public void testConvertRechenoperationMultipy() {
        String result = Calculator.ConvertRechenoperation(Calculator.Rechenoperation.MULTIPLIKATION);
        assertEquals("*", result);
    }

    @Test
    public void testConvertRechenoperationDivision() {
        String result = Calculator.ConvertRechenoperation(Calculator.Rechenoperation.DIVISION);
        assertEquals("/", result);
    }

    @Test
    public void testBerechnePlus() {
        double result = Calculator.Berechne(1, 2, Calculator.Rechenoperation.ADDITION);
        assertEquals(3.0, result, 0.01);
    }

    @Test
    public void testBerechneMinus() {
        double result = Calculator.Berechne(1, 2, Calculator.Rechenoperation.SUBTRAKTION);
        assertEquals(-1.0, result, 0.01);
    }

    @Test
    public void testBerechneMultiply() {
        double result = Calculator.Berechne(1, 2, Calculator.Rechenoperation.MULTIPLIKATION);
        assertEquals(2.0, result, 0.01);
    }

    @Test
    public void testBerechneDivision() {
        double result = Calculator.Berechne(1, 2, Calculator.Rechenoperation.DIVISION);
        assertEquals(0.5, result, 0.01);
    }

    @Test
    public void testBerechneDivisionByNull() {
        double result = Calculator.Berechne(1, 0, Calculator.Rechenoperation.DIVISION);
        assertEquals(Double.NaN, result, 0.01);
    }
}
