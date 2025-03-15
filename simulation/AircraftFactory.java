package simulation;

public class AircraftFactory {
    private static AircraftFactory instance;
    
    private AircraftFactory() {}
    
    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        return switch (p_type.toLowerCase()) {
            case "baloon" -> new Baloon(1, p_name, p_coordinates);
            case "helicopter" -> new Helicopter(1, p_name, p_coordinates);
            case "jetplane" -> new JetPlane(1, p_name, p_coordinates);
            default -> throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        };
    }
}