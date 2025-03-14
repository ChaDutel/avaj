package simulation;

public class Coordinates {
    private int longitude;
    int latitude;
    int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
        System.out.println("Coordinates created");
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
}

// admnistratifpour batir convention indemniter logement et  verrouiller la date de debut
// contrat d'aternance, convention, dates pour avril est bon pour reserver train, je vis avec quentin quand il rentre, il me faut sujet et tuteur pour editer la convention,  indemnite logement comme javais le stage comme logement 