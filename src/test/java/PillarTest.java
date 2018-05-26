import pillars.Pillar;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.Rollers.WrongRollerStack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PillarTest {
    private Roller rollerSize3, rollerSize4;
    private Pillar pillar;

    @BeforeMethod
    public void setUp(){
        pillar = new Pillar();
        rollerSize3 = new Roller(3);
        rollerSize4 = new Roller(4);
        StackGenerator.generateRollerStackFirstIndexToBottom(3);
    }

    @Test
    public void addRollers_toEmptyPillars_returnsTrue() {
        assertTrue(pillar.addRoller(rollerSize3));
    }

    @Test
    public void addRollers_toPillarWithRoller3AddRoller4_returnsFalse() {
        pillar.addRoller(rollerSize3);
        assertFalse(pillar.addRoller(rollerSize4));
    }

    @Test
    public void addRollers_toPillarWithRoller4AddRoller3_returnsTrue() {
        pillar.addRoller(rollerSize4);
        assertTrue(pillar.addRoller(rollerSize3));
    }

    @Test
    public void constructorInitialziatedWithStack543_addRollerSize2_returnsTrue()
            throws WrongRollerStack {
        Stack<Roller> rollerStack = StackGenerator.generateRollerStackFirstIndexToBottom(5,4,3);
        Pillar pillar = new Pillar(rollerStack);
        assertTrue(pillar.addRoller(new Roller(2)));
    }

    @Test
    public void constructorInitialziatedWithStack543_addRollerSize3_returnsFalse()
            throws WrongRollerStack {
        Stack<Roller> rollerStack = StackGenerator.generateRollerStackFirstIndexToBottom(5,4,3);
        Pillar pillar = new Pillar(rollerStack);
        assertFalse(pillar.addRoller(new Roller(3)));
    }

    @Test
    public void constructorInitialziatedWithStack543_addRollerSize4_returnsFalse()
            throws WrongRollerStack {
        Stack<Roller> rollerStack = StackGenerator.generateRollerStackFirstIndexToBottom(5,4,3);
        Pillar pillar = new Pillar(rollerStack);
        assertFalse(pillar.addRoller(new Roller(4)));
    }

    @Test
    public void constructorInitializedWithEmptyStack_addRoller_returnsTrue() throws WrongRollerStack {
        Stack<Roller> rollerStack = StackGenerator.generateRollerStackFirstIndexToBottom();
        Pillar pillar = new Pillar(rollerStack);
        assertTrue(pillar.addRoller(new Roller(4)));
    }

    @Test
    public void constructorInitailizatedWithRollerStackFromTop_20_To_1_isAllowed() throws WrongRollerStack {
        int [] numbersFrom20to1 = StackGenerator.generateIntArray(20, 1);
        Stack<Roller> rollerStackFromTop20To1 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom20to1);
        new Pillar(rollerStackFromTop20To1);
    }

    @Test
    public void constructorInitializatedWithRollerStackFromTop_10_To_5__isAllowed() throws WrongRollerStack {
        int [] numbersFrom5To10 = StackGenerator.generateIntArray(5, 10);
        Stack<Roller> rollerStackFromTop10To5 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom5To10);
        new Pillar(rollerStackFromTop10To5);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_21_To_1_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To21 = StackGenerator.generateIntArray(1, 21);
        Stack<Roller> rollerStackFromTop21To1 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To21);
        new Pillar(rollerStackFromTop21To1);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_4_To_1_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To4 = StackGenerator.generateIntArray(1, 4);
        Stack<Roller> rollerStackFromTop4To1 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To4);
        new Pillar(rollerStackFromTop4To1);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_25_To_22_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To20 = StackGenerator.generateIntArray(22, 25);
        Stack<Roller> rollerStackFromTop25To22 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To20);
        new Pillar(rollerStackFromTop25To22);
    }
}
