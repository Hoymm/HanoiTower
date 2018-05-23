import RollerStackGenerator.Roller;
import RollerStackGenerator.RollerValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RollerValidatorTest {
    private RollerValidator rollerValidator;

    @BeforeMethod
    public void setUp(){
        rollerValidator = new RollerValidator();
    }

    @Test
    public void isProperSize_RollerNegativeSize_returnFalse() {
        assertFalse(rollerValidator.isProperSize(-1));
    }

    @Test
    public void isProperSize_RollerSize2_returnFalse() {
        assertFalse(rollerValidator.isProperSize(2));
    }

    @Test
    public void isProperSize_RollerSize21_returnFalse() {
        assertFalse(rollerValidator.isProperSize(21));
    }

    @Test
    public void isProperSize_RollerSize3_returnTrue() {
        assertTrue(rollerValidator.isProperSize(3));
    }

    @Test
    public void isProperSize_RollerSize20_returnTrue() {
        assertTrue(rollerValidator.isProperSize(20));
    }

    @Test
    public void isProperRoller_RollerNegativeSize_returnFalse() {
        assertFalse(rollerValidator.isProperRoller(new Roller(-1)));
    }

    @Test
    public void isProperRoller_RollerSize2_returnFalse() {
        assertFalse(rollerValidator.isProperRoller(new Roller(2)));
    }

    @Test
    public void isProperRoller_RollerSize21_returnFalse() {
        assertFalse(rollerValidator.isProperRoller(new Roller(21)));
    }

    @Test
    public void isProperRoller_RollerSize3_returnTrue() {
        assertTrue(rollerValidator.isProperRoller(new Roller(3)));
    }

    @Test
    public void isProperRoller_RollerSize20_returnTrue() {
        assertTrue(rollerValidator.isProperRoller(new Roller(20)));
    }
}
