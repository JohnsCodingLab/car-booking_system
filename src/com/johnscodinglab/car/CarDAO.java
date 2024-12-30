package com.johnscodinglab.car;

public class CarDAO {
    private static Car[] cars;
    private static int carsInGarage = 0;

    public static final int GARAGE_CAPACITY = 100;

    static {
        cars = new Car[GARAGE_CAPACITY];
    }

    public void saveCar(Car car) {
        if (carsInGarage >= GARAGE_CAPACITY) {
            // do something
            System.out.println("Not enough space available");
        }
        cars[carsInGarage++] = car;
    }

    public void setCars(Car[] car) {
        cars = car;
    }

    public Car[] selectAllCars() {
        return cars;
    }

    public Car[] selectElectricCar() {
        int numberOfElectricCars = 0;
        Car[] electricCars = new Car[GARAGE_CAPACITY];
        for (Car car : cars) {
            if (car != null && car.isElectric()) {
                electricCars[numberOfElectricCars++] = car;
            }
        }
        return electricCars;
    }
}
