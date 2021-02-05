package applic.parser.stax;

import applic.parser.AbstractXMLParser;
import applic.utils.GreenHouseTags;
import applic.xmlflowers.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.List;

public class StaxParser extends AbstractXMLParser {
    @Override
    protected GreenHouse parseFile(InputStream xmlis) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(xmlis);

        greenHouse = new GreenHouse();
        greenHouse.setPlants(new Plants());
        String temp = null;
        String tagName;
        List<Plant> plants;

        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = reader.getLocalName();
                    plants = greenHouse.getPlants().getPlant();
                    switch (tagName) {
                        case GreenHouseTags.PLANT:
                            Plant plant = new Plant();
                            plant.setId(Integer.parseInt(reader.getAttributeValue(null, GreenHouseTags.ID)));
                            greenHouse.getPlants().getPlant().add(plant);
                            break;
                        case GreenHouseTags.VISUAL_PARAMS:
                            plants.get(plants.size() - 1)
                                    .setVisualParams(new VisualParams());
                            break;
                        case GreenHouseTags.GROWING_TIPS:
                            plants.get(plants.size() - 1).
                                    setGrowingTips(new GrowingTips());
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = reader.getLocalName();
                    plants = greenHouse.getPlants().getPlant();
                    Plant lastPlant = plants.get(plants.size() - 1);
                    switch (tagName) {
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
                    break;
                case XMLStreamConstants.CHARACTERS:
                    temp = reader.getText().trim();
                    break;
            }
        }

        return greenHouse;
    }
}
