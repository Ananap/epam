package applic.parser;

import applic.xmlflowers.GreenHouse;

public interface XMLParser {
    GreenHouse parse(String xmlFile, String xsdFile) throws Exception;
}
