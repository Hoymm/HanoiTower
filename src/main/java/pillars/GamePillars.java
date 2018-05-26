package pillars;
import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.Rollers.WrongRollerStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GamePillars {
    private List<Pillar> pillars = new ArrayList<>(3);

    public GamePillars(Stack<Roller> rollersStackGenerator) {
        try {
            pillars.add(new Pillar(rollersStackGenerator));
        } catch (WrongRollerStack wrongRollerStack) {
            wrongRollerStack.printStackTrace();
            System.err.println(wrongRollerStack.getMessage());
        }
        pillars.add(new Pillar());
        pillars.add(new Pillar());
    }

    public Pillar getPillar(int index) throws ArrayIndexOutOfBoundsException {
        if (0 <= index && index < pillars.size()){
            return pillars.get(index);
        }
        throw new ArrayIndexOutOfBoundsException("Hanoi pillars index are in range [0-2], you tried to get pillar of index " + index);
    }


}
