import rollerStackGenerator.StackGeneratorValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StackGeneratorValidatorTest {
    private StackGeneratorValidator stackGeneratorValidator;

    @BeforeMethod
    public void setUp(){
        stackGeneratorValidator = new StackGeneratorValidator();
    }

    @Test
    public void isProperSize_stackWithSize2_returnsFalse() {
        assertFalse(stackGeneratorValidator.isProperSize(2));
    }

    @Test
    public void isProperSize_stackWithNegativeSize_returnsFalse() {
        assertFalse(stackGeneratorValidator.isProperSize(-1));
    }

    @Test
    public void isProperSize_stackWithZeroSize_returnsFalse() {
        assertFalse(stackGeneratorValidator.isProperSize(0));
    }

    @Test
    public void isProperSize_stackWith21Size_returnsFalse() {
        assertFalse(stackGeneratorValidator.isProperSize(21));
    }

    @Test
    public void isProperSize_stackWithMinimumSizeOf3_returnsTrue() {
        assertTrue(stackGeneratorValidator.isProperSize(3));
    }

    @Test
    public void isProperSize_stackWithMaximumSizeOf20_returnsTrue() {
        assertTrue(stackGeneratorValidator.isProperSize(20));
    }
}
