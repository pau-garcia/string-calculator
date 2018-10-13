package pau.garcia.kata.StringCalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    @Test
    public final void whenTwoNumbersThenNoExceptionIsThrown() {
        StringCalculator.sum("1,3");
        Assert.assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public final void whenSpaceAfterSemicolonShouldThrowException() {
        StringCalculator.sum("1, 2");
    }

    @Test
    public final void whenMoreThanTwoParamsShouldReturnTheSum() {
        Assert.assertEquals(1+2+3+4+5, StringCalculator.sum("1,2,3,4,5"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNoNumbersShouldThrowException() {
        StringCalculator.sum("A,2");
    }

    @Test
    public final void whenEmptyStringShouldReturnZero() {
        int result = StringCalculator.sum("");
        Assert.assertEquals(0, result);
    }

    @Test
    public final void whenTwoNumberShouldReturnTheSum() {
        int result = StringCalculator.sum("1,3");
        Assert.assertEquals(1+3, result);
    }
    @Test
    public final void whenOneNumberShouldReturnTheNumber() {
        int result = StringCalculator.sum("3");
        Assert.assertEquals(3, result);
    }

    @Test
    public final void whenLineBreakThenReturnSum() {
        Assert.assertEquals(1+3+5, StringCalculator.sum("1,3\n5"));
    }

    @Test
    public final void whenDelimiterIsInformedThenReturnSum() {
        Assert.assertEquals(1+3+5, StringCalculator.sum("//;\n1;3;5"));
    }

    @Test
    public final void whenDelimiterIsSemicolonAndLineBreaksThenReturnSum() {
        Assert.assertEquals(1+3+5, StringCalculator.sum("//;\n1;3\n5"));
    }

    @Test
    public final void whenDelimiterIsUnderscoreAndLineBreaksThenReturnSum() {
        Assert.assertEquals(1+3+5, StringCalculator.sum("//_\n1_3\n5"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenNegativeShouldThrowException() {
        StringCalculator.sum("1,-12");
    }

    @Test
    public final void whenNegativeShouldThrowExceptionWithProperMessage() {
        try {
            StringCalculator.sum("1,-12");
        } catch (Exception e) {
            Assert.assertNotNull(e);
            Assert.assertEquals(StringCalculator.NEGATIVE_VALUES_NOT_ALLOWED + ":-12", e.getMessage());
        }
    }

    @Test
    public final void whenNegativesShouldThrowExceptionWithProperMessage() {
        try {
            StringCalculator.sum("1,-12,-3");
        } catch (Exception e) {
            Assert.assertNotNull(e);
            Assert.assertEquals(StringCalculator.NEGATIVE_VALUES_NOT_ALLOWED + ":-12,-3", e.getMessage());
        }
    }

    @Test
    public final void whenNumberBiggerThanHundredThenReturnSumIgnoringIt() {
        Assert.assertEquals(1+5, StringCalculator.sum("1,300,5"));
    }

    @Test(expected = RuntimeException.class)
    public final void whenTextLongerThanTwoCharsThenReturnSumIgnoringIt() {
        StringCalculator.sum("1,XXX,5");
    }

}
