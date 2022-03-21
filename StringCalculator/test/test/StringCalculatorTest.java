package test;

import core.StringCalculator;
import exception.IncorrectValueException;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZero() {
        Assert.assertEquals("Should be Zero", 0, StringCalculator.add(null));
        Assert.assertEquals("Should be Zero", 0, StringCalculator.add(Utils.EMPTY));
    }

    @Test
    public void shouldSumOneAndThree() {
        Assert.assertEquals("Should be 4", 4, StringCalculator.add("1,3"));
    }

    @Test
    public void shouldSumOneThreeAndSix() {
        Assert.assertEquals("Should be 10", 10, StringCalculator.add("1,3,6"));
    }

    public void shouldSumOneTwoThreeAndFour() {
        Assert.assertEquals("Should be 10", 10, StringCalculator.add("1,2,3,4"));
    }

    @Test
    public void shouldHandleNewLine() {
        Assert.assertEquals("Should be 6", 6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void shouldHandleNewLine2() {
        Assert.assertEquals("Should be 8", 8, StringCalculator.add("2,3\n3"));
    }

    @Test
    public void shouldSumOneAndZero() {
        Assert.assertEquals("Should be 1", 1, StringCalculator.add("1,\n"));
    }

    @Test
    public void shouldHandleSeparator() {
        Assert.assertEquals("Should be 3", 3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void shouldHandleSeparatorWithNewLine() {
        Assert.assertEquals("Should be 7", 7, StringCalculator.add("//;\n1\n1;2\n3"));
    }

    @Test
    public void shouldHandleNegativeValue() {
        Assert.assertThrows("Value can't be negative", IncorrectValueException.class, () -> StringCalculator.add("//;\n1\n1;-2\n3"));
    }

    @Test
    public void shouldHandleNegativeValue2() {
        Assert.assertThrows("Value can't be negative", IncorrectValueException.class, () -> StringCalculator.add("-1,2"));
    }
}
