package Creational_Design_Pattern;

public class Singleton_Pattern {
    public static void main(String[] args) {
        Singleton singletonClass = Singleton.getSingleton();
        singletonClass.writeName();


    }
}

class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getSingleton() {
        return singleton;
    }

    public void writeName(){
        System.out.println("Singleton object called.");
    }
}
