import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.RollersStackGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Stack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RollersStackGeneratorTest {
    private RollersStackGenerator rollersStackGenerator;

    @BeforeMethod
    public void setUp(){
        rollersStackGenerator = new RollersStackGenerator();
    }

    @Test
    public void setStackSize_size3_shouldReturnTrue() {
        assertTrue(rollersStackGenerator.setStackSize(3));
    }

    @Test
    public void setStackSize_maxSize20_shouldReturnTrue() {
        assertTrue(rollersStackGenerator.setStackSize(20));
    }

    @Test
    public void setStackSize_negativeSize_shouldReturnFalse() {
        assertFalse(rollersStackGenerator.setStackSize(-1));
    }

    @Test
    public void setStackSize_size2_shouldReturnFalse() {
        assertFalse(rollersStackGenerator.setStackSize(2));
    }

    @Test
    public void setStackSize_maxSize20Plus1_shouldReturnFalse() {
        assertFalse(rollersStackGenerator.setStackSize(20+1));
    }

    @Test
    public void generateStack_whenGeneratorInitializatedWithSize5_returnStackWithProperRollers() {
        // given
        RollersStackGenerator stackGeneratedOfSize5 = new RollersStackGenerator();
        stackGeneratedOfSize5.setStackSize(5);
        // when
        Stack<Roller> expectedRollerStack = generateRollersStack(5);
        // then
        assertEquals(stackGeneratedOfSize5.generate(), expectedRollerStack);
    }

    @Test
    public void generateStack_whenGeneratorInitializatedWithSize3_returnStackWithProperRollers() {
        // given
        RollersStackGenerator stackGeneratedOfSize3 = new RollersStackGenerator();
        stackGeneratedOfSize3.setStackSize(3);
        // when
        Stack<Roller> expectedRollerStack = generateRollersStack(3);
        // then
        assertEquals(stackGeneratedOfSize3.generate(), expectedRollerStack);
    }

    @Test
    public void generateStack_whenSizeNotSpecified_returnStackWithDefaultSizeOf3() {
        // given
        RollersStackGenerator stackGenerated = new RollersStackGenerator();
        // when
        int defaultSize = 3;
        Stack<Roller> expectedRollerStack = generateRollersStack(defaultSize);
        // then
        assertEquals(stackGenerated.generate(), expectedRollerStack);
    }

    private Stack<Roller> generateRollersStack(int i2) {
        Stack<Roller> expectedRollerStack = new Stack<>();
        for (int i = i2; i > 0; --i) {
            expectedRollerStack.push(new Roller(i));
        }
        return expectedRollerStack;
    }
}
