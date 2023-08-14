package controller;

import model.elemStates.RemoveState;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RemoveSlotAction extends AbstractRuDokAction{

    public RemoveSlotAction() {
        putValue(NAME,"Delete slot");
        putValue(SMALL_ICON,loadIcon("icons\\removeSlot32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TabWorkspace tw = (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
        TabProject tabProject= tw.getTp();
        JScrollPane jsp= (JScrollPane) tabProject.getSelectedComponent();
        TabPresentation tabPresentation= (TabPresentation) jsp.getViewport().getView();
        Presentation presentation=tabPresentation.getP();
        presentation.setElementState(new RemoveState());
    }
}
