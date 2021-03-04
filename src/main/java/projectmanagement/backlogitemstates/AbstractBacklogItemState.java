package projectmanagement.backlogitemstates;

import observers.IObservable;
import observers.IObserver;

import java.util.List;

public abstract class AbstractBacklogItemState implements IObservable {
    List<IObserver> observers;

    public void itemTodo() {
        throw new UnsupportedOperationException();
    }

    public void itemInProgress() {
        throw new UnsupportedOperationException();
    }

    public void itemReadyForTest() {
        throw new UnsupportedOperationException();
    }

    public void itemTesting() {
        throw new UnsupportedOperationException();
    }

    public void itemTested() {
        throw new UnsupportedOperationException();
    }

    public void itemConfirmDoD() {
        throw new UnsupportedOperationException();
    }

    public void itemDone() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(message);
        }
    }
}
