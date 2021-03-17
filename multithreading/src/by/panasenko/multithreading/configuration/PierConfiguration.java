package by.panasenko.multithreading.configuration;

public class PierConfiguration {
    private int count;
    private int capacity;

    public PierConfiguration() {
    }

    public PierConfiguration(int count, int capacity) {
        this.count = count;
        this.capacity = capacity;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PierConfiguration{");
        sb.append("count=").append(count);
        sb.append(", capacity=").append(capacity);
        sb.append('}');
        return sb.toString();
    }
}
