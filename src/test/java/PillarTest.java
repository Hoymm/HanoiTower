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
    public void constructorInitializedWithEmptyStack_addRoller_returnsTrue()
            throws WrongRollerStack {
        Stack<Roller> rollerStack = StackGenerator.generateRollerStackFirstIndexToBottom();
        Pillar pillar = new Pillar(rollerStack);
        assertTrue(pillar.addRoller(new Roller(4)));
    }

    @Test
    public void constructorInitailizatedWithRollerStack1_20_isAllowed()
            throws WrongRollerStack {
        int [] numbersFrom20to1 = StackGenerator.generateIntArray(20, 1);
        System.out.println(Arrays.toString(numbersFrom20to1));
        Stack<Roller> rollerStack1To20 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom20to1);
        new Pillar(rollerStack1To20);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStack1_21_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To20 = StackGenerator.generateIntArray(1, 21);
        Stack<Roller> rollerStack1To20 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To20);
        new Pillar(rollerStack1To20);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStack1_4_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To20 = StackGenerator.generateIntArray(1, 4);
        Stack<Roller> rollerStack1To20 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To20);
        new Pillar(rollerStack1To20);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStack22_25_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To20 = StackGenerator.generateIntArray(22, 25);
        Stack<Roller> rollerStack1To20 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To20);
        new Pillar(rollerStack1To20);
    }
}
