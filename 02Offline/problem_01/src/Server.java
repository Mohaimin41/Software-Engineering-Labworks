import java.util.ArrayList;
import java.util.List;

/**
 * Subject
 */
interface Subject {
    void registerObserver(Observers o);
    void removeObserver(Observers o);
    void notifyObserver();
    
}

public class Server implements Subject{
    /**
     * 0 Operational
     * 1 Partially Down
     * 2 Fully Down
     */
    private int state = 0, previousState = 0;
    
    
    @Override
    public String toString() {
        return "\t\tABC Server\nStates: 0 Operational, 1 Partially Down, 2 Fully Down\nCurrent state: " + state + ", previous State: " + previousState;
    }

    private List<Observers> observers;
    
    public Server(int state) {
        this.state = state;
        observers = new ArrayList<Observers>();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        previousState = this.state;
        this.state = state;  
        notifyObserver();      
    }

    public int getPreviousState() {
        return previousState;
    }

    public void setPreviousState(int previouState) {
        this.previousState = previouState;
    }

    public List<Observers> getObservers() {
        return observers;
    }

    public void setObservers(List<Observers> observers) {
        this.observers = observers;
    }

    @Override
    public void registerObserver(Observers o) {
        observers.add(o);        
    }

    @Override
    public void removeObserver(Observers o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        
        for (int i = 0; i < observers.size(); i++ ) {
            Observers o = (Observers) observers.get(i);
            o.update(previousState, state);    
        }
    }
    
}
