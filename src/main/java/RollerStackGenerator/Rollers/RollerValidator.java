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

    public boolean isProperRollerStack(final Stack<Roller> stack) {
        return isStackDecreasing((Stack<Roller>) stack.clone())
                && isStackContainingProperSizeRollers((Stack<Roller>) stack.clone());
    }

    private boolean isStackDecreasing(Stack<Roller> stack) {
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
