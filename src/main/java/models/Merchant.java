package models;

import java.util.Objects;

public class Merchant implements Comparable<Merchant>{
    private int id;
    private String name;
    private Float distance;

    public Merchant(int id, String name, Float distance) {
        this.id = id;
        this.name = name;
        this.distance = distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }

    @Override
    public int compareTo(Merchant merchant) {
        if(Objects.equals(this.distance, merchant.getDistance())) return 0;
        if(this.distance > merchant.getDistance()) return 1;
        return -1;
    }
}
