package Pillars;
import RollerStackGenerator.Rollers.Roller;
import RollerStackGenerator.Rollers.WrongRollerStack;

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


}
