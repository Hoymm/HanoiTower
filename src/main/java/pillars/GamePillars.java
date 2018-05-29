package pillars;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.Rollers.WrongRollerStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GamePillars {
    private List<Pillar> pillars = new ArrayList<>();
    private int rollersInGame;

    public GamePillars(Stack<Roller> rollersStackGenerator) {
        try {
            pillars.add(new Pillar(rollersStackGenerator));
        } catch (WrongRollerStack wrongRollerStack) {
            wrongRollerStack.printStackTrace();
            System.err.println(wrongRollerStack.getMessage());
        }
        pillars.add(new Pillar());
        pillars.add(new Pillar());
        rollersInGame = rollersStackGenerator.size();
    }

    public Pillar getPillar(int index) throws ArrayIndexOutOfBoundsException {
        if (0 <= index && index < pillars.size()){
            return pillars.get(index);
        }
        throw new ArrayIndexOutOfBoundsException("Hanoi pillars index are in range [0-2], you tried to get pillar of index " + index);
    }

    public void moveRollerFromTo(int pillarIndexToTakeFrom, int pillarIndexToPutOn) {
        Pillar pillarToTakeFrom = getPillar(pillarIndexToTakeFrom);
        Pillar pillarToPutOn = getPillar(pillarIndexToPutOn);

        Roller rollerToMove = pillarToTakeFrom.popRoller();
        pillarToPutOn.addRoller(rollerToMove);
    }

    public boolean isGameFinished() {
        return pillars.get(0).isEmpty() && pillars.get(1).isEmpty();
    }

    public int howManyRollersInGame(){
        return rollersInGame;
    }
}
