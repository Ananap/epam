package applic.parser.dom;

import applic.parser.XMLParser;
import applic.parser.XMLParserFactory;

public class DomParserFactory extends XMLParserFactory {
    @Override
    public XMLParser getXMLParser() {
        return new DomParser();
    }
}

