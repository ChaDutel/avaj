package simulation;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    @Override
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        if (weather == "SUN")
        {
            this.coordinates.changeLongitude(2);
            this.coordinates.changeHeight(4);
        }
        else if (weather == "RAIN")
        {
            this.coordinates.changeHeight(-5);
        }
        else if (weather == "FOG")
        {
            this.coordinates.changeHeight(-3);
        }
        else if (weather == "SNOW")
        {
            this.coordinates.changeHeight(-15);
        }
        // else 
        System.out.println("update");
    }
}