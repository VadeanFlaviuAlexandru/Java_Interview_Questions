package CodingProblems.DesignPatterns.CreationalPatterns;

public class TheFactory {
    // loosens the coupling of a given code by separating the product's construction code from the
    // code that uses this product
    // ------------------------------------------------------------------
    // babeste: the pattern is a way of creating objects from a superclass but the subclasses
    //          are actually the ones that define how objects are instantiated
    // ------------------------------------------------------------------
    // use this if you have no idea what exact types of the objects your code will work with
    // it makes it easy to extend the product construction code independently of the app
    // allows introducing new products without breaking existing code
    // you follow the open close principle and the single responsibility principle
    //                                       => centralizes the product creation in one place
    // the factory method relies heavily on inheritance
    // lets creator-subclasses decide which class to instantiate

    // Define an interface for all types of burgers
    public interface Burger {
        void prepare();

        String getName();

        double getPrice();
    }

    // Concrete implementation of BeefBurger
    public static class BeefBurger implements Burger {
        private final String name;
        private final double price;

        public BeefBurger(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public void prepare() {
            // Prepare beef burger
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }
    }

    // Concrete implementation of VeggieBurger
    public static class VeggieBurger implements Burger {
        private final String name;
        private final double price;

        public VeggieBurger(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public void prepare() {
            // Prepare veggie burger
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            return price;
        }
    }

    // Abstract class representing a restaurant
    public abstract static class Restaurant {
        // Method to order a burger
        public Burger orderBurger() {
            Burger burger = createBurger(); // Factory method
            burger.prepare();
            return burger;
        }

        // Factory method to create burgers
        protected abstract Burger createBurger();
    }

    // Concrete implementation of a restaurant serving beef burgers
    public static class BeefBurgerRestaurant extends Restaurant {
        @Override
        protected Burger createBurger() {
            return new BeefBurger("Beef Burger", 5.99);
        }
    }

    // Concrete implementation of a restaurant serving veggie burgers
    public static class VeggieBurgerRestaurant extends Restaurant {
        @Override
        protected Burger createBurger() {
            return new VeggieBurger("Veggie Burger", 4.99);
        }
    }

    // Customer class
    public static class Customer {
        public static void main(String[] args) {
            // Create an instance of a restaurant
            Restaurant beefBurgerRestaurant = new BeefBurgerRestaurant();

            // Order a burger from the restaurant
            Burger burger = beefBurgerRestaurant.orderBurger();

            // Print out the details of the ordered burger
            System.out.println("Ordered " + burger.getName() + " for $" + burger.getPrice());

            // Similarly, we can order from another restaurant
            Restaurant veggieBurgerRestaurant = new VeggieBurgerRestaurant();
            Burger veggieBurger = veggieBurgerRestaurant.orderBurger();
            System.out.println("Ordered " + veggieBurger.getName() + " for $" + veggieBurger.getPrice());
        }
    }
}


