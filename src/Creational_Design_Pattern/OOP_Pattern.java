package Creational_Design_Pattern;

public class OOP_Pattern {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setHeight(2);
        dog.setName("Tommy");
        dog.printDetails();
        dog.digHole();

        //polymorphism
        Animal cat = new Cat();
        cat.setName("Pinky");
        cat.setHeight(2);
        cat.printDetails();

        Creature jiraffe = new Jiraffe();
        jiraffe.setName("Mehidy");
        jiraffe.setWeight("45kg.");
        jiraffe.printDetails();
    }
}

abstract class Creature {
    protected String name;
    protected String weight;

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getWeight();

    public abstract void setWeight(String weight);

    public void printDetails() {
        System.out.println(this.name + " is a creature. Weight is " + this.weight);
    }
}

interface Trees {
    static String child = "It can have children. ";

    String reproduction();
}

class Animal implements Trees {
    private String name;
    private double height;
    private int legs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public void printDetails() {
        System.out.println(this.name + "is an animal. It has " + this.getLegs() + " legs. " + "Height is " + this.getHeight() + " ft. " + this.reproduction());
    }

    @Override
    public String reproduction() {
        return Trees.child;
    }
}


class Dog extends Animal {
    Dog() {
        super();
        setLegs(4);
    }

    @Override
    public void setName(String name) {
        name = name + "(dog)";
        super.setName(name);
    }

    //    polymorphism
    public void digHole() {
        System.out.println(this.getName() + " can dig holes.");
    }
}

class Cat extends Animal {
    Cat() {
        super();
        setLegs(4);
    }

    @Override
    public void setName(String name) {
        name = name + "(cat)";
        super.setName(name);
    }
}

class Jiraffe extends Creature {

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(String weight) {
        this.weight = weight;
    }
}