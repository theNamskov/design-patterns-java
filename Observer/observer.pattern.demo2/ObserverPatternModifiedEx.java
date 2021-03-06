package observer.pattern.demo2;
import java.util.*;

interface IObserver {
    void update(int i);
}

class Observer1 implements IObserver {
@Override 
    public void update(int i) {
        System.out.println("Observer1: myValue in Subject is now: "+i+"\n");
    }
}

class Observer2 implements IObserver {
@Override 
    public void update(int i) {
        System.out.println("Observer2: observes->myValue is changed in Subject to: "+i+"\n");
    }
}

interface ISubject {
    void register(IObserver o);
    void unregister(IObserver o);
    void notifyObservers(int i);
}

class Subject implements ISubject {
    private int myValue;

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
        notifyObservers(myValue);
    }

    List<IObserver> observersList = new ArrayList<IObserver>();

@Override 
    public void register(IObserver o) {
        observersList.add(o);
    }

@Override 
    public void unregister(IObserver o) {
        observersList.remove(o);
    }

@Override 
    public void notifyObservers(int updatedValue) {
        for(int i = 0; i < observersList.size(); ++i) {
            observersList.get(i).update(updatedValue);
        }
    }
}


class ObserverPatternModifiedEx {

    public static void main(String[] args) {
        System.out.println("\n\n*** Modified Observer Pattern Demo ***\n");

        Subject sub = new Subject();
        Observer1 ob1 = new Observer1();
        Observer2 ob2 = new Observer2();

        sub.register(ob1);
        sub.register(ob2);

        sub.setMyValue(5);
        sub.setMyValue(25);

        sub.unregister(ob1);
        sub.setMyValue(100);
    }
}