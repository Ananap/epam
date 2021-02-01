package applic.parser;

import applic.xmlflowers.Flowers;

public interface XMLParser {
    Flowers parse(String xmlFile, String xsdFile) throws Exception;
}
