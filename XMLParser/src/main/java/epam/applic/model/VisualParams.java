package epam.applic.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

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

    public VisualParams(String stalkColor, String leafColor, float averageSize) {
        this.stalkColor = stalkColor;
        this.leafColor = leafColor;
        this.averageSize = averageSize;
    }

    public VisualParams(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisualParams that = (VisualParams) o;
        return Float.compare(that.averageSize, averageSize) == 0 &&
                Objects.equals(stalkColor, that.stalkColor) &&
                Objects.equals(leafColor, that.leafColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stalkColor, leafColor, averageSize);
    }
}
