package RollerStackGenerator;

public class Roller implements Comparable<Roller> {
    private int size;

    public Roller(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Roller o) {
        return this.size - o.size;
    }
}
