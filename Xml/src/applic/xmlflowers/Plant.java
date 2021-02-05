package applic.xmlflowers;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "soil",
        "origin",
        "visualParams",
        "growingTips",
        "multiplying",
        "datePlanted"
})
public class Plant {

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String soil;
    @XmlElement(required = true)
    private String origin;
    @XmlElement(required = true)
    private VisualParams visualParams;
    @XmlElement(required = true)
    private GrowingTips growingTips;
    @XmlElement(required = true)
    private String multiplying;
    @XmlElement(required = true)
    private Date datePlanted;
    @XmlAttribute(name = "id", required = true)
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String value) {
        this.soil = value;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String value) {
        this.origin = value;
    }

    public VisualParams getVisualParams() {
        return visualParams;
    }

    public void setVisualParams(VisualParams visualParams) {
        this.visualParams = visualParams;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public Date getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(Date datePlanted) {
        this.datePlanted = datePlanted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plant{");
        sb.append("name='").append(name).append('\'');
        sb.append(", soil='").append(soil).append('\'');
        sb.append(", origin='").append(origin).append('\'');
        sb.append(", visualParams=").append(visualParams);
        sb.append(", growingTips=").append(growingTips);
        sb.append(", multiplying='").append(multiplying).append('\'');
        sb.append(", datePlanted=").append(datePlanted);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
