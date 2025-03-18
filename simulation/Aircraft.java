package simulation;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public void updateConditions() {}

    public boolean isEnd()
    {
        return  (coordinates.getHeight() == 0);
    }

    private String getSplitName(String longName) {
        String[] names = longName.split("\\.");
        String lastName = names[names.length - 1];
        return lastName;
    }

    public String outPutStartLine()
    {
        String message = getSplitName(this.getClass().getName()) + "#" + this.name + "(" + this.id + "):";
        return message;
    }
}