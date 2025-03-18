package simulation;

import java.io.FileWriter;
import java.io.IOException;

public class Print {
    static FileWriter simulationFile;
    public Print() {}
    public static void print(String message) {
        try {
            simulationFile.write(message + "\n");
        }
        catch (IOException e)
        {
            System.err.println((e.getMessage()));
        }
    }
    public static void initSimulationFile() throws IOException {
        simulationFile = new FileWriter("simulation.txt");
    }
    public static void closeSimulationFile() throws IOException {
        simulationFile.close();
    }
}
