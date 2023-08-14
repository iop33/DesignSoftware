package controller;

import view.MainFrame;
import view.dialogs.ChooseStrokeDialog;
import view.myTree.view.TabWorkspace;

import java.awt.event.ActionEvent;

public class ChooseStrokeAction extends AbstractRuDokAction{
    public ChooseStrokeAction() {
        putValue(NAME,"Choose a stroke");
        putValue(SMALL_ICON,loadIcon("icons\\strokeChoose32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ChooseStrokeDialog chooseStrokeDialog=new ChooseStrokeDialog((TabWorkspace) MainFrame.getinstance().getSp().getRightComponent());
    }
}
