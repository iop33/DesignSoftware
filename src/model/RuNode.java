package model;


import observer.Publisher;
import observer.Subscriber;

import java.io.Serializable;
import java.util.ArrayList;

public class RuNode implements Publisher, Serializable {
   String ime;
   RuNode parent;
   private ArrayList<Subscriber>subscribers;

    public RuNode(String ime, RuNode parent) {
        this.ime = ime;
        this.parent = parent;
        subscribers=new ArrayList<>();
    }

    @Override
    public void addSubscriber(Subscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for(int i=0;i<subscribers.size();i++){
            subscribers.get(i).update(notification);
        }
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
        notifySubscribers(this);
    }

    public RuNode getParent() {
        return parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
    }
}
