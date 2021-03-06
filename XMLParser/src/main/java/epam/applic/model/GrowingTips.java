package epam.applic.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
public class GrowingTips {

    private byte temparature;
    private boolean lighting;
    private int watering;

    public GrowingTips(byte temparature, boolean lighting, int watering) {
        this.temparature = temparature;
        this.lighting = lighting;
        this.watering = watering;
    }
    public GrowingTips(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowingTips that = (GrowingTips) o;
        return temparature == that.temparature &&
                lighting == that.lighting &&
                watering == that.watering;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temparature, lighting, watering);
    }
}
