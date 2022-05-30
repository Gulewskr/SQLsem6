package gulewskr.rentcarapp.data.domain.equipement;

public class CreateEquipement {
    private String name;
    private String shortname;
    private String description;
    private float price;
    private float priceCoeff;

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
