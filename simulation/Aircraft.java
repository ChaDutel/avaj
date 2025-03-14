package simulation;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
        // Coordinate coordinates;

        // Aircraft(long p_id, string p_name, Coordinates p_coordinate);
    protected Aircraft(long p_id, String p_name) {
        this.id = p_id;
        this.name = p_name;
        System.out.println(id + name);
    }

    public void updateConditions() {}
}