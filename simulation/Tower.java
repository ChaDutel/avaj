package simulation;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;
    Tower() {
        this.observers = new ArrayList<Flyable>();
    }

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
        Print.print(p_flyable.outPutStartLine() + " registered to weather tower");
    }
    public void unregister(Flyable p_flyable) {
        this.observers.remove(p_flyable);
        Print.print(p_flyable.outPutStartLine() + " unregistered from weather tower");
    }
    protected void conditionChanged() {
        List<Flyable> endObservers = new ArrayList<Flyable>();
        for (Flyable flyable : observers) {
            flyable.updateConditions();
            if (flyable.isEnd())
            {
                endObservers.add(flyable);
            }
        }
        for (Flyable endFlyable : endObservers)
        {
            unregister(endFlyable);
        }
    }
}