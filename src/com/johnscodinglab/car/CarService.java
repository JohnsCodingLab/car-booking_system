package com.johnscodinglab.car;

public class CarService {
    private CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }

    public void addCar(Car car) {
        carDAO.saveCar(car);
    }

    public void setCars(Car[] cars) {
        carDAO.setCars(cars);
    }

    public Car[] getCars() {
        return carDAO.selectAllCars();
    }

    public Car[] getElectricCars() {
        return carDAO.selectElectricCar();
    }
}
