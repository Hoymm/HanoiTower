import RollerStackGenerator.RollersStackGenerator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RollersStackGeneratorTest {
    private RollersStackGenerator rollersStackGenerator;

    @BeforeMethod
    public void setUp(){
        rollersStackGenerator = new RollersStackGenerator();
    }

    @Test
    public void generateRollerStack_size3_shouldReturnTrue() {
        assertTrue(rollersStackGenerator.generateRollersStack(3));
    }

    @Test
    public void generateRollerStack_size2_shouldReturnFalse() {
        assertFalse(rollersStackGenerator.generateRollersStack(2));
    }

    @Test
    public void generateRollerStack_negativeSize_shouldReturnFalse() {
        assertFalse(rollersStackGenerator.generateRollersStack(-1));
    }
}
