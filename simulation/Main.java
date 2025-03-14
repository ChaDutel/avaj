package simulation;

public class Main {
    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates(1000, 50, 1500);
        Baloon balloon = new Baloon(1, "test", coordinates);
    }
}