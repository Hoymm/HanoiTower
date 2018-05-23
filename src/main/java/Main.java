import RollerStackGenerator.RollersStackGenerator;

public class Main {
    public static void main(String[] args) {
        RollersStackGenerator rollersStackGenerator = new RollersStackGenerator();
        rollersStackGenerator.generateRollersStack(3);

        HanoiGame hanoiGame = new HanoiGame();
        //hanoiGame.setUpNewGame(RollerStackGenerator.RollersStackGenerator.generateAndReturn(3));
    }
}
