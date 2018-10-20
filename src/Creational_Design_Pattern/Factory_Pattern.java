package Creational_Design_Pattern;

public class Factory_Pattern {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("circle");
        shapeFactory.getShape("Creational_Design_Pattern.Square");
    }

}

/*Factory class*/
class ShapeFactory {
    Shape getShape(String shapeType){
        if (shapeType == null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("TRIANGLE")){
            return new Triangle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Circle();
        }else{
            return null;
        }
    }
}

/*products*/
interface Shape{
    void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Created new Creational_Design_Pattern.Circle.");
    }
}

class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("Created new Creational_Design_Pattern.Square");
    }
}

class Triangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Created new Creational_Design_Pattern.Triangle");
    }
}