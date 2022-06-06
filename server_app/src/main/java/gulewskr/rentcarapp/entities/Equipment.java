package gulewskr.rentcarapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "Equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String shortname;

    @Column
    private String description;

    @Column
    private float price;

    @Column
    private float priceCoeff;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceCoeff() {
        return priceCoeff;
    }

    public void setPriceCoeff(float priceCoeff) {
        this.priceCoeff = priceCoeff;
    }
}
