package model.presStates;


import model.nodeModels.Presentation;
import model.nodeModels.Project;
import view.MainFrame;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ReturnState implements PresentationState, Serializable {
    @Override
    public void changeState(Presentation presentation) {

        this.returnToEditState(presentation);

    }
    public void returnToEditState(Presentation presentation){
        MainFrame.getinstance().setJMenuBar(MainFrame.getinstance().getMeni());
        MainFrame.getinstance().add(MainFrame.getinstance().getTulbar(), BorderLayout.NORTH);
       // TabWorkspace tw = new TabWorkspace(new TabProject((Project) presentation.getParent()));

        //tw.add(tw.getJsp(),BorderLayout.WEST);
        /*for(Component c:MainFrame.getinstance().getContentPane().getComponents()){
            if(c instanceof JSplitPane){
                ((JSplitPane) c).setRightComponent(tw);
                System.out.println("assd2");
            }
        }*/
        int ind = 0;
        TabWorkspace tw2= (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
        JScrollPane jsp=new JScrollPane();
        TabPresentation tabPresentation=new TabPresentation(presentation);
        jsp.setViewportView(tabPresentation);
        for(Component c:tw2.getComponents()){

            if(c instanceof TabProject){

                ind=((TabProject) c).getSelectedIndex();

            }

        }
        for(Component c:tw2.getComponents()){
            if(c instanceof TabProject){
                ((TabProject) c).setComponentAt(ind,jsp);
            }
        }
        tw2.add(tw2.getSecondToolBar(),BorderLayout.EAST);
        tw2.add(tw2.getJsp(),BorderLayout.WEST);
        tw2.changeTab((TabPresentation) ((JScrollPane) tw2.getTp().getSelectedComponent()).getViewport().getView());
        MainFrame.getinstance().revalidate();
        MainFrame.getinstance().repaint();
    }
}
