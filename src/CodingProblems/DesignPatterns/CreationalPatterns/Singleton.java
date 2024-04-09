package CodingProblems.DesignPatterns.CreationalPatterns;

public class Singleton {
    // only one instance of its kind exists and provides a single point of access to it
    // lets you access your object from anywhere in your app
    // let's say, it can be used for database connections for example

    private static volatile Singleton instance;
    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null) {
                    instance = result = new Singleton(data);
                }
            }
        }
        return instance;
    }
}
