import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import states.HanoiState;
import states.HanoiRunningState;
import states.HanoiStartState;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HanoiStartStateTest {
    private HanoiState hanoi;

    @BeforeMethod
    public void setUp(){
        hanoi = new HanoiStartState(3);
    }

    @Test
    public void notFinished_whenGameJustStarted_returnsTrue() {
        assertTrue(hanoi.notFinished());
    }

    @Test
    public void nextState_whenInHanoiStartState_returnsHanoiRunningState() {
        assertEquals(hanoi.nextState().getClass(), HanoiRunningState.class);
    }
}
