package RollerStackGenerator;

public class RollerValidator {
    private static final int MIN_SIZE = 3, MAX_SIZE = 20;

    public boolean isProperSize(int size) {
        return isProperRoller(new Roller(size));
    }

    public boolean isProperRoller(Roller roller) {
        return (new Roller(MIN_SIZE-1).isSmallerThan(roller) && roller.isSmallerThan(new Roller(MAX_SIZE+1)));
    }
}
