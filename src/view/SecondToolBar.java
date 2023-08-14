package view;

import javax.swing.*;

public class SecondToolBar extends JToolBar {
    public SecondToolBar() {
        super(VERTICAL);
        setFloatable(false);
        add(MainFrame.getinstance().getActionManager().getAddSlotAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getMoveSlotAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getRemoveSlotAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getCca());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getCsa());
    }
}
