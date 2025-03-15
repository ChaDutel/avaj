package simulation;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (weather == "SUN")
        {
            this.coordinates.changeLatitude(10);
            this.coordinates.changeHeight(2);
        }
        else if (weather == "RAIN")
        {
            this.coordinates.changeLatitude(5);
        }
        else if (weather == "FOG")
        {
            this.coordinates.changeLatitude(1);
        }
        else if (weather == "SNOW")
        {
            this.coordinates.changeHeight(-7);
        }
        System.out.println("update");
    }
}