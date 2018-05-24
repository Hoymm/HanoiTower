package rollerStackGenerator;

public class StackGeneratorValidator {
    private final int MIN_STACK_SIZE_TO_GEN = 3, MAX_STACK_SIZE_TO_GEN = 20;

    public boolean isProperSize(int size) {
        return MIN_STACK_SIZE_TO_GEN <= size && size <= MAX_STACK_SIZE_TO_GEN;
    }
}
