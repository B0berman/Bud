package Utils;

import java.util.ArrayList;

public abstract class Speaker<T> {

    protected ArrayList<T> listeners;

    public Speaker() {
        listeners = new ArrayList<T>();
    }

    public void addListener(T listener) {
        listeners.add(listener);
    }

    public void removeListener(T listener) {
        listeners.remove(listener);
    }
}
