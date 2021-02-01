package applic.xmlflowers;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "visual-parameters", propOrder = {
        "stalkColor",
        "leavesColor",
        "averageSize"
})
public class FlowerParameters {
    private String stalkColor;
    private String leavesColor;
    private double averageSize;

    public FlowerParameters(){}

    public FlowerParameters(String stalkColor, String leavesColor, double averageSize) {
        this.stalkColor = stalkColor;
        this.leavesColor = leavesColor;
        this.averageSize = averageSize;
    }

    public String getStalkColor() {
        return stalkColor;
    }

    public void setStalkColor(String stalkColor) {
        this.stalkColor = stalkColor;
    }

    public String getLeavesColor() {
        return leavesColor;
    }

    public void setLeavesColor(String leavesColor) {
        this.leavesColor = leavesColor;
    }

    public double getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(double averageSize) {
        this.averageSize = averageSize;
    }
}
