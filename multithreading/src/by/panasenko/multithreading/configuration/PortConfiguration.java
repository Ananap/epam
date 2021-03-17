package by.panasenko.multithreading.configuration;

import java.util.List;

public class PortConfiguration {
    private List<ShipConfiguration> shipConfigurationList;
    private List<PierConfiguration> pierConfigurationList;

    public PortConfiguration() { }

    public PortConfiguration(List<ShipConfiguration> shipConfigurationList, List<PierConfiguration> pierConfigurationList) {
        this.shipConfigurationList = shipConfigurationList;
        this.pierConfigurationList = pierConfigurationList;
    }

    public List<ShipConfiguration> getShipConfigurationList() {
        return shipConfigurationList;
    }

    public void setShipConfigurationList(List<ShipConfiguration> shipConfigurationList) {
        this.shipConfigurationList = shipConfigurationList;
    }

    public List<PierConfiguration> getPierConfigurationList() {
        return pierConfigurationList;
    }

    public void setPierConfigurationList(List<PierConfiguration> pierConfigurationList) {
        this.pierConfigurationList = pierConfigurationList;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PortConfiguration{");
        sb.append("shipConfigurationList=").append(shipConfigurationList);
        sb.append(", pierConfigurationList=").append(pierConfigurationList);
        sb.append('}');
        return sb.toString();
    }
}
