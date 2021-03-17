package by.panasenko.multithreading.entity;

public class Pier {
    private int id;
    private int capacity;
    private volatile boolean isOccupied = false;

    public Pier() { }

    public Pier(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pier{");
        sb.append("id=").append(id);
        sb.append(", capacity=").append(capacity);
        sb.append(", isOccupied=").append(isOccupied);
        sb.append('}');
        return sb.toString();
    }
}
