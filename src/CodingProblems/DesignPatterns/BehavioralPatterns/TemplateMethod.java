package CodingProblems.DesignPatterns.BehavioralPatterns;

public class TemplateMethod {
    public abstract class BaseGameLoader {

        public void load() {
            byte[] data = loadLocalData();
            createObjects(data);
            downloadAdditionalFiles();
            cleanTempFiles();
            initializeProfiles();
        }

        abstract byte[] loadLocalData();

        abstract void createObjects(byte[] data);

        abstract void downloadAdditionalFiles();

        abstract void initializeProfiles();

        protected void cleanTempFiles() {
            System.out.println("Cleaning temporary files...");
            // Some Common Code...
        }

    }

    public class DiabloLoader extends BaseGameLoader {

        @Override
        public byte[] loadLocalData() {
            System.out.println("Loading Diablo files...");
            // Some Diablo Code...
            return new byte[0];
        }

        @Override
        public void createObjects(byte[] data) {
            System.out.println("Creating Diablo objects...");
            // Some Diablo Code...
        }

        @Override
        public void downloadAdditionalFiles() {
            System.out.println("Downloading Diablo sounds...");
            // Some Diablo Code...
        }

        @Override
        public void initializeProfiles() {
            System.out.println("Loading Diablo profiles...");
            // Some Diablo Code...
        }
    }

    public class WorldOfWarcraftLoader extends BaseGameLoader {

        @Override
        public byte[] loadLocalData() {
            System.out.println("Loading local WoW files...");
            // Some Warcraft Code...
            return new byte[0];
        }

        @Override
        public void createObjects(byte[] data) {
            System.out.println("Creating WoW objects...");
            // Some Warcraft Code...
        }

        @Override
        public void downloadAdditionalFiles() {
            System.out.println("Downloading WoW sounds...");
            // Some Warcraft Code...
        }

        @Override
        public void initializeProfiles() {
            System.out.println("Loading WoW profiles...");
            // Some Warcraft Code...
        }

    }

    public void main(String[] args) {

        BaseGameLoader wowLoader = new WorldOfWarcraftLoader();
        wowLoader.load();

        System.out.println("==========================================");

        BaseGameLoader diabloLoader = new DiabloLoader();
        diabloLoader.load();
    }
}
