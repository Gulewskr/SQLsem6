package gulewskr.rentcarapp.data.domain.model;

import gulewskr.rentcarapp.entities.Mark;


public class CreateModel {
    private String name;
    private long mark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }
}
