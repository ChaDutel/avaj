package simulation;

public class WeatherProvider {
    private String[] weather;

    private static WeatherProvider instance;
    
    private WeatherProvider() {
        this.weather[0] = "RAIN";
        this.weather[1] = "FOG";
        this.weather[2] = "SUN";
        this.weather[3] = "SNOW";
    }
    
    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordiantes) {
        int totalValue = p_coordiantes.getLongitude() + p_coordiantes.getLatitude() + p_coordiantes.getHeight();
        totalValue %= 4;
        return this.weather[totalValue];
    }
}