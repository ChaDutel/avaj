package simulation;

public class Main {
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aicraftFact = AircraftFactory.getInstance();
        String[][] str = {
            {"helicopter", "test1", "50", "50", "10"},
            {"baloon", "test2", "50", "50", "10"},
            {"jetplane", "test3", "50", "50", "10"},
            {"helicopter", "test4", "50", "50", "10"},
        };
        for (String[] strings : str) {
            Coordinates coordinates = new Coordinates(Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4]));
            Flyable baloon = aicraftFact.newAircraft(strings[0], strings[1], coordinates);
            baloon.registerTower(weatherTower);
            weatherTower.register(baloon);
        }
    }
}