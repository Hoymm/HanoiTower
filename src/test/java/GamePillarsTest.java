import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pillars.GamePillars;
import pillars.Pillar;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.RollersStackGenerator;

import java.util.Stack;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GamePillarsTest {
    private static GamePillars gamePillars;

    @BeforeMethod
    public void setUp(){
        gamePillars = new GamePillars(generateRollersStackFromTop_3_To_1());
    }

    @Test (expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void getPillar_index3_throwsAnExceptionNoPillarOfSuchIndex(){
        gamePillars.getPillar(3);
    }

    @Test
    public void getPillar_index2_returnsAnEmptyPillar(){
        Pillar pillar = gamePillars.getPillar(2);
        pillar.isEmpty();
    }

    static Stack<Roller> generateRollersStackFromTop_3_To_1() {
        RollersStackGenerator rollersStackGenerator = new RollersStackGenerator();
        rollersStackGenerator.setStackSize(3);
        return rollersStackGenerator.generate();
    }

    @Test
    public void moveRollerFromTo_from_0_to_1_thenPillar1_isEmpty_returnsFalse() {
        gamePillars.moveRollerFromTo(0,1);
        assertFalse(gamePillars.getPillar(1).isEmpty());
    }

    @Test
    public void moveRollerFromTo_from_0_to_2_thenPillar2_isEmpty_returnsFalse() {
        gamePillars.moveRollerFromTo(0,2);
        assertFalse(gamePillars.getPillar(2).isEmpty());
    }

    @Test
    public void isGameFinished_whenMoveAllRollersOoLastPillar_returnsTrue() {
        winGameForThreeRollers();
        assertTrue(gamePillars.isGameFinished());
    }

    @Test
    public void isGameFinished_returnsTrue_whenMoveAllRollersOnFirstPillar_returnsFalse() {
        assertFalse(gamePillars.isGameFinished());
    }

    @Test
    public void isGameFinished_returnsTrue_whenGameInProgress_returnsFalse() {
        gamePillars.moveRollerFromTo(0, 2);
        gamePillars.moveRollerFromTo(0, 1);
        gamePillars.moveRollerFromTo(2, 1);
        gamePillars.moveRollerFromTo(0, 2);
        assertFalse(gamePillars.isGameFinished());
    }

    private void winGameForThreeRollers() {
        gamePillars.moveRollerFromTo(0, 2);
        gamePillars.moveRollerFromTo(0, 1);
        gamePillars.moveRollerFromTo(2, 1);
        gamePillars.moveRollerFromTo(0, 2);
        gamePillars.moveRollerFromTo(1, 0);
        gamePillars.moveRollerFromTo(1, 2);
        gamePillars.moveRollerFromTo(0, 2);
    }
}
