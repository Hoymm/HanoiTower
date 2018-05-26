package states;

public interface HanoiState {
    boolean notFinished();
    void process();
    HanoiState nextState();
    void printState();
}
