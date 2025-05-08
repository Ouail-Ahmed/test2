package Sockets.exo1_2;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private int year,weight;

    public Car(String model, int year, int weight) {
        this.model = model;
        this.year = year;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                '}';
    }
}
