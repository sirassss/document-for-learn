package design.pattern.creational.singleton;

public class Example {
}

class Singleton {
    private Singleton() {
    }

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Singleton2 {
    Singleton2() {
    }

    private static final Object lock = new Object();
    private static Singleton2 instance = null;

    public static Singleton2 getInstance() {
        synchronized (lock) {
            if (instance == null) {
                instance = new Singleton2();
            }
            return instance;
        }
    }
}