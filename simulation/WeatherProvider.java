package simulation;

public class WeatherProvider {
    private String[] weather;

    private static WeatherProvider instance;
    
    private WeatherProvider() {
        this.weather = new String[] {"RAIN", "FOG", "SUN", "SNOW"};
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