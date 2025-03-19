package simulation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static String[][] str = new String[0][];
    static int simulationNumber;

    public static class InputFileException extends Exception {
        public InputFileException(String message) {
            super(message);
        }
    }

    static boolean getAndCheckFile(String[] args) throws InputFileException {
        Path configPath = Paths.get(args[0]);
        if (!Files.exists(configPath))
            throw new InputFileException("File does not exist");
        if (!Files.isRegularFile(configPath))
            throw new InputFileException(args[1] + "Not a regular file");
        try {
            List<String> content = Files.readAllLines(configPath);
            if (content.isEmpty() || !content.get(0).trim().matches("^\\d+$"))
                throw new InputFileException("Error: First line must contain exactly one positive number");
            List<String> ids = new ArrayList<>();
            boolean firstLoop = true;
            int i = 0;
            str = Arrays.copyOf(str, content.size() - 1);
            for (String line : content) {
                if (firstLoop)
                {
                    simulationNumber = Integer.parseInt(line);
                    firstLoop = false;
                    continue;
                }
                String[] lineTab = line.split("\\s+");
                if (!line.isEmpty())
                {
                    str[i] = lineTab;
                }
                if (line.isEmpty())
                    continue;
                if (lineTab.length != 5)
                    throw new InputFileException("Error: Excepected 5 arguments, got " + lineTab.length);
                if (!lineTab[0].contains("Baloon") && !lineTab[0].contains("JetPlane") && !lineTab[0].contains("Helicopter"))
                    throw new InputFileException("Error: Invalid vehicule type " + lineTab[0]);
                if (!ids.contains(lineTab[1]))
                    ids.add(lineTab[1]);
                else
                    throw new InputFileException("Error Duplicate NAME-ID " + lineTab[1]);
                try
                {
                    int num2 = Integer.parseInt(lineTab[2]);
                    int num3 = Integer.parseInt(lineTab[3]);
                    int num4 = Integer.parseInt(lineTab[4]);

                    if (num2 < 0 || num3 < 0 || num4 < 0)
                        throw new InputFileException("Error: longitude, latitude and height must be positive numbers: \"" + lineTab[0] + " " + lineTab[1] + "\"");
                    if (num4 == 0)
                        throw new InputFileException("Error: the height must be 1 minimum to lanch the simulation for \"" + lineTab[0] + " " + lineTab[1] + "\"");
                    if (num4 > 100)
                        throw new InputFileException("Error: Invalid height value: " + lineTab[4] + " for \"" + lineTab[0] + " " + lineTab[1] + "\". The height is in the 0-100 range");
                } catch (NumberFormatException e) {
                    throw new InputFileException("Error: latitude, longitude and height must be numbers " + e.getMessage());
                }
                i++;
            }
        }
        catch (Exception e)
        {
            throw new InputFileException(e.getMessage());
        }
        return true;
    }
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();
        AircraftFactory aicraftFact = AircraftFactory.getInstance();
        
        try {
            if (args.length != 1)
            {
                System.err.println("The program takes one and only one argument from the command line");
                return ;
            }
            if (getAndCheckFile(args) == false)
            return ;
        }
        catch (InputFileException e)
        {
            System.err.println(e.getMessage());
            return ;
        }
        try {
            Print.initSimulationFile();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return ;
        }
        for (String[] strings : str) {
            if (strings == null)
                continue;
            try 
            {
                Coordinates coordinates = new Coordinates(Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4]));
                Flyable flyable = aicraftFact.newAircraft(strings[0], strings[1], coordinates);
                flyable.registerTower(weatherTower);
                weatherTower.register(flyable);
            }
            catch (Exception e)
            {
                System.err.println("Error processing row: " + Arrays.toString(strings));
                System.err.println("Exception: " + e.getMessage());
            }
        }
        for (int i = 0; i < simulationNumber; i++) {
            weatherTower.changeWeather();
        }
        try {
            Print.closeSimulationFile();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return;
        }
    }
}