package simulation;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude(){
        return this.latitude;
    }

    public int getHeight(){
        return this.height;
    }

    public void changeLongitude(int number) {
        this.longitude += number;
    }

    public void changeLatitude(int number) {
        this.latitude += number;
    }

    public void changeHeight(int number) {
        this.height += number;
        if (this.height > 100)
            this.height = 100;
        else if (this.height < 0)
            this.height = 0;
    }
}