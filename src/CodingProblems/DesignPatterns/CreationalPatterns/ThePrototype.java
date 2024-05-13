package CodingProblems.DesignPatterns.CreationalPatterns;

public class ThePrototype {
    // entrusts the object duplication or cloning process to the actual objects that are being cloned
    // to start, we need to declare a common interface for all objects that support cloning
    // usually, this contains one method that creates a new object of the class and copies all the
    // fields of the old object into the new one (so doing this we have access to private fields

    public interface Prototype {
        Car clone();
    }

    public class Car implements Prototype {

        private String information;

        public Car() {
        }

        public Car(Car car) {
            //super(car) if this "Car" was a subclass
            this.information = car.information;
        }

        @Override
        public Car clone() {
            return new Car(this);
        }
    }

    //---------------------------------- now let's say that the car is extending another class

//    public abstract class Vehicle {
//        private String brand;
//        //and other info
//
//        protected Vehicle(Vehicle vehicle) {
//            this.brand = vehicle.brand;
//        }
//
//        //move the clone from interface to this;
//        public abstract Vehicle clone();
//    }
//
//    public class Car extends Vehicle {
//
//        private String information;
//
//        public Car() {
//        }
//
//        public Car(Car car) {
//            super(car);
//            this.information = car.information;
//        }
//
//        @Override
//        public Car clone() {
//            return new Car(this);
//        }
//    }

    // sometimes we need a prototype registry, which stores frequently accessed prototypes.
    // make a new hashmap and put the value you premade:        .put("buggati", car);
    // and just get what you want when you want:                .get(key).clone();

}

