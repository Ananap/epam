package by.panasenko.handling.reader;

import by.panasenko.handling.exception.CompositeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class StringFromFileTextReader {
    public final static Logger logger = LogManager.getLogger();

    public String readStringsFromFile(String filePath) throws CompositeException {
        String stringsFromFile;
        if(filePath == null) {
        	throw new CompositeException("filePath in method arguments is null");
        }
        try {
        	stringsFromFile = Files.lines(Paths.get(filePath)).collect(Collectors.joining());
        } catch (IOException e) {
        	e.printStackTrace();
            throw new CompositeException("File input exception",e);      	
        }
        logger.log(Level.INFO,"read text from file : " + stringsFromFile );
        return stringsFromFile;
    }
}
