package observer.pattern.demo;
import java.util.*;

class Observer {
    public void update() {
        System.out.println("flag value changed in Subject\n");
    }
}

interface ISubject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}

class Subject implements ISubject {
    ArrayList<Observer> ObserverList = new ArrayList<Observer>();
    int _flag;

    public int getFlag() {
        return _flag;
    }

    public void setFlag(int _flag) {
        this._flag = _flag;
        notifyObservers();
    }

    @Override
    public void register(Observer o) {
        ObserverList.add(o);
    }

    @Override 
    public void unregister(Observer o) {
        ObserverList.remove(o);
    }

    @Override 
    public void notifyObservers() {
        if(ObserverList.size() == 0) System.out.println("No Observers to notify!\n"); 
        for(int i = 0; i < ObserverList.size(); ++i) ObserverList.get(i).update();
    }
}

class ObserverPatternEx {

    public static void main(String[] args) {

        System.out.println("\n\n*** Observer Pattern Demo ***\n");

        Observer o1 = new Observer();

        Subject sub1 = new Subject();
        sub1.register(o1);

        System.out.println("Setting Flag = 5");
        sub1.setFlag(5);

        System.out.println("Setting Flag = 25");
        sub1.setFlag(25);

        sub1.unregister(o1);

        System.out.println("Setting Flag = 50");
        sub1.setFlag(50);

        System.out.println();
    }

}