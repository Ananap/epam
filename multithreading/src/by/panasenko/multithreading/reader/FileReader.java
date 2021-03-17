package by.panasenko.multithreading.reader;

import by.panasenko.multithreading.configuration.PortConfiguration;
import by.panasenko.multithreading.exception.CustomException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class FileReader {
    final static Logger logger = Logger.getLogger(FileReader.class);

    public static PortConfiguration readAll(String filePath) throws CustomException {
        ObjectMapper objectMapper = new ObjectMapper();
        PortConfiguration portConfiguration;
        if (filePath == null) {
            throw new CustomException("filePath is null");
        }
        try {
            portConfiguration = objectMapper.readValue(new File(filePath), PortConfiguration.class);
        } catch (IOException e) {
            logger.info("file " + filePath + " not found", e);
            throw new CustomException("file " + filePath + " not found", e);
        }
        logger.info("read data from file : " + portConfiguration.toString());
        return portConfiguration;
    }
}
