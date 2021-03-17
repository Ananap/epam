package by.panasenko.multithreading;

import by.panasenko.multithreading.configuration.PortConfiguration;
import by.panasenko.multithreading.entity.Port;
import by.panasenko.multithreading.entity.Ship;
import by.panasenko.multithreading.exception.CustomException;
import by.panasenko.multithreading.reader.FileReader;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	    String filename = "data/data.json";
	    try {
            PortConfiguration portConfiguration = FileReader.readAll(filename);
            Port port = new Port(portConfiguration);
            List<Ship> shipList = port.getShipList(portConfiguration.getShipConfigurationList());
            for (Ship ship: shipList) {
                ship.start();
            }
        } catch (CustomException e) {
	        logger.error(e);
        }
    }
}
