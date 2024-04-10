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

    public interface Burger {// this defines the common methods that all burgers should implement
        void prepare();
    }

    public class BeefBurger implements Burger {// prepares the burger in its own way
        @Override
        public void prepare() {
            // prepare beef
            // burger code
        }
    }

    public class VeggieBurger implements Burger {// prepares the burger in its own way
        @Override
        public void prepare() {
            // prepare beef
            // burger code
        }
    }

    public abstract class Restaurant {// base class for different types of restaurants
        public Burger orderBurger(String request) {
            Burger burger = createBurger();
            burger.prepare();
            return burger;
        }

        public abstract Burger createBurger(); // the factory method and will be implemented by
        //                                        the subclasses of the restaurant class
    }

    public class BeefBurgerRestaurant extends Restaurant {// restaurant subclass

        @Override
        public Burger createBurger() {
            return new BeefBurger();
        }
    }

    public class VeggieBurgerRestaurant extends Restaurant {// restaurant subclass

        @Override
        public Burger createBurger() {
            return new VeggieBurger();
        }
    }
}
