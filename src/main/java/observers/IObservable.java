package observers;

public interface IObservable {
    void registerObserver();
    void removeObserver();
    void notifyObservers(String message);
}
