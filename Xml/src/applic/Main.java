package applic;

import applic.parser.XMLParser;
import applic.parser.XMLParserFactory;
import applic.xmlflowers.GreenHouse;

public class Main {
    public static void main(String[] args) throws Exception {
        XMLParserFactory factory = XMLParserFactory.getInstance(XMLParserFactory.XMLParserType.STAX);
        XMLParser xmlParser = factory.getXMLParser();

        String xmlPath = "src/xmlFiles/greenhouse.xml";
        String xsdPath = "src/xmlFiles/greenhouse.xsd";

        GreenHouse parsedGreenHouse = xmlParser.parse(
                xmlPath,
                xsdPath);
        System.out.println(parsedGreenHouse);
    }
}