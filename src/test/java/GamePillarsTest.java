import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pillars.GamePillars;
import pillars.Pillar;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.RollersStackGenerator;

import java.util.Stack;

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
}
