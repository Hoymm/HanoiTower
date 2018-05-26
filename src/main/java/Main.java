import states.HanoiState;
import states.HanoiStartState;

public class Main {
    public static void main(String[] args) {
        HanoiState hanoi = new HanoiStartState();

        new Thread(() -> {
            while (hanoi.notFinished()) {
                hanoi.process();
                hanoi.nextState();
                hanoi.printState();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
