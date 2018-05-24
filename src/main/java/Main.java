import states.Hanoi;
import states.HanoiStartState;

public class Main {
    public static void main(String[] args) {
        Hanoi hanoi = new HanoiStartState();

        while(hanoi.notFinished()){
            hanoi.process();
            hanoi.nextState();
            hanoi.printState();
        }
    }
}
