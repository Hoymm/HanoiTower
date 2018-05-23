import RollerStackGenerator.Rollers.Roller;
import RollerStackGenerator.Rollers.RollerValidator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Stack;

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
    public void isProperSize_RollerSize0_returnFalse() {
        assertFalse(rollerValidator.isProperSize(0));
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
    public void isProperRoller_RollerSize0_returnFalse() {
        assertFalse(rollerValidator.isProperRoller(new Roller(0)));
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

    @Test
    public void isProperRollerStack_properStack_returnTrue() {
        Stack<Roller> properRollersStack = StackGenerator.generateRollerStackFirstIndexToBottom(3, 2, 1);
        assertTrue(rollerValidator.isProperRollerStack(properRollersStack));
    }

    @Test
    public void isProperRollerStack_wrongStackBiggerSizesAtTheTop_returnTrue() {
        Stack<Roller> wrongStack = StackGenerator.generateRollerStackFirstIndexToBottom(1, 2, 3);
        assertFalse(rollerValidator.isProperRollerStack(wrongStack));
    }

    @Test
    public void isProperRollerStack_wrongStackSameRollers_returnTrue() {
        Stack<Roller> wrongStack = StackGenerator.generateRollerStackFirstIndexToBottom(1, 2, 2);
        assertFalse(rollerValidator.isProperRollerStack(wrongStack));
    }

    @Test
    public void isProperRollerStack_zeroSizeRoller_returnTrue() {
        Stack<Roller> wrongStack = StackGenerator.generateRollerStackFirstIndexToBottom(0);
        assertFalse(rollerValidator.isProperRollerStack(wrongStack));
    }
}
