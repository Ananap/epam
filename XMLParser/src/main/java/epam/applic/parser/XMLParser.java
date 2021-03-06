package epam.applic.parser;

import epam.applic.model.GreenHouse;

public interface XMLParser {
    GreenHouse parse(String xmlFile, String xsdFile) throws Exception;
}
