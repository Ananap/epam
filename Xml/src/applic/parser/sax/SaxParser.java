package applic.parser.sax;

import java.io.InputStream;
import java.util.List;

import applic.parser.AbstractXMLParser;
import applic.utils.GreenHouseTags;
import applic.xmlflowers.*;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SaxParser extends AbstractXMLParser {
    private String temp;

    class SaxHandler implements ContentHandler {
        @Override
        public void setDocumentLocator(Locator locator) { }

        @Override
        public void startDocument() {
            greenHouse.setPlants(new Plants());
        }

        @Override
        public void endDocument() { }

        @Override
        public void startPrefixMapping(String prefix, String uri) { }

        @Override
        public void endPrefixMapping(String prefix) { }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) {
            List<Plant> plants = greenHouse.getPlants().getPlant();
            switch (localName) {
                case GreenHouseTags.PLANT:
                    Plant plant = new Plant();
                    plant.setId(Integer.parseInt(atts.getValue(GreenHouseTags.ID)));
                    greenHouse.getPlants().getPlant().add(plant);
                    break;
                case GreenHouseTags.VISUAL_PARAMS:
                    plants.get(plants.size() - 1)
                            .setVisualParams(new VisualParams());
                    break;
                case GreenHouseTags.GROWING_TIPS:
                    plants.get(plants.size() - 1).setGrowingTips(new GrowingTips());
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            List<Plant> plants = greenHouse.getPlants().getPlant();
            Plant lastPlant = plants.get(plants.size() - 1);
            switch (localName) {
                case GreenHouseTags.NAME:
                    lastPlant.setName(temp);
                    break;
                case GreenHouseTags.SOIL:
                    lastPlant.setSoil(temp);
                    break;
                case GreenHouseTags.ORIGIN:
                    lastPlant.setOrigin(temp);
                    break;
                case GreenHouseTags.STALK_COLOR:
                    lastPlant.getVisualParams().setStalkColor(temp);
                    break;
                case GreenHouseTags.LEAF_COLOR:
                    lastPlant.getVisualParams().setLeafColor(temp);
                    break;
                case GreenHouseTags.AVERAGE_SIZE:
                    lastPlant.getVisualParams().setAverageSize(Float.parseFloat(temp));
                    break;
                case GreenHouseTags.TEMPERATURE:
                    lastPlant.getGrowingTips().setTemparature(Byte.parseByte(temp));
                    break;
                case GreenHouseTags.LIGHTING:
                    lastPlant.getGrowingTips().setLighting(Boolean.parseBoolean(temp));
                    break;
                case GreenHouseTags.WATERING:
                    lastPlant.getGrowingTips().setWatering(Integer.parseInt(temp));
                    break;
                case GreenHouseTags.MULTIPLYING:
                    lastPlant.setMultiplying(temp);
                    break;
            }
            temp = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            temp = new String(ch, start, length);
        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) { }

        @Override
        public void processingInstruction(String target, String data) { }

        @Override
        public void skippedEntity(String name) { }

    }

    @Override
    protected GreenHouse parseFile(InputStream xmlis) throws Exception {
        greenHouse = new GreenHouse();
        XMLReader reader = XMLReaderFactory.createXMLReader();
        SaxHandler contentHandler = new SaxHandler();
        reader.setContentHandler(contentHandler);
        reader.parse(new InputSource(xmlis));
        return greenHouse;
    }

}
