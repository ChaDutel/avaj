package simulation;

import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable p_flyable) {
        // to do : add security when 
        this.observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable) {
        // to do : add security when list is reading from outside
        // try and catch if p_flyable not exists
        this.observers.remove(p_flyable);
    }
    protected void conditionChanged() {

    }
}