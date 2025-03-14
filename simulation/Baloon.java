package simulation;

public class Baloon extends Aircraft {
    // Baloon(long p_id, string p_name, Coordinates p_coordinate)
    public Baloon(long p_id, String p_name) {
        super(p_id, p_name);
    }

    @Override
    public void updateConditions() {
        System.out.println("update");
    }
}