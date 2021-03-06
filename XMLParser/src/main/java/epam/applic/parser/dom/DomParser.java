package epam.applic.parser.dom;

import epam.applic.model.*;
import epam.applic.parser.AbstractXMLParser;
import epam.applic.parser.DateParser;
import epam.applic.util.GreenHouseTags;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

class DomParser extends AbstractXMLParser {

    @Override
    protected GreenHouse parseFile(InputStream xmlis) throws Exception {
        greenHouse = new GreenHouse();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlis);
        Element root = document.getDocumentElement();
        Element plants = (Element) root.getElementsByTagName(GreenHouseTags.PLANTS).item(0);
        greenHouse.setPlants(parsePlants(plants));
        return greenHouse;
    }

    private Plants parsePlants(Element plants) {
        Plants parsedPlants = new Plants();
        NodeList plantList = plants.getElementsByTagName(GreenHouseTags.PLANT);
        for (int i = 0; i < plantList.getLength(); i++) {
            Element plant = (Element) plantList.item(i);
            parsedPlants.getPlant().add(parsePlant(plant));
        }
        return parsedPlants;
    }

    private Plant parsePlant(Element plant) {
        Plant parsedPlant = new Plant();
        parsedPlant.setId(Integer.parseInt(plant.getAttribute(GreenHouseTags.ID)));
        parsedPlant.setName(plant.getElementsByTagName(GreenHouseTags.NAME).item(0).getTextContent());
        parsedPlant.setSoil(plant.getElementsByTagName(GreenHouseTags.SOIL).item(0).getTextContent());
        parsedPlant.setOrigin(plant.getElementsByTagName(GreenHouseTags.ORIGIN).item(0).getTextContent());
        parsedPlant.setVisualParams(parseVisualParams((Element) plant.getElementsByTagName(GreenHouseTags.VISUAL_PARAMS).item(0)));
        parsedPlant.setGrowingTips(parseGrowingTips((Element) plant.getElementsByTagName(GreenHouseTags.GROWING_TIPS).item(0)));
        parsedPlant.setMultiplying(plant.getElementsByTagName(GreenHouseTags.MULTIPLYING).item(0).getTextContent());
        parsedPlant.setDatePlanted(DateParser.parseString(plant.getElementsByTagName(GreenHouseTags.DATEPLANTED).item(0).getTextContent()));
        return parsedPlant;
    }

    private VisualParams parseVisualParams(Element params) {
        VisualParams parsedParams = new VisualParams();
        parsedParams.setStalkColor(params.getElementsByTagName(GreenHouseTags.STALK_COLOR).item(0).getTextContent());
        parsedParams.setLeafColor(params.getElementsByTagName(GreenHouseTags.LEAF_COLOR).item(0).getTextContent());
        parsedParams.setAverageSize(Float.parseFloat(params.getElementsByTagName(GreenHouseTags.AVERAGE_SIZE).item(0).getTextContent()));
        return parsedParams;
    }

    private GrowingTips parseGrowingTips(Element tips) {
        GrowingTips parsedTips = new GrowingTips();
        parsedTips.setTemparature(Byte.parseByte(tips.getElementsByTagName(GreenHouseTags.TEMPERATURE).item(0).getTextContent()));
        parsedTips.setLighting(Boolean.parseBoolean(tips.getElementsByTagName(GreenHouseTags.LIGHTING).item(0).getTextContent()));
        parsedTips.setWatering(Integer.parseInt(tips.getElementsByTagName(GreenHouseTags.WATERING).item(0).getTextContent()));
        return parsedTips;
    }
}

