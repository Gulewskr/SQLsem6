package gulewskr.rentcarapp.data.domain.car;

import gulewskr.rentcarapp.entities.Equipment;
import gulewskr.rentcarapp.entities.Model;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public class CreateCar {
    private int modelD;
    private List<Integer> equipementList;
    private int yearCar;
    private String plate;
    private String color;
    private float basicPrice;

    public int getModel() {
        return modelD;
    }

    public void setModel(int model) {
        this.modelD = model;
    }

    public List<Integer> getEquipementList() {
        return equipementList;
    }

    public void setEquipementList(List<Integer> equipementList) {
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
