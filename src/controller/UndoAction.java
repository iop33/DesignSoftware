package controller;

import view.MainFrame;

import java.awt.event.ActionEvent;

public class UndoAction extends AbstractRuDokAction{


    public UndoAction() {
        putValue(NAME,"Undo");
        putValue(SMALL_ICON,loadIcon("icons\\undo32x32.png"));
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        MainFrame.getinstance().getCommandManager().undoCommand();

    }

}
