package epam.applic.model;


import javax.xml.bind.annotation.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreenHouse that = (GreenHouse) o;
        return Objects.equals(plants, that.plants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plants);
    }
}
