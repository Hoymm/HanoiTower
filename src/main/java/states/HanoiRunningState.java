package states;

import pillars.GamePillars;

import java.util.function.Consumer;

public class HanoiRunningState implements Hanoi{
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
        throw new UnsupportedOperationException();
    }

    @Override
    public Hanoi nextState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printState() {

    }
}
