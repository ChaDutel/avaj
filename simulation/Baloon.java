package simulation;

public class Baloon extends Aircraft {
    Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        System.out.println("update");
    }
}