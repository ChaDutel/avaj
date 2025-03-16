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
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): Time for sunglasses");
        }
        else if (weather == "RAIN")
        {
            this.coordinates.changeLongitude(5);
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): I block the rain drops with my wings");
        }
        else if (weather == "FOG")
        {
            this.coordinates.changeLongitude(1);
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): I can't see mayday!");
        }
        else if (weather == "SNOW")
        {
            this.coordinates.changeHeight(-12);
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): That's soo pretty. Hope it doesn't break my wings");
        }
        System.out.println("update");
    }
}