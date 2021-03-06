package epam.applic.parser;

import jdk.nashorn.internal.runtime.ParserException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    final static Logger logger = LogManager.getLogger(AbstractXMLParser.class);
    private static final String REGULAR_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";

    public static Date parseString(String date) throws ParserException {
        Date parsingDate = null;
        SimpleDateFormat formatTemplate = new SimpleDateFormat(REGULAR_DATE_FORMAT);
        try {
            parsingDate = formatTemplate.parse(date);
        } catch (ParseException e) {
            logger.error("Error: " + e.getMessage());
        }
        return parsingDate;
    }
}
