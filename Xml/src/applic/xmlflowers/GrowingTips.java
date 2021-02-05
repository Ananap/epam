package applic.xmlflowers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class GrowingTips {

    private byte temparature;
    private boolean lighting;
    private int watering;

    public byte getTemparature() {
        return temparature;
    }

    public void setTemparature(byte temparature) {
        this.temparature = temparature;
    }

    public boolean isLighting() {
        return lighting;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GrowingTips{");
        sb.append("temparature=").append(temparature);
        sb.append(", lighting=").append(lighting);
        sb.append(", watering=").append(watering);
        sb.append('}');
        return sb.toString();
    }
}
