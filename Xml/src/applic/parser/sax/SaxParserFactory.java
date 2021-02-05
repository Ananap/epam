package applic.parser.sax;

import applic.parser.XMLParser;
import applic.parser.XMLParserFactory;

public class SaxParserFactory extends XMLParserFactory {
    @Override
    public XMLParser getXMLParser() {
        return new SaxParser();
    }
}
