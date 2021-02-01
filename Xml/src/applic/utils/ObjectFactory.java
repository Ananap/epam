package applic.utils;

import applic.xmlflowers.Flower;
import applic.xmlflowers.FlowerParameters;
import applic.xmlflowers.Flowers;
import applic.xmlflowers.GrowingTips;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public static Flowers createFlowers() {
        return new Flowers();
    }

    public static Flower createFlower() {
        return new Flower();
    }

    public static GrowingTips createGrowingTips() {
        return new GrowingTips();
    }

    public static FlowerParameters createFlowerParameters() {
        return new FlowerParameters();
    }
}

