package simulation;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    Tower() {
        this.observers = new ArrayList<Flyable>();
    }

    private String getSplitName(String longName) {
        System.out.println(longName);
        String[] names = longName.split("\\.");
        String lastName = names[names.length - 1];
        return lastName;
    }

    public void register(Flyable p_flyable) {
        // to do : add security when 
        this.observers.add(p_flyable);
        System.out.println(getSplitName(p_flyable.getClass().getName()) + " registered to weather tower");
    }
    public void unregister(Flyable p_flyable) {
        // to do : add security when list is reading from outside
        // try and catch if p_flyable not exists
        this.observers.remove(p_flyable);
        System.out.println(getSplitName(p_flyable.getClass().getName()) + " unregistered from weather tower");
    }
    protected void conditionChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}