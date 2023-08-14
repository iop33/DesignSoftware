package controller;

import model.elemStates.MoveState;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveSlotAction extends AbstractRuDokAction{
    public MoveSlotAction() {

        putValue(NAME,"Select slot");
        putValue(SMALL_ICON,loadIcon("icons\\selectSlot32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TabWorkspace tw = (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
        TabProject tabProject= tw.getTp();
        JScrollPane jsp= (JScrollPane) tabProject.getSelectedComponent();
        TabPresentation tabPresentation= (TabPresentation) jsp.getViewport().getView();
        Presentation presentation=tabPresentation.getP();
        presentation.setElementState(new MoveState());
    }
}
