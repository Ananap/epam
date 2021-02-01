package applic.xmlflowers;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Student", propOrder = {
        "name",
        "soil",
        "datePlanted",
        "visualParameters"
})
public class Flower {
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    private Integer id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private Soil soil;
    @XmlElement(required = true)
    private LocalDate datePlanted;
    @XmlElement(required = true)
    private GrowingTips growingTips;
    @XmlElement
    private String origin;
    @XmlElement(required = true, name = "visual-parameters")
    private FlowerParameters visualParameters;

    public Flower(){}

    public Flower(String name, Soil soil, String origin, FlowerParameters visualParameters) {
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.visualParameters = visualParameters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public FlowerParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(FlowerParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public LocalDate getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(LocalDate datePlanted) {
        this.datePlanted = datePlanted;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }
}
