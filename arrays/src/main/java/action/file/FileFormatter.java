package action.file;

import exception.ArrayException;
import org.apache.log4j.Logger;
import validation.ValidateFile;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileFormatter {
    private ValidateFile valid;
    final static Logger logger = Logger.getLogger(FileFormatter.class);

    public FileFormatter() {
        this.valid = new ValidateFile();
    }

    public ArrayList<String> readFile (String filename) throws ArrayException {
        if (filename == null) {
            logger.error("Array is null");
            throw new ArrayException("Array is null");
        } else {
            ArrayList<String> validParameters = new ArrayList<>();
            try (FileReader reader = new FileReader(filename)) {
                validParameters = new ArrayList<>();
                Scanner sc = new Scanner(reader);

                while (sc.hasNextLine()) {
                    String str = sc.nextLine();
                    if (valid.validateString(str))
                        validParameters.add(str);
                }
            } catch (IOException ex) {
                logger.error("This is error: " + ex.getLocalizedMessage());
            }
            return validParameters;
        }
    }
}
