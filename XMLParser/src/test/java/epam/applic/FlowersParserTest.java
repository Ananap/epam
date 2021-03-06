package epam.applic;

import epam.applic.listener.TestListener;
import epam.applic.model.*;
import epam.applic.parser.DateParser;
import epam.applic.parser.XMLParser;
import epam.applic.parser.XMLParserFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class FlowersParserTest {
    private GreenHouse greenHouse;
    private XMLParserFactory factory;
    private XMLParser xmlParser;
    private static final String xmlPath = "src/main/resources/flowersXml/greenhouse.xml";
    private static final String xsdPath = "src/main/resources/flowersXml/greenhouse.xsd";

    @BeforeClass
    public void beforeClass() {
        greenHouse = new GreenHouse();
        Plants plants = new Plants();
        List<Plant> plantList = new ArrayList<>();
        plantList.add(new Plant("Cactus", "sod-podzolic", "South Africa", new VisualParams("brown", "none", 0.5f), new GrowingTips((byte) 35, false, 500), "stalk", DateParser.parseString("2020-08-30T15:15:00"), 1));
        plantList.add(new Plant("Orchid", "subterranean", "Asia", new VisualParams("brown", "green", 1.0f), new GrowingTips((byte) 20, true, 800), "seed", DateParser.parseString("2021-02-15T20:11:00"), 2));
        plantList.add(new Plant("Rose", "podzolic", "China", new VisualParams("green", "red", 1.2f), new GrowingTips((byte) 18, true, 1000), "seed", DateParser.parseString("2021-01-30T23:43:00"), 3));
        plants.setPlant(plantList);
        greenHouse.setPlants(plants);
    }

    @Test
    public void testParseDom() throws Exception {
        factory = XMLParserFactory.getInstance(XMLParserFactory.XMLParserType.DOM);
        xmlParser = factory.getXMLParser();
        GreenHouse parsedGreenHouse = xmlParser.parse(xmlPath, xsdPath);
        assertEquals(greenHouse, parsedGreenHouse);
    }

    @Test
    public void testParseSax() throws Exception {
        factory = XMLParserFactory.getInstance(XMLParserFactory.XMLParserType.SAX);
        xmlParser = factory.getXMLParser();
        GreenHouse parsedGreenHouse = xmlParser.parse(xmlPath, xsdPath);
        assertEquals(greenHouse, parsedGreenHouse);
    }

    @Test
    public void testParseStax() throws Exception {
        factory = XMLParserFactory.getInstance(XMLParserFactory.XMLParserType.STAX);
        xmlParser = factory.getXMLParser();
        GreenHouse parsedGreenHouse = xmlParser.parse(xmlPath, xsdPath);
        assertEquals(greenHouse, parsedGreenHouse);
    }

    @AfterClass
    public void afterClass() {
        greenHouse = null;
        factory = null;
        xmlParser = null;
    }
}
