import org.testng.annotations.BeforeMethod;
import pillars.GamePillars;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.RollersStackGenerator;
import states.HanoiRunningState;
import states.HanoiStartState;
import states.HanoiState;

import java.util.Stack;

public class HanoiRunningStateTest {
    private HanoiState hanoiState;
    Stack <Roller> rollersStock;
    GamePillars exampleGamePillars;
    @BeforeMethod
    public void setUp(){
        rollersStock = GamePillarsTest.generateRollersStackFromTop_3_To_1();
        exampleGamePillars = new GamePillars(rollersStock);
        hanoiState = new HanoiRunningState(exampleGamePillars, System.out::println);
    }

    /*@Test
    public void test(){

    }*/

}
