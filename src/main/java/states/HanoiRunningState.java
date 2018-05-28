package states;

import pillars.GamePillars;

import java.util.function.Consumer;

public class HanoiRunningState implements HanoiState {
    private GamePillars gamePillars;
    private Consumer<String> output;

    public HanoiRunningState(GamePillars gamePillars, Consumer<String> output) {
        this.gamePillars = gamePillars;
        this.output = output;
    }

    @Override
    public boolean notFinished() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void process() {
    }

    @Override
    public HanoiState nextState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printState() {

    }
}
