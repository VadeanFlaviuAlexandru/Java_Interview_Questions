package CodingProblems.DesignPatterns.BehavioralPatterns;

public class TheStatePattern {
    // can be considered as an extension of strategy as both patterns are based on composition
    // states can be dependent as you can easily jump from one state to another
    // the state is about doing different things on the state(the result may vary)
    // strategies are completely independent and unaware of each other
    // strategies are about having different implementations that accomplish the same thing

    public class Phone {

        private State state;

        public Phone() {
            state = new OffState(this);
        }

        public void setState(State state) {
            this.state = state;
        }

        public String lock() {
            return "Locking phone and turning off the screen";
        }

        public String home() {
            return "Going to home-screen";
        }

        public String unlock() {
            return "Unlocking the phone to home";
        }

        public String turnOn() {
            return "Turning screen on, device still locked";
        }

        public String clickHome() {
            return state.onHome();
        }

        public String clickPower() {
            return state.onOffOn();
        }

    }

    public abstract class State {

        protected Phone phone;

        public State(Phone phone) {
            this.phone = phone;
        }

        public abstract String onHome();

        public abstract String onOffOn();

    }

    public class ReadyState extends State {

        public ReadyState(Phone phone) {
            super(phone);
        }

        @Override
        public String onHome() {
            return phone.home();
        }

        @Override
        public String onOffOn() {
            phone.setState(new OffState(phone));
            return phone.lock();
        }

    }

    public class OffState extends State {

        public OffState(Phone phone) {
            super(phone);
        }

        @Override
        public String onHome() {
            phone.setState(new LockedState(phone));
            return phone.turnOn();
        }

        @Override
        public String onOffOn() {
            phone.setState(new LockedState(phone));
            return phone.turnOn();
        }

    }

    public class LockedState extends State {

        public LockedState(Phone phone) {
            super(phone);
        }

        @Override
        public String onHome() {
            phone.setState(new ReadyState(phone));
            return phone.unlock();
        }

        @Override
        public String onOffOn() {
            phone.setState(new OffState(phone));
            return phone.lock();
        }

    }

    public void main(String[] args) {

        Phone phone = new Phone();
        simulatePhoneClicks(phone);

    }

    private static void simulatePhoneClicks(Phone phone) {
        System.out.println(phone.clickPower());
        System.out.println(phone.clickPower());
        System.out.println(phone.clickHome());
        System.out.println(phone.clickHome());
        System.out.println(phone.clickHome());
        System.out.println(phone.clickPower());
        System.out.println(phone.clickPower());
        System.out.println(phone.clickHome());
    }
}
