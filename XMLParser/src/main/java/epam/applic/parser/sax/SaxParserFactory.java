package epam.applic.parser.sax;

import epam.applic.parser.XMLParser;
import epam.applic.parser.XMLParserFactory;

public class SaxParserFactory extends XMLParserFactory {
    @Override
    public XMLParser getXMLParser() {
        return new SaxParser();
    }
}
