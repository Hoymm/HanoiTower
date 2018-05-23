package RollerStackGenerator;

import java.util.Stack;

public class RollersStackGenerator {
    private static final int DEFAULT_SIZE = 3;
    private int stackSize;
    private RollerValidator rollerValidator;

    public RollersStackGenerator() {
        rollerValidator = new RollerValidator();
        setStackSize(DEFAULT_SIZE);
    }

    public boolean setStackSize(int stackSizeToGenerate) {
        if (rollerValidator.isProperSize(stackSizeToGenerate)){
            stackSize = stackSizeToGenerate;
            return true;
        }
        return false;
    }

    public Stack<Roller> generate() {
        Stack<Roller> generatedStack = new Stack<>();
        for (int i = 1; i < stackSize; ++i) {
            generatedStack.add(new Roller(i));
        }
        return generatedStack;
    }
}
