package simulation;

public class Main {
    public static void main(String[] args) {
        Coordinates coordinates = new Coordinates(1000, 50, 1500);
        AircraftFactory aicraftFact = AircraftFactory.getInstance();
        Flyable baloon = aicraftFact.newAircraft("helicopter", "Test-Baloon", coordinates);
    }
}