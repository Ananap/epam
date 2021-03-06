package epam.applic.parser.stax;

import epam.applic.parser.XMLParser;
import epam.applic.parser.XMLParserFactory;

public class StaxParserFactory extends XMLParserFactory {
    @Override
    public XMLParser getXMLParser() {
        return new StaxParser();
    }
}
