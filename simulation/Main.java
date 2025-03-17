package simulation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    static boolean parsing(String[] args) {
        if (args.length != 2)
        {
            System.err.println("The program takes one and only one argument from the command line");
            return false;
        }
        Path configPath = Paths.get(args[1]);
        if (!Files.exists(configPath))
        {
            System.err.println("File does not exist");
            return false;
        }
        if (!Files.isRegularFile(configPath))
        {
            System.err.println(args[1] + "Not a regular file");
            return false;
        }
        try {
            // String content = Files.readString(configPath);
            List<String> content = Files.readAllLines(configPath);
            if (content.isEmpty() || !content.get(0).trim().matches("^\\d+$")) {
                System.err.println("Error: First line must contain exactly one number");
                return false;
            }
            List<String> ids = null;
            for (String line : content) {
                String[] lineTab = line.split("\\s+");
                if (lineTab.length != 5)
                {
                    System.err.println("Error: Excepected 5 arguments, got " + lineTab.length);
                    return false;
                }
                if (lineTab[0] != "Baloon" || lineTab[0] != "JetPlane" || lineTab[0] != "Helicopter")
                {
                    System.err.println("Error: Invalid vehicule type " + lineTab[0]);
                    return false;
                }
                if (ids.isEmpty() || !ids.contains(lineTab[1]))
                    ids.add(lineTab[1]);
                else
                {
                    System.err.printf("Error Duplicate ID " + lineTab[1]);
                    return false;
                }
                try
                {
                    int num2 = Integer.parseInt(lineTab[2]);
                    int num3 = Integer.parseInt(lineTab[3]);
                    int num4 = Integer.parseInt(lineTab[4]);

                    if (num2 < 0 || num2 > 99)
                    {
                        System.err.println("Error: Invalid height value");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: latitude, longitude and height must be numbers");
                    return false;
                }
            }
        }
        catch (Exception e)
        {
            System.err.println(("Error reading file" + e.getMessage()));
        }
        return true;
    }
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aicraftFact = AircraftFactory.getInstance();

        if (parsing(args) == false)
            return ;
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
        int n = 10;
        for (int i = 0; i < n; i++) {
            weatherTower.changeWeather();
        }
    }
}