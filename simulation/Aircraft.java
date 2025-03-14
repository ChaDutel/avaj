package simulation;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
        System.out.println(id + " " + name);
    }

    public void updateConditions() {}
}