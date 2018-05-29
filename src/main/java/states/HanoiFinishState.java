package states;

public class HanoiFinishState implements HanoiState {
    @Override
    public boolean notFinished() {
        return false;
    }

    @Override
    public void process() {

    }

    @Override
    public HanoiState nextState() {
        return null;
    }

    @Override
    public void printState() {

    }
}
