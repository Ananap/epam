package applic.xmlflowers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "stalkColor",
        "leafColor",
        "averageSize"
})
public class VisualParams {

    @XmlElement(required = true)
    private String stalkColor;
    @XmlElement(required = true)
    private String leafColor;
    private float averageSize;

    public String getStalkColor() {
        return stalkColor;
    }

    public void setStalkColor(String stalkColor) {
        this.stalkColor = stalkColor;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public float getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(float averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VisualParams{");
        sb.append("stalkColor='").append(stalkColor).append('\'');
        sb.append(", leafColor='").append(leafColor).append('\'');
        sb.append(", averageSize=").append(averageSize);
        sb.append('}');
        return sb.toString();
    }
}
