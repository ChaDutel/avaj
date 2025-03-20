package simulation;

import simulation.Main.AircraftException;

public class AircraftFactory {
    private static AircraftFactory instance;
    private static int id;
    
    private AircraftFactory() {
        id = 0;
    }
    
    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AircraftException {
        id++;
        return switch (p_type.toLowerCase()) {
            case "baloon" -> new Baloon(id, p_name, p_coordinates);
            case "helicopter" -> new Helicopter(id, p_name, p_coordinates);
            case "jetplane" -> new JetPlane(id, p_name, p_coordinates);
            default -> throw new Main.AircraftException("Unknown aircraft type: " + p_type);
        };
    }
}