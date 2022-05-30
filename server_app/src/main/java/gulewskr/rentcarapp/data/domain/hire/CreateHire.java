package gulewskr.rentcarapp.data.domain.hire;

import gulewskr.rentcarapp.entities.Car;
import gulewskr.rentcarapp.entities.Client;

import java.sql.Date;

public class CreateHire {
    private long carID;
    private long client;
    private Date startDate;
    private Date endDate;
    private int days;
    private float price;

    public long getCar() {
        return carID;
    }

    public void setCar(long car) {
        this.carID = car;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
