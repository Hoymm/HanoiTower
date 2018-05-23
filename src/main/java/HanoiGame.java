import Pillars.GamePillars;
import RollerStackGenerator.Rollers.Roller;

import java.util.Stack;
import java.util.function.Consumer;

public class HanoiGame {
    private GamePillars gamePillars;
    private Consumer<String> output;

    public HanoiGame(Stack<Roller> rollersStack, Consumer<String> output) {
        gamePillars = new GamePillars(rollersStack);
        this.output = output;
    }
}
