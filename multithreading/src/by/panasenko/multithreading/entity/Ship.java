package by.panasenko.multithreading.entity;

import by.panasenko.multithreading.configuration.ShipConfiguration;
import by.panasenko.multithreading.exception.CustomException;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ship extends Thread{
    private final static Logger logger = Logger.getLogger(Ship.class);
    private int numberShip;
    private int capacity;
    private ShipConfiguration.ShipType shipType;

    public Ship(int numberShip, int capacity, ShipConfiguration.ShipType shipType) {
        super();
        this.numberShip = numberShip;
        this.capacity = capacity;
        this.shipType = shipType;
    }
    @Override
    public void run() {
        Port port = Port.getPort();
        Pier pier = null;
        try {
            pier = port.getPier(this);
            if (shipType == ShipConfiguration.ShipType.EMPTY) {
                loadGoods();
            } else {
                unloadGoods();
            }
        } catch (CustomException e) {
            logger.error("Current thread " + this.toString() + " was interrupted");
        } catch (InterruptedException e) {
            this.interrupt();
            logger.error("Current thread " + this.toString() + " was interrupted");
        } finally {
            if (pier != null) {
                port.releasePier(this, pier);
            }
        }
    }

    private void unloadGoods() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        shipType = ShipConfiguration.ShipType.EMPTY;
        logger.info(this.toString() + " unloaded goods");
    }

    private void loadGoods() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        System.out.println(this.toString() + " loaded goods");
        logger.info(this.toString() + " loaded goods");
    }

    public int getNumberShip() {
        return numberShip;
    }

    public void setNumberShip(int numberShip) {
        this.numberShip = numberShip;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ShipConfiguration.ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipConfiguration.ShipType shipType) {
        this.shipType = shipType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ship{");
        sb.append("numberShip=").append(numberShip);
        sb.append(", capacity=").append(capacity);
        sb.append(", shipType=").append(shipType);
        sb.append('}');
        return sb.toString();
    }
}
