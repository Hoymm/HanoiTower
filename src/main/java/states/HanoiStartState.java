package states;

import pillars.GamePillars;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.RollersStackGenerator;

import java.util.Stack;
import java.util.function.Consumer;

public class HanoiStartState implements HanoiState {
    private GamePillars gamePillars;
    private Consumer<String> output;
    private int howManyRollers;

    public HanoiStartState(int howManyRollers) {
        setHowManyRollers(howManyRollers);
    }

    private void setHowManyRollers(int howManyRollers) {
        if (howManyRollers >= 3 && howManyRollers <= 20) {
            this.howManyRollers = howManyRollers;
        }
        else if (howManyRollers < 3){
            System.out.println("You have inserted " + howManyRollers + " it is to less, program changed your input to 3 rollers : P");
            this.howManyRollers = 3;
        }
        else if (howManyRollers > 20){
            System.out.println("You have inserted " + howManyRollers + " it is to less, program changed your input to 20 rollers : P");
            this.howManyRollers = 20;
        }
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

    private Stack<Roller> generateRollersStack() {
        RollersStackGenerator rollersStackGenerator = new RollersStackGenerator();
        rollersStackGenerator.setStackSize(this.howManyRollers);
        return rollersStackGenerator.generate();
    }

    @Override
    public HanoiState nextState() {
        return new HanoiRunningState(gamePillars, output);
    }

    @Override
    public void printState() {
        output.accept("Witaj w symulatorze HanoiState");
    }
}
