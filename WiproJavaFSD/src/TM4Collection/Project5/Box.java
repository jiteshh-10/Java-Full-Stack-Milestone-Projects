package TM4Collection.Project5;

import java.util.Objects;

public class Box implements Comparable<Box> {
    private double length;
    private double width;
    private double height;

    // Constructor to initialize the box's dimensions
    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    // Helper method to calculate the volume
    public double getVolume() {
        return this.length * this.width * this.height;
    }

    /**
     * This method is crucial for TreeSet. It determines the sorting order
     * and uniqueness. If it returns 0, the TreeSet considers the
     * element a duplicate and does not add it. We compare based on volume.
     */
    @Override
    public int compareTo(Box other) {
        return Double.compare(this.getVolume(), other.getVolume());
    }

    /**
     * Overriding equals to define uniqueness based on volume.
     * This is required by the problem statement and is essential for Sets like HashSet.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Box other = (Box) obj;
        return Double.compare(this.getVolume(), other.getVolume()) == 0;
    }

    /**
     * When equals() is overridden, hashCode() must also be overridden.
     * Its hash code should be based on the same property: the volume.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getVolume());
    }

    /**
     * Overriding toString() to provide a clean, formatted output as required.
     */
    @Override
    public String toString() {
        return String.format("Length =%.1f Width =%.1f Height =%.1f Volume =%.2f",
                this.length, this.width, this.height, this.getVolume());
    }
}