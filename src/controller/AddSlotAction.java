package controller;

import model.elemStates.AddState;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddSlotAction extends AbstractRuDokAction{

    public AddSlotAction() {
        putValue(NAME,"Add new slot");
        putValue(SMALL_ICON,loadIcon("icons\\addSlot32x32.png"));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        TabWorkspace tw = (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
        TabProject tabProject= tw.getTp();
        System.out.println(tabProject.getClass().getSimpleName());
        JScrollPane jsp= (JScrollPane) tabProject.getSelectedComponent();
        System.out.println(jsp.getViewport().getView().getClass().getSimpleName());
        TabPresentation tabPresentation= (TabPresentation) jsp.getViewport().getView();
        Presentation presentation=tabPresentation.getP();
        System.out.println(presentation.getClass().getSimpleName());

        presentation.setElementState(new AddState());

    }
}
