package view;

import javax.swing.*;

public class MenuBar extends JMenuBar {
    public MenuBar() {

        JMenu mfajl=new JMenu("File");
        mfajl.add(MainFrame.getinstance().getActionManager().getNewAction());
        mfajl.addSeparator();
        JMenu mhelp=new JMenu("Help");
        mfajl.add(MainFrame.getinstance().getActionManager().getEa());

        add(mfajl);
        add(mhelp);


    }
}
