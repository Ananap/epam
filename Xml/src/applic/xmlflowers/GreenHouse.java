package applic.xmlflowers;


import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "plants"
})
@XmlRootElement(name = "greenhouse")
public class GreenHouse {
    @XmlElement(required = true)
    private Plants plants;

    public Plants getPlants() {
        return plants;
    }
    public void setPlants(Plants value) {
        this.plants = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GreenHouse{");
        sb.append("plants=").append(plants);
        sb.append('}');
        return sb.toString();
    }
}
