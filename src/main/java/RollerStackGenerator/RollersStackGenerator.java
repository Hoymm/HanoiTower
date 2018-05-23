package RollerStackGenerator;

import java.util.Stack;

public class RollersStackGenerator {
    private static final int DEFAULT_SIZE = 3, MIN_SIZE = 3, MAX_SIZE = 20;
    private int stackSize;

    public RollersStackGenerator() {
        setStackSize(DEFAULT_SIZE);
    }

    public boolean setStackSize(int rollersToGenerate) {
        if (MIN_SIZE <= rollersToGenerate && rollersToGenerate <= MAX_SIZE){
            stackSize = rollersToGenerate;
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
