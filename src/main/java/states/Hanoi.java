package states;

public interface Hanoi {
    boolean notFinished();
    void process();
    Hanoi nextState();
    void printState();
}
