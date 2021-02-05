package applic.parser.stax;

import applic.parser.XMLParser;
import applic.parser.XMLParserFactory;

public class StaxParserFactory extends XMLParserFactory {
    @Override
    public XMLParser getXMLParser() {
        return new StaxParser();
    }
}
