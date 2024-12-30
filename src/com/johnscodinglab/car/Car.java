package com.johnscodinglab.car;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {
    private String plateNumber;
    private Brand brand;
    private String model;
    private String color;
    private BigDecimal rentalPricePerDay;
    private boolean isElectric;

    public Car() {
    }

    public Car(
            String plateNumber,
            Brand brand,
            String model,
            String color,
            BigDecimal rentalPricePerDay,
            boolean isElectric) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.rentalPricePerDay = rentalPricePerDay;
        this.isElectric = isElectric;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(BigDecimal rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "Car{" +
                "plateNumber='" + plateNumber + '\'' +
                "brand=" + brand +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", rentalPricePerDay='" + rentalPricePerDay + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return isElectric == car.isElectric && Objects.equals(plateNumber, car.plateNumber) && brand == car.brand && Objects.equals(model, car.model) && Objects.equals(color, car.color) && Objects.equals(rentalPricePerDay, car.rentalPricePerDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, brand, model, color, rentalPricePerDay, isElectric);
    }
}
