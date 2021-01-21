package action.file;

import org.apache.log4j.Logger;
import validation.ValidateFile;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileFormatter {
    private ValidateFile valid;
    static Logger logger = Logger.getLogger(FileFormatter.class);

    private ArrayList<String> readFile () throws IOException {
        String filename = "file.txt";
        FileReader reader = null;
        ArrayList<String> validParameters = new ArrayList<>();
        try {
            reader = new FileReader(filename);
            validParameters = new ArrayList<>();
            Scanner sc = new Scanner(reader);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                if(valid.validateString(str))
                    validParameters.add(str);
            }
        } catch (IOException ex){
            logger.error("This is error: " + ex.getLocalizedMessage());
        } finally {
            reader.close();
        }
        return validParameters;
    }
}
