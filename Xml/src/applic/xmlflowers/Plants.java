package applic.xmlflowers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "plant"
})
public class Plants {

    protected List<Plant> plant;

    public List<Plant> getPlant() {
        if (plant == null) {
            plant = new ArrayList<Plant>();
        }
        return this.plant;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plants{");
        sb.append("plant=").append(plant);
        sb.append('}');
        return sb.toString();
    }
}
