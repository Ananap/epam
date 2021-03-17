package by.panasenko.multithreading.entity;

import by.panasenko.multithreading.configuration.PierConfiguration;
import by.panasenko.multithreading.configuration.PortConfiguration;
import by.panasenko.multithreading.configuration.ShipConfiguration;
import by.panasenko.multithreading.exception.CustomException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    final static Logger logger = Logger.getLogger(Port.class);
    private static ReentrantLock lock = new ReentrantLock();
    private static Port port;
    private static AtomicBoolean portCreated = new AtomicBoolean();
    private static int PIER_NUMBER;
    private Semaphore semaphore;
    private List<Pier> pierList;

    private Port (){}

    public Port(PortConfiguration portConfiguration) {
        port = new Port();
        PIER_NUMBER = portConfiguration.getPierConfigurationList()
                                            .stream()
                                            .mapToInt(p -> p.getCount())
                                            .sum();
        port.semaphore = new Semaphore(PIER_NUMBER);
        port.pierList = getPierList(portConfiguration.getPierConfigurationList());
        portCreated.set(true);
    }

    public static Port getPort() {
        if (!portCreated.get()) {
            lock.lock();
            if (!portCreated.get()) {
                port = new Port();
                portCreated.set(true);
            }
            lock.unlock();
        }
        return port;
    }

    public Pier getPier(Ship ship) throws CustomException {
        if (ship == null) {
            throw new CustomException("ship is null");
        }
        Pier pier;
        logger.info(ship.toString() + " sailed to the port and got in line");
        try {
            semaphore.acquire();
            lock.lock();
            int numberPier = 0;
            do {
                pier = pierList.get(numberPier);
                numberPier++;
            } while (pier.isOccupied() && pier.getCapacity() >= ship.getCapacity());
            pier.setOccupied(true);
            System.out.println(ship.toString() +  "took up the pier" + numberPier);
            logger.info(ship.toString() + " took up the pier " + numberPier);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CustomException("Current thread " + ship.toString() + " was interrupted");
        } finally {
            lock.unlock();
        }
        return pier;
    }

    public void releasePier(Ship ship, Pier pier) {
        pier.setOccupied(false);
        logger.info(ship.toString() + " left the pier " + pier.getId());
        semaphore.release();
    }

    public List<Pier> getPierList(List<PierConfiguration> pierConfigurationList) {
        List<Pier> resultPier = new ArrayList<>();
        int number = 1;
        for (PierConfiguration pier : pierConfigurationList) {
            int count = pier.getCount();
            while (count != 0) {
                resultPier.add(new Pier(number, pier.getCapacity()));
                number++;
                count--;
            }
        }
        return resultPier;
    }

    public List<Ship> getShipList(List<ShipConfiguration> shipConfigurationList) {
        List<Ship> resultShip = new ArrayList<>();
        int number = 1;
        for (ShipConfiguration ship : shipConfigurationList) {
            int count = ship.getCount();
            while (count != 0) {
                resultShip.add(new Ship(number, ship.getCapacity(), ship.getShipType()));
                number++;
                count--;
            }
        }
        return resultShip;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Port{");
        sb.append("semaphore=").append(semaphore);
        sb.append(", pierList=").append(pierList);
        sb.append('}');
        return sb.toString();
    }
}
