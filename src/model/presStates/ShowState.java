package model.presStates;

import model.nodeModels.Presentation;
import view.MainFrame;
import view.SlideCardShow;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class ShowState implements PresentationState, Serializable {
    @Override
    public void changeState(Presentation presentation) {
        System.out.println("Menjaj mi state");
        MainFrame.getinstance().remove(MainFrame.getinstance().getTulbar());
        MainFrame.getinstance().setJMenuBar(null);
        SlideCardShow scs=new SlideCardShow(presentation);

       /* for(Component c:MainFrame.getinstance().getContentPane().getComponents()){
            System.out.println("asddd");
            if(c instanceof JSplitPane){
                ((JSplitPane) c).setRightComponent(scs);
            }
            System.out.println(c.getClass().getSimpleName());
        }*/
        TabWorkspace tw= (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
        int ind = 0;
        for(Component c:tw.getComponents()){
            
            if(c instanceof TabProject){
             
                ind=((TabProject) c).getSelectedIndex();
                
            }
            
        }
        for(Component c:tw.getComponents()){
            if(c instanceof TabProject){
                ((TabProject) c).setComponentAt(ind,scs);
            }
        }


        presentation.removeSubscriber(scs.getTp());
        MainFrame.getinstance().revalidate();
        MainFrame.getinstance().repaint();
        tw.remove(tw.getSecondToolBar());
        tw.remove(tw.getJsp());
        scs.revalidate();
        scs.repaint();

    }
}
