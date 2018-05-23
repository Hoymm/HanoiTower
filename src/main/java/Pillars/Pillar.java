package Pillars;

import RollerStackGenerator.Roller;

import java.util.Stack;

public class Pillar {
    private Stack<Roller> rollerStack;

    public Pillar(Stack<Roller> rollerStack) {
        this.rollerStack = rollerStack;
    }

    public Pillar(){
        this.rollerStack = new Stack<>();
    }

    public boolean addRoller(Roller roller) {
        if (canRollerBeAddedToStack(roller)){
            rollerStack.push(roller);
            return true;
        }
        return false;
    }

    private boolean canRollerBeAddedToStack(Roller roller) {
        return rollerStack.empty() || roller.isSmallerThan(rollerStack.peek());
    }
}
