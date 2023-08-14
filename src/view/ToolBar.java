package view;

import javax.swing.*;

public class ToolBar extends JToolBar {
    public ToolBar() {
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getinstance().getActionManager().getNewAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getInfoAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getDelAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getSlideShow());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getUndoAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getRedoAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getSaveProjectAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getOpenAction());
        addSeparator();
        add(MainFrame.getinstance().getActionManager().getShareAction());
    }
}
