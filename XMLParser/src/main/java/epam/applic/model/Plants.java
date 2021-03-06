package epam.applic.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "plant"
})
public class Plants {

    protected List<Plant> plant;

    public List<Plant> getPlant() {
        if (plant == null) {
            plant = new ArrayList<>();
        }
        return this.plant;
    }

    public void setPlant(List<Plant> plant) {
        this.plant = plant;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plants{");
        sb.append("plant=").append(plant);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plants plants = (Plants) o;
        return Objects.equals(plant, plants.plant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plant);
    }
}
