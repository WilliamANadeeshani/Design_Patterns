package Creational_Design_Pattern;

//*Interfaces hierarchy*/
interface Fly {
    String fly();
}

public class Strategy_Pattern {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle car = new Car();
        plane.printDetails();
        car.printDetails();
    }

}

/*Creational_Design_Pattern.Vehicle Hierarchy*/
class Vehicle {
    private int wheels;
    private String type;
    private Fly flyingType;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String tryToFly() {
        return this.flyingType.fly();
    }

    public void setFlyingType(Fly flyingType) {
        this.flyingType = flyingType;
    }

    public void printDetails() {
        System.out.println(this.getType() + " has " + this.getWheels() + " wheels. " + this.tryToFly());
    }
}

class Car extends Vehicle {
    Car() {
        this.setWheels(4);
        this.setType("Creational_Design_Pattern.Car");
        this.setFlyingType(new isntFly());
    }


}

class Plane extends Vehicle {
    Plane() {
        this.setWheels(3);
        this.setType("Creational_Design_Pattern.Plane");
        this.setFlyingType(new isFly());
    }
}

class isFly implements Fly {
    @Override
    public String fly() {
        return "It can Creational_Design_Pattern.Fly";
    }
}

class isntFly implements Fly {
    @Override
    public String fly() {
        return "It can't fly.";
    }
}