package CodingProblems.DesignPatterns.BehavioralPatterns;

public class CommandPattern {
    // turns a request or a behavior into a stand-alone object that contains
    // everything about that request. encapsulates all the relevant information
    // needed to perform an action or trigger an event

    public abstract class Component {

        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void executeCommand() {
            command.execute();
        }

    }

    public class Curtains {

        private boolean open = false;

        public void openClose() {
            open = !open;
        }

        public boolean isOpen() {
            return open;
        }

    }

    public class FloorLamp extends Component {

        private final Light light;

        public FloorLamp() {
            this.light = new Light();
        }

        public Light getLight() {
            return light;
        }

        public boolean isLightOn() {
            return light.isSwitchedOn();
        }

    }

    public class Light {

        private boolean switchedOn = false;

        public void switchLights() {
            switchedOn = !switchedOn;
        }

        public boolean isSwitchedOn() {
            return switchedOn;
        }

    }

    public class Room extends Component {

        private final Curtains curtains;

        public Room() {
            this.curtains = new Curtains();
        }

        public Curtains getCurtains() {
            return curtains;
        }

        public boolean curtainsOpen() {
            return curtains.isOpen();
        }

    }

    public interface Command {

        void execute();

    }

    public record OpenCloseCurtainsCommand(Curtains curtains) implements Command {

        @Override
        public void execute() {
            curtains.openClose();
        }

    }

    public record SwitchLightsCommand(Light light) implements Command {

        @Override
        public void execute() {
            light.switchLights();
        }

    }

    public void main(String[] args) {

        Room room = new Room();
        room.setCommand(new OpenCloseCurtainsCommand(room.getCurtains()));
        room.executeCommand();
        System.out.println(room.curtainsOpen());

        System.out.println("==========================================");

        FloorLamp lamp = new FloorLamp();
        lamp.setCommand(new SwitchLightsCommand(lamp.getLight()));
        lamp.executeCommand();
        System.out.println(lamp.isLightOn());

    }

}