package net.orphidian11.projects.cars.product.domain;

import java.util.Date;

public class Product {

    private Integer id; // product_id
    private String name;
    private String description;
    private Integer createdById;
    private Date createdByDate;
    private Integer lastUpdateById;
    private Date lastUpdateByDate;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(String name, String description, Integer createdById, Date createdByDate) {
        this.name = name;
        this.description = description;
        this.createdById = createdById;
        this.createdByDate = createdByDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Integer createdById) {
        this.createdById = createdById;
    }

    public Date getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(Date createdByDate) {
        this.createdByDate = createdByDate;
    }

    public Integer getLastUpdateById() {
        return lastUpdateById;
    }

    public void setLastUpdateById(Integer lastUpdateById) {
        this.lastUpdateById = lastUpdateById;
    }

    public Date getLastUpdateByDate() {
        return lastUpdateByDate;
    }

    public void setLastUpdateByDate(Date lastUpdateByDate) {
        this.lastUpdateByDate = lastUpdateByDate;
    }
}
