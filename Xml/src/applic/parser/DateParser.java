package applic.parser;

import jdk.nashorn.internal.runtime.ParserException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    private static final String REGULAR_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss";

    public static Date parseString(String date) throws ParserException {
        Date parsingDate = null;
        SimpleDateFormat formatTemplate = new SimpleDateFormat(REGULAR_DATE_FORMAT);
        try {
            parsingDate = formatTemplate.parse(date);
        } catch (ParseException e) {
            e.getMessage();
        }
        return parsingDate;
    }
}
