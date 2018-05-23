import Pillars.RollersStackGenerator;

public class Main {
    public static void main(String[] args) {
        RollersStackGenerator rollersStackGenerator = new RollersStackGenerator();
        rollersStackGenerator.generateRollersStack(3);

        HanoiGame hanoiGame = new HanoiGame();
        //hanoiGame.setUpNewGame(Pillars.RollersStackGenerator.generateAndReturn(3));
    }
}
