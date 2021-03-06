package epam.applic.parser.dom;

import epam.applic.parser.XMLParser;
import epam.applic.parser.XMLParserFactory;

public class DomParserFactory extends XMLParserFactory {
    @Override
    public XMLParser getXMLParser() {
        return new DomParser();
    }
}

