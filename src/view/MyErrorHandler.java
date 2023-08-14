package view;

import observer.Publisher;
import observer.Subscriber;

import java.util.ArrayList;

public class MyErrorHandler implements Publisher {

    private static MyErrorHandler meh;
    private ArrayList<Subscriber>subscribers=new ArrayList<>();

    private MyErrorHandler() {
    }

public void errorSetting(String title,String text,String solution,int type){
        MyMessage m=new MyMessage(title,text,type,solution);
        notifySubscribers(m);
}
    public static MyErrorHandler getInstance (){
        if(meh==null){
            meh=new MyErrorHandler();
        }
            return meh;
    }

    @Override
    public void addSubscriber(Subscriber sub) {
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        this.subscribers.remove(sub);
    }



    @Override
    public void notifySubscribers(Object notification) {
        for(Subscriber s:this.subscribers){

            s.update(notification);
        }
    }
}
