package controller;

import model.elemStates.AddState;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.myTree.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ChooseColorAction extends AbstractRuDokAction{
    public ChooseColorAction() {
        putValue(NAME,"Choose color");
        putValue(SMALL_ICON,loadIcon("icons\\colorChooser32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TabWorkspace tw= (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
        TabProject tp=tw.getTp();
        JScrollPane jsp= (JScrollPane) tp.getSelectedComponent();
        TabPresentation tap= (TabPresentation) jsp.getViewport().getView();
        Presentation p=tap.getP();
        Color color= JColorChooser.showDialog(MainFrame.getinstance().getSp().getRightComponent(),"Choose a color",Color.BLUE);
        /*for(Component c:tap.getComponents()){
            if(c instanceof TabSlide){
                for(TabSlot cd:((TabSlide) c).getTabSlots()){
                    cd.getSlot().setColor(color);

                }
                c.repaint();
            }

        }*/
        if(p.getElementState() instanceof AddState){
            ((AddState) p.getElementState()).setColor(color);
        }
        for(Component c:((TabPresentation)(tw.getJsp().getViewport().getView())).getComponents()){
            if(c instanceof TabSlide){


                TabSlide ts= (TabSlide) c;
                if(ts.getSlajd().getIme().equals(ts.getSlajd().getIme())){
                    ts.repaint();
                }

            }

        }

    }
}
