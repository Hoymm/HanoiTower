package pillars;

import rollerStackGenerator.Rollers.Roller;
import rollerStackGenerator.Rollers.WrongRollerStack;
import rollerStackGenerator.Rollers.RollerValidator;

import java.util.Arrays;
import java.util.EmptyStackException;
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

    public Roller popRoller() throws EmptyStackException {
        if (rollerStack.isEmpty()){
            throw new EmptyStackException();
        }
        return rollerStack.pop();
    }

    private boolean canRollerBeAddedToStack(Roller roller) {
        return isEmpty() || roller.isSmallerThan(rollerStack.peek());
    }

    public boolean isEmpty() {
        return rollerStack.isEmpty();
    }

    @Override
    public String toString() {
        return rollerStack.toString();
    }
}
