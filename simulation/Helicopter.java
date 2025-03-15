package simulation;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
        System.out.println("helicopter created");
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (weather == "SUN")
        {
            this.coordinates.changeLongitude(10);
            this.coordinates.changeHeight(2);
        }
        else if (weather == "RAIN")
        {
            this.coordinates.changeLongitude(5);
        }
        else if (weather == "FOG")
        {
            this.coordinates.changeLongitude(1);
        }
        else if (weather == "SNOW")
        {
            this.coordinates.changeHeight(-12);
        }
        System.out.println("update");
    }
}