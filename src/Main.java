import view.MainFrame;
import view.MyErrorHandler;

public class Main {

    public static void main(String[] args) {


        MainFrame mf=MainFrame.getinstance();
        mf.setVisible(true);
        MyErrorHandler.getInstance().addSubscriber(mf);
    }

}
