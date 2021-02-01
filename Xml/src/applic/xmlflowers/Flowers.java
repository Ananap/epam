package applic.xmlflowers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Flowers {
    @XmlElement(name = "flower")
    private List<Flower> flowers = new ArrayList<>();

    public Flowers(){
        super();
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public boolean add(Flower flower) {
        return flowers.add(flower);
    }
}
