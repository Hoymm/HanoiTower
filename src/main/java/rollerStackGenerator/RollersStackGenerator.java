package rollerStackGenerator;

import rollerStackGenerator.Rollers.Roller;

import java.util.Stack;

public class RollersStackGenerator {
    private static final int DEFAULT_SIZE = 3;
    private int stackSize;
    private StackGeneratorValidator stackGeneratorValidator;

    public RollersStackGenerator() {
        stackGeneratorValidator = new StackGeneratorValidator();
        setStackSize(DEFAULT_SIZE);
    }

    public boolean setStackSize(int stackSizeToGenerate) {
        if (stackGeneratorValidator.isProperSize(stackSizeToGenerate)){
            stackSize = stackSizeToGenerate;
            return true;
        }
        return false;
    }

    public Stack<Roller> generate() {
        Stack<Roller> generatedStack = new Stack<>();
        for (int i = stackSize; i >= 1; --i) {
            generatedStack.push(new Roller(i));
        }
        return generatedStack;
    }
}
