import pillars.Pillar;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.Rollers.WrongRollerStack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

public class PillarTest {
    private Roller rollerSize3, rollerSize4;
    private Pillar pillar;

    @BeforeMethod
    public void setUp(){
        pillar = new Pillar();
        rollerSize3 = new Roller(3);
        rollerSize4 = new Roller(4);
//        StackGenerator.generateRollerStackFirstIndexToBottom(3);
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
    public void constructorInitailizatedWithRollerStackFromTop_1_To_20_isAllowed() throws WrongRollerStack {
        int [] numbersFrom20to1 = StackGenerator.generateIntArray(20, 1);
        Stack<Roller> rollerStackFromTop20To1 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom20to1);
        new Pillar(rollerStackFromTop20To1);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_20_To_1_throwsWrongRollerStackException() throws WrongRollerStack {
        int [] numbersFrom1to20 = StackGenerator.generateIntArray(1, 20);
        Stack<Roller> rollerStackFromTop1To20 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1to20);
        new Pillar(rollerStackFromTop1To20);
    }

    @Test
    public void constructorInitializatedWithRollerStackFromTop_5_To_10__isAllowed() throws WrongRollerStack {
        int [] numbersFrom10_To_5 = StackGenerator.generateIntArray(10, 5);
        Stack<Roller> rollerStackFromTop5_To_10 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom10_To_5);
        new Pillar(rollerStackFromTop5_To_10);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_21_To_5_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom5To21 = StackGenerator.generateIntArray(5, 21);
        Stack<Roller> rollerStackFromTop21To5 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom5To21);
        new Pillar(rollerStackFromTop21To5);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_4_To_1_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom1To4 = StackGenerator.generateIntArray(1, 4);
        Stack<Roller> rollerStackFromTop4To1 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom1To4);
        new Pillar(rollerStackFromTop4To1);
    }

    @Test (expectedExceptions = WrongRollerStack.class)
    public void constructorInitailizatedWithRollerStackFromTop_22_To_25_throwsRollerSizeException() throws WrongRollerStack {
        int [] numbersFrom25To22 = StackGenerator.generateIntArray(25, 22);
        Stack<Roller> rollerStackFromTop22To25 = StackGenerator.generateRollerStackFirstIndexToBottom(numbersFrom25To22);
        new Pillar(rollerStackFromTop22To25);
    }

    @Test
    public void isEmpty_whenNewPillar_returnsTrue() {
        assertTrue(pillar.isEmpty());
    }

    @Test
    public void isEmpty_whenPillarContainsAnItem_returnsFalse() {
        pillar.addRoller(new Roller(5));
        assertFalse(pillar.isEmpty());
    }

    @Test
    public void popRoller_whenThereIsOneRoller_afterPop_pillarIsEmpty() {
        Roller rollerToPut = new Roller(1);
        pillar.addRoller(rollerToPut);
        pillar.popRoller();
        assertTrue(pillar.isEmpty());
    }

    @Test
    public void popRoller_whenThereIsTwoRollers_afterPop_pillarIsNotEmpty() {
        Roller rollerToPutValue1 = new Roller(1);
        Roller rollerToPutValue2 = new Roller(2);
        pillar.addRoller(rollerToPutValue2);
        pillar.addRoller(rollerToPutValue1);
        pillar.popRoller();
        assertFalse(pillar.isEmpty());
    }

    @Test
    public void popRoller_whenTwoRollersAdded_thenPop_returnsAnObjectOfFirstRoller() {
        Roller rollerToPutValue1 = new Roller(1);
        Roller rollerToPutValue2 = new Roller(2);
        pillar.addRoller(rollerToPutValue2);
        pillar.addRoller(rollerToPutValue1);
        assertSame(rollerToPutValue1, pillar.popRoller());
    }

    @Test (expectedExceptions = EmptyStackException.class)
    public void popRoller_whenPillarIsEmpty_throwsEmptyStackExceptionError() {
        pillar.popRoller();
    }
}
