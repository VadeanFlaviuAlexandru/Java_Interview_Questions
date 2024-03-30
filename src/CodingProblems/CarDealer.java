package CodingProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarDealer {

    abstract class Car {
        int engineID;
        String brand;
        int year;
        int price;
        boolean isSold;

        Car(int engineID, String brand, int year, int price, boolean isSold) {
            this.engineID = engineID;
            this.brand = brand;
            this.year = year;
            this.price = price;
            this.isSold = isSold;
        }

        public boolean markSold() {
            return isSold = true;
        }
    }

    class CompactCar extends Car {
        int passengersNumber;

        CompactCar(int engineID, String brand, int year, int price, int passengersNumber, boolean isSold) {
            super(engineID, brand, year, price, isSold);
            this.passengersNumber = passengersNumber;
        }
    }

    class LuxuryCar extends Car {
        int passengersNumber;

        LuxuryCar(int engineID, String brand, int year, int price, int passengersNumber, boolean isSold) {
            super(engineID, brand, year, price, isSold);
            this.passengersNumber = passengersNumber;
        }
    }

    class Truck extends Car {
        int capacity;
        int numberOfAxes;
        int numberOfWheels;

        Truck(int engineID, String brand, int year, int price, int capacity, int numberOfAxes, int numberOfWheels, boolean isSold) {
            super(engineID, brand, year, price, isSold);
            this.capacity = capacity;
            this.numberOfAxes = numberOfAxes;
            this.numberOfWheels = numberOfWheels;
        }
    }

    class Wagon extends Car {
        int passengersNumber;

        Wagon(int engineID, String brand, int year, int price, int passengersNumber, boolean isSold) {
            super(engineID, brand, year, price, isSold);
            this.passengersNumber = passengersNumber;
        }
    }

    class Dealer {
        List<Car> cars;

        Dealer() {
            this.cars = new ArrayList<>();
        }

        public void addCar(Car car) {
            cars.add(car);
        }

        public List<Car> getCarsByCategory(String category) {
            return cars.stream()
                    .filter(car -> {
                        if (category.equalsIgnoreCase("compact") && car instanceof CompactCar) {
                            return true;
                        } else if (category.equalsIgnoreCase("luxury") && car instanceof LuxuryCar) {
                            return true;
                        } else if (category.equalsIgnoreCase("truck") && car instanceof Truck) {
                            return true;
                        } else return category.equalsIgnoreCase("wagon") && car instanceof Wagon;
                    })
                    .collect(Collectors.toList());
        }

        public List<Car> getCarsBySpecifications(int passengers, int capacity, int axes) {
            return cars.stream()
                    .filter(car -> {
                        if (car instanceof CompactCar || car instanceof LuxuryCar || car instanceof Wagon) {
                            return ((CompactCar) car).passengersNumber == passengers;
                        } else {
                            return ((Truck) car).capacity == capacity && ((Truck) car).numberOfAxes == axes;
                        }
                    })
                    .collect(Collectors.toList());
        }

        public void markCarAsSold(int engineID) {
            cars.stream()
                    .filter(car -> car.engineID == engineID)
                    .findFirst()
                    .ifPresent(Car::markSold);
        }
    }

    public static void main(String[] args) {
        CarDealer dealer = new CarDealer();
        CarDealer.Dealer carDealer = dealer.new Dealer(); // Creating an instance of the Dealer class

        // Adding cars
        carDealer.addCar(dealer.new CompactCar(1, "Toyota", 2020, 20000, 4, false));
        carDealer.addCar(dealer.new LuxuryCar(2, "BMW", 2019, 50000, 4, false));
        carDealer.addCar(dealer.new Truck(3, "Ford", 2018, 40000, 5000, 2, 6, false));
        carDealer.addCar(dealer.new Wagon(4, "Subaru", 2021, 30000, 7, false));

        // Marking a car as sold
        carDealer.markCarAsSold(1);

        // Example of querying cars by category
        List<CarDealer.Car> compactCars = carDealer.getCarsByCategory("compact");
        System.out.println("Compact Cars:");
        for (CarDealer.Car car : compactCars) {
            System.out.println(car.brand);
        }

        // Example of querying cars by specifications
        List<CarDealer.Car> specificCars = carDealer.getCarsBySpecifications(4, 0, 0);
        System.out.println("\nCars with 4 Passengers:");
        for (CarDealer.Car car : specificCars) {
            System.out.println(car.brand);
        }
    }
}
