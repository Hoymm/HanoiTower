package rollerStackGenerator.Rollers;

public class Roller {
    private int size;

    public Roller(int size) {
        this.size = size;
    }

    public boolean isSmallerThan(Roller roller){
        return this.size < roller.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roller roller = (Roller) o;
        return size == roller.size;
    }

    @Override
    public String toString() {
        return String.valueOf(size);
    }
}
