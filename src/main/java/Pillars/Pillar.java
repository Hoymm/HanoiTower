package Pillars;

import RollerStackGenerator.Roller;
import RollerStackGenerator.RollerSizeException;
import RollerStackGenerator.RollerValidator;

import java.util.Stack;

public class Pillar {
    private Stack<Roller> rollerStack;
    private RollerValidator rollerValidator;

    public Pillar(Stack<Roller> rollerStack) throws RollerSizeException {
       // TODO
        /* if (rollerValidator.isProperRoller(rollerStack)) {
            this.rollerStack = rollerStack;
        }*/
        this();
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
