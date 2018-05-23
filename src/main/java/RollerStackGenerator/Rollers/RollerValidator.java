package RollerStackGenerator.Rollers;

import java.util.Stack;

public class RollerValidator {
    private static final int MIN_SIZE = 1, MAX_SIZE = 20;

    public boolean isProperSize(int size) {
        return isProperRoller(new Roller(size));
    }

    public boolean isProperRoller(Roller roller) {
        return (new Roller(MIN_SIZE-1).isSmallerThan(roller) && roller.isSmallerThan(new Roller(MAX_SIZE+1)));
    }

    public boolean isProperRollerStack_ThrowExceptionIfNot(final Stack<Roller> stack) throws WrongRollerStack {
        if (!isStackProperlyIncreasesRollerSizesFromTopToBottom((Stack<Roller>) stack.clone())){
            throw new WrongRollerStack("Stack is not increasing its size from top to bottom " + stack.toString());
        }
        if (!isStackContainingProperSizeRollers((Stack<Roller>) stack.clone())){
            throw new WrongRollerStack("Stack contain wrong size roller " + stack.toString());
        }
        return true;
    }

    private boolean isStackProperlyIncreasesRollerSizesFromTopToBottom(Stack<Roller> stack) {
        if (stack.isEmpty()){
            return true;
        }

        Roller latestRoller = stack.pop();
        while(!stack.isEmpty()){
            if (!latestRoller.isSmallerThan(stack.peek())){
                return false;
            }
            latestRoller = stack.pop();
        }
        return true;
    }

    private boolean isStackContainingProperSizeRollers(Stack<Roller> stack) {
        if (stack.isEmpty()){
            return true;
        }

        while(!stack.isEmpty()){
            if (!isProperRoller(stack.pop())){
                return false;
            }
        }
        return true;
    }
}
