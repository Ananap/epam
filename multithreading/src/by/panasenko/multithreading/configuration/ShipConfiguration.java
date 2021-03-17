package by.panasenko.multithreading.configuration;

public class ShipConfiguration {
    private int count;
    private int capacity;
    private ShipType shipType;

    public enum ShipType{
        EMPTY, LIGHT, HEAVY
    }

    public ShipConfiguration() {}

    public ShipConfiguration(int count, int capacity, ShipType shipType) {
        this.count = count;
        this.capacity = capacity;
        this.shipType = shipType;
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

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ShipConfiguration{");
        sb.append("count=").append(count);
        sb.append(", capacity=").append(capacity);
        sb.append(", shipType=").append(shipType);
        sb.append('}');
        return sb.toString();
    }
}
