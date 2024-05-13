package CodingProblems.DesignPatterns.CreationalPatterns;

public class TheBuilder {
    // create complex objects on a step by step basis
    // sometimes we may not need to fill all the constructor parameters

    public class Director { // optional, kind of like presets

        public void buildBugatti(Builder builder) {
            builder.brand("Bugatti").color("Blue").nbrOfDoors(2).engine("8L").height(115);
        }

        public void buildLambo(Builder builder) {
            builder.brand("Lamborghini").model("Aventador").color("Yellow").height(120);
        }

    } // optional, kind of like presets

    public class Car {

        private final int id;
        private final int height;
        private final String brand;
        private final String model;
        private final String color;
        private final String engine;
        private final int nbrOfDoors;

        Car(int id, String brand, String model, String color, int height, String engine, int nbrOfDoors) {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.color = color;
            this.height = height;
            this.engine = engine;
            this.nbrOfDoors = nbrOfDoors;
        }
    } // so a 'builder' we have a class with fields and a constructor. thats it.

    public interface Builder {

        Builder id(int id);

        Builder brand(String brand);

        Builder model(String model);

        Builder color(String color);

        Builder height(int height);

        Builder engine(String engine);

        Builder nbrOfDoors(int nbrOfDoors);

    } // and we have an interface called Builder that has multiple constructors for each field.

    public class CarBuilder implements Builder {

        private int id;
        private int height;
        private String brand;
        private String model;
        private String color;
        private String engine;
        private int nbrOfDoors;

        @Override
        public CarBuilder id(int id) {
            this.id = id;
            return this;
        }

        @Override
        public CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        @Override
        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        @Override
        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        @Override
        public CarBuilder height(int height) {
            this.height = height;
            return this;
        }

        @Override
        public CarBuilder engine(String engine) {
            this.engine = engine;
            return this;
        }

        @Override
        public CarBuilder nbrOfDoors(int nbrOfDoors) {
            this.nbrOfDoors = nbrOfDoors;
            return this;
        }

        public Car build() {
            return new Car(id, brand, model, color, height, engine, nbrOfDoors);
        }
    } // and finally we have a car builder (so a class builder) that we pass each field we want, ending with .build

    //    Director director = new Director();
    //
    //    CarBuilder builder = new CarBuilder();
    //    director.buildBugatti(builder);
    //    builder.model("Chiron");
    //    System.out.println(builder.build());
}
