import states.HanoiState;
import states.HanoiStartState;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please insert rollers value in range [3-20], other value will will not be accepted");
        int howManyRollers = 5;

        new Thread(() -> {
            HanoiState hanoi = new HanoiStartState(howManyRollers);
            while (hanoi.notFinished()) {
                hanoi.process();
                hanoi = hanoi.nextState();
                hanoi.printState();
            }
        }).start();
    }
}
