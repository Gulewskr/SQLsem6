package gulewskr.rentcarapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Model model;

    @OneToMany
    private List<Equipment> equipementList;

    @Column
    private int yearCar;

    @Column
    private String plate;

    @Column
    private String color;

    @Column
    private float basicPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public List<Equipment> getEquipementList() {
        return equipementList;
    }

    public void setEquipementList(List<Equipment> equipementList) {
        this.equipementList = equipementList;
    }

    public int getYearCar() {
        return yearCar;
    }

    public void setYearCar(int yearCar) {
        this.yearCar = yearCar;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(float basicPrice) {
        this.basicPrice = basicPrice;
    }
}
