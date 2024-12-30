package com.johnscodinglab;

import com.johnscodinglab.bookings.BookingService;
import com.johnscodinglab.bookings.Bookings;
import com.johnscodinglab.car.Brand;
import com.johnscodinglab.car.Car;
import com.johnscodinglab.car.CarService;
import com.johnscodinglab.user.User;
import com.johnscodinglab.user.UserService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CarService carService = new CarService();
    private static UserService userService = new UserService();
    private static BookingService bookingService = new BookingService();

    public static void main(String[] args) {

//      User function options
        String[] options = {
                "1️⃣ - Book car",
                "2️⃣ - View all user booked cars",
                "3️⃣ - View all bookings",
                "4️⃣ - View available cars",
                "5️⃣ - View all electric cars",
                "6️⃣ - View all users",
                "7️⃣ - Exit"
        };

        getUserService();
        getCarService();


        while (true) {
            for (String option : options) {
                System.out.println(option);
            }

            System.out.println();


            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    bookCar();
                    System.out.println();
                    break;
                case "2":
                    viewAllUserBookedCars();
                    System.out.println();
                    break;
                case "3":
                    viewAllBookings();
                    System.out.println();
                    break;
                case "4":
                    viewAllAvailableCars();
                    System.out.println();
                    break;
                case "5":
                    viewAllAvailableElectricCars();
                    System.out.println();
                    break;
                case "6":
                    viewAllUsers();
                    System.out.println();
                    break;
                case "7":
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println(input + " is not a valid option ❌");
                    System.out.println();
                    System.out.println();
                    break;
            }

            // Check for case "7" and break the while loop
            if (input.equals("7")) {
                break; // Exits the while loop
            }
        }
    }

    //    create and save users
    private static void getUserService() {
        User dave = new User("Dave", "John");
        User isaac = new User("isaac", "Levi");

//      Save user
        userService.addUser(dave);
        userService.addUser(isaac);
    }

    //    create and save cars
    private static void getCarService() {
        Car tesla = new Car(
                "1234",
                Brand.TESLA,
                "model-x",
                "black",
                BigDecimal.TEN,
                true);

        Car honda = new Car(
                "5432",
                Brand.HONDA,
                "accord",
                "green",
                BigDecimal.TWO,
                false);

        Car lexus = new Car(
                "5462",
                Brand.LEXUS,
                "nx300",
                "white",
                BigDecimal.TWO,
                true);

//        Save cars
        carService.addCar(tesla);
        carService.addCar(honda);
        carService.addCar(lexus);
    }

    //    View all users
    private static void viewAllUsers() {
        if (userService.getUsers().length != 0) {
            for (User user : userService.getUsers()) {
                if (user != null) {
                    System.out.println(user);
                }
            }
        } else {
            System.out.println("No user found");
        }
    }

    //    View all cars
    private static void viewAllAvailableCars() {
        CarService carService = new CarService();
        if (carService.getCars().length != 0) {
            for (Car car : carService.getCars()) {
                if (car != null) {
                    System.out.println(car);
                }
            }
        } else {
            System.out.println("❌ No car found");
        }
    }

    //    View all electric cars
    private static void viewAllAvailableElectricCars() {
        CarService carService = new CarService();
        for (Car car : carService.getElectricCars()) {
            if (car != null) {
                System.out.println(car);
            }
        }
    }

    //    view all bookings
    private static void viewAllBookings() {
        if (bookingService.getAllBooking().length != 0) {
            for (Bookings booking : bookingService.getAllBooking()) {
                if (booking != null) {
                    System.out.println(booking);
                }
            }
        } else {
            System.out.println("❌ No booking found");
        }
    }

    //    view all user booked cars
    private static void viewAllUserBookedCars() {
        viewAllUsers();
        System.out.println("➡️ select user id");
        String input = scanner.nextLine();
        Bookings userBooking = bookingService.getUserBooking(input);
        if (userBooking != null) {
            System.out.println("This user has no car booked");
        } else {
            System.out.println(userBooking);
        }
    }

    //    book cars
    private static void bookCar() {
        while (true) {
            viewAllAvailableCars();
            System.out.println("Select car plate number");
            String plateNumber = scanner.nextLine();
            if (plateNumber.isEmpty()) {
                System.out.println("Please enter a plate number");
                break;
            }
            Car userCar = getCarByPlateNumber(plateNumber);
            if (userCar == null) {
                break;
            }
            System.out.println();
            viewAllUsers();
            System.out.println("Select user Id");
            String userId = scanner.nextLine();
            if (userId.isEmpty()) {
                System.out.println("Please enter a user id");
                break;
            }
            User user = getUserById(userId);
            if (user == null) {
                break;
            }

            Bookings userBooking = new Bookings(user, userCar, false);
            bookingService.addBooking(userBooking);

//                Remove the car from the list of car array
            Car[] newCars = new Car[carService.getCars().length - 1];
            int j = 0;
            for (int i = 0; i < carService.getCars().length; i++) {
                if (carService.getCars()[i] != null) {
                    if (!carService.getCars()[i].getPlateNumber().equals(plateNumber)) {
                        newCars[j] = carService.getCars()[i];
                        j++;
                    }
                }
            }
            carService.setCars(newCars);
            break;
        }
    }

    //    get car by plate number
    private static Car getCarByPlateNumber(String plateNumber) {
        for (Car car : carService.getCars()) {
            if (car != null && plateNumber.equals(car.getPlateNumber())) {
                return car;
            }
        }
        System.out.println("Invalid Plate number");
        return null;
    }

    //    get user by id
    private static User getUserById(String userId) {
        for (User user : userService.getUsers()) {
            if (user != null && userId.equals(user.getID())) {
                return user;
            }
        }
        System.out.println("Invalid User Id");
        return null;
    }
}