import RollerStackGenerator.RollersStackGenerator;

public class Main {
    public static void main(String[] args) {
        RollersStackGenerator rollersStackGenerator = new RollersStackGenerator();
        rollersStackGenerator.setStackSize(3);
        HanoiGame hanoiGame = new HanoiGame(rollersStackGenerator.generate(), System.out::println);
        
        while(hanoiGame.notFinished()){
            hanoiGame.nextState();
            hanoiGame.printState();
        }
    }
}
