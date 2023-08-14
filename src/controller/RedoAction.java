package controller;

import view.MainFrame;

import java.awt.event.ActionEvent;

public class RedoAction extends AbstractRuDokAction {
    public RedoAction() {
        putValue(NAME,"Redo");
        putValue(SMALL_ICON,loadIcon("icons\\redo32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getinstance().getCommandManager().doCommand();

    }
}
