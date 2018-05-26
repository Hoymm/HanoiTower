package states;

import pillars.GamePillars;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.RollersStackGenerator;

import java.util.Stack;
import java.util.function.Consumer;

public class HanoiStartState implements Hanoi {
    private GamePillars gamePillars;
    private Consumer<String> output;

    public HanoiStartState() {
    }

    @Override
    public boolean notFinished() {
        return true;
    }

    @Override
    public void process() {
        initComponents();
    }

    private void initComponents() {
        this.output = System.out::println;
        gamePillars = new GamePillars(generateRollersStack());
    }

    private static Stack<Roller> generateRollersStack() {
        RollersStackGenerator rollersStackGenerator = new RollersStackGenerator();
        rollersStackGenerator.setStackSize(3);
        return rollersStackGenerator.generate();
    }

    @Override
    public Hanoi nextState() {
        return new HanoiRunningState(gamePillars, output);
    }

    @Override
    public void printState() {
        output.accept("Witaj w symulatorze Hanoi");
    }
}
