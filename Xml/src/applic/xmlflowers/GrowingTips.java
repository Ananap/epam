package applic.xmlflowers;

import javax.xml.bind.annotation.XmlElement;

public class GrowingTips {
    @XmlElement
    private double temperature;
    @XmlElement(required = true)
    private int watering;
    @XmlElement(required = true)
    private boolean lightLoving;
    @XmlElement
    private Multiplying multiplying;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public boolean isLightLoving() {
        return lightLoving;
    }

    public void setLightLoving(boolean lightLoving) {
        this.lightLoving = lightLoving;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }
}
