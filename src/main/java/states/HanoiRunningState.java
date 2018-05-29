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
        return !gamePillars.isGameFinished();
    }

    @Override
    public void process() {
    }

    @Override
    public HanoiState nextState() {
        arrangeHanoi(gamePillars.howManyRollersInGame(), 0, 2, 1);
        return new HanoiFinishState();
    }

    private void arrangeHanoi(int rollersToMove, int moveFromPillarIndex, int moveToPillarIndex, int otherPillarIndex) {
        if (rollersToMove == 1) {
            System.out.printf("Move from pillar %s to pillar %s\n", moveFromPillarIndex+1, moveToPillarIndex+1);
            gamePillars.moveRollerFromTo(moveFromPillarIndex, moveToPillarIndex);
            printState();
        }
        else {
            arrangeHanoi(rollersToMove - 1, moveFromPillarIndex, otherPillarIndex, moveToPillarIndex);
            System.out.printf("Move from pillar %s to pillar %s\n", moveFromPillarIndex+1, moveToPillarIndex+1);
            gamePillars.moveRollerFromTo(moveFromPillarIndex, moveToPillarIndex);
            printState();
            arrangeHanoi(rollersToMove - 1, otherPillarIndex, moveToPillarIndex, moveFromPillarIndex);
        }
    }

    @Override
    public void printState() {
        System.out.println("Pillar 1: " + gamePillars.getPillar(0));
        System.out.println("Pillar 2: " + gamePillars.getPillar(1));
        System.out.println("Pillar 3: " + gamePillars.getPillar(2));
        System.out.println();
    }
}
