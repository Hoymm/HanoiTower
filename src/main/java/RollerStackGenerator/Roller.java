package RollerStackGenerator;

import java.util.Objects;

public class Roller implements Comparable<Roller> {
    private int size;

    public Roller(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Roller o) {
        return this.size - o.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roller roller = (Roller) o;
        return size == roller.size;
    }
}
