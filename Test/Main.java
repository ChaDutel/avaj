enum Level {
  LOW,
  MEDIUM,
  HIGH
}

abstract class Animal {
    public abstract void animalSound();
    public void sleep() {
        System.out.println("Zzz");
    }
}

class Cat extends Animal {
    public void animalSound() {
        System.out.println("Miaouuuuuu");
    }
}


class Vehicule {
    protected String brand = "Ferrari";
    public void honk() {
        System.out.println("honk honk !");
    }
}

class Car extends Vehicule {
    private String modelName = "Lamborghini";
    public static void main(String[] args) {
        Car myCar = new Car();

        myCar.honk();

        System.out.println(myCar.brand + " " + myCar.modelName);
    }
}

public class Main {

    private int touuut = 315;
    int modelYear;
    String modelName;

    public int getTouut() {
        return touuut;
    }

    static void myMethod(String tt) {
        System.out.println("Static methods can be called without creating objects");
        String text = "Bouh you !";
        System.out.println(text.indexOf("yo"));
        int time = 20;
        String result = (time < 18) ? "Good day." : "Good evening.";
        int[] myNum = {10, 20, 30, 40};
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        System.out.println(cars[0]);
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        myNumbers[1][2] = 9;
    }

    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }

    public Main(int year, String name)
    {
        modelYear = year;
        modelName = name;
    }
    public Main() {}

    public static void main(String[] args) {
        final int i = 15, y, z;
        y = z = 50;
        boolean answer = true;
        System.out.println("Hello World!" + z + answer);
        myMethod("lol");
        
        Main myCar = new Main(2005, "sis");
        System.out.println(myCar.modelYear + " " + myCar.modelName);
        Main mymain = new Main();
        System.out.println(mymain.touuut + mymain.modelName);
        mymain.myPublicMethod();
        System.out.println(mymain.getTouut());
        // classes :
            // final	The class cannot be inherited by other classes
            // abstract	The class cannot be used to create objects
                // (To access an abstract class, it must be inherited from another class
        // attribtes methods
            // final (const)	Attributes and methods cannot be overridden/modified
            // static	Attributes and methods belongs to the class, rather than an object
            // transient	Attributes and methods are skipped when serializing the object containing them
            // synchronized	Methods can only be accessed by one thread at a time
            // volatile	The value of an attribute is not cached thread-locally, and is always read from the "main memory"
            // abstract	Can only be used in an abstract class, and can only be used on methods.
                // The method does not have a body, for example abstract void run();.
                // The body is provided by the subclass (inherited from)
        // To inherit from a class, use the extends keyword.
        // An interface is a completely "abstract class" that is used to group related methods with empty bodies:
        Car car = new Car();
        car.honk();
        Vehicule vv = new Vehicule();
        vv.honk();
        Cat kitty = new Cat();
        kitty.animalSound();
        kitty.sleep();
    }
}