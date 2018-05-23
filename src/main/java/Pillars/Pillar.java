package Pillars;

import RollerStackGenerator.Rollers.Roller;
import RollerStackGenerator.Rollers.WrongRollerStack;
import RollerStackGenerator.Rollers.RollerValidator;

import java.util.Stack;

public class Pillar {
    private Stack<Roller> rollerStack;
    private RollerValidator rollerValidator;

    public Pillar(Stack<Roller> rollerStack) throws WrongRollerStack {
        this();
        if (rollerValidator.isProperRollerStack_ThrowExceptionIfNot(rollerStack)) {
            this.rollerStack = rollerStack;
        }
        this.rollerStack = rollerStack;
    }

    public Pillar(){
        rollerValidator = new RollerValidator();
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
