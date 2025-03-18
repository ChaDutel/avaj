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
            Print.print(this.outPutStartLine() + " It's too hot! I'm gonna explose");
        }
        else if (weather == "RAIN")
        {
            this.coordinates.changeHeight(-5);
            Print.print(this.outPutStartLine() + " I like the sound of the water on me~");
        }
        else if (weather == "FOG")
        {
            this.coordinates.changeHeight(-3);
            Print.print(this.outPutStartLine() + " The fog doesn't affect me!");
        }
        else if (weather == "SNOW")
        {
            this.coordinates.changeHeight(-15);
            Print.print(this.outPutStartLine() + " The snow is too heavy urghh !");
        }
    }
}