package net.orphidian11.projects.cars.product.domain;

public class Parts {

    private Integer id;
    private String name;
    private String description;
    private PartTypes type;

    public enum PartTypes {
        ENGINE, TRANSMISSION, CHASSIS, WHEEL, GEAR_BOX, WINDOW, SEAT, TANK;
    }

    public Parts(Integer id, String name, String description, PartTypes type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.setType(type);
    }

    public PartTypes getType() {
        return type;
    }

    public void setType(PartTypes type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}