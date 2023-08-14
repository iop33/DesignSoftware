package model.elemStates;

import model.nodeModels.Slide;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabProject;
import view.myTree.view.TabSlide;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class MoveState implements SlotState, Serializable {
    @Override
    public void mousePressed(TabSlide tabSlide, MouseEvent e) {

    }

    @Override
    public void mouseReleased(TabSlide tabSlide, MouseEvent e) {

    }

    @Override
    public void mouseDragged(TabSlide tabSlide, MouseEvent mouseEvent) {
        if(tabSlide.getSelectedTabSlot()!=null){
            System.out.println("Krece");
            Shape shape=new GeneralPath();
            ((GeneralPath)shape).moveTo(mouseEvent.getX(),mouseEvent.getY());
            ((GeneralPath)shape).lineTo(mouseEvent.getX()+tabSlide.getSelectedTabSlot().getSlot().getWidth(),mouseEvent.getY());
            ((GeneralPath)shape).lineTo(mouseEvent.getX()+tabSlide.getSelectedTabSlot().getSlot().getWidth(),mouseEvent.getY()+tabSlide.getSelectedTabSlot().getSlot().getHeight());
            ((GeneralPath)shape).lineTo(mouseEvent.getX(),mouseEvent.getY()+tabSlide.getSelectedTabSlot().getSlot().getHeight());
            ((GeneralPath)shape).closePath();
            tabSlide.getSelectedTabSlot().getSlot().setShape(shape);
            tabSlide.getSelectedTabSlot().getSlot().setPosition(mouseEvent.getPoint());
            tabSlide.repaint();
            TabProject tp= (TabProject) tabSlide.getParent().getParent().getParent().getParent();
            TabWorkspace tw= (TabWorkspace) tp.getParent();
            JScrollPane sp = tp.getScp();
            Slide slide=tabSlide.getSlajd();
            TabPresentation tpp = (TabPresentation) sp.getViewport().getView();
            for(Component c:tpp.getComponents()){
                if(c instanceof TabSlide){
                    TabSlide sl=(TabSlide) c;
                    if(sl.getSlajd().getIme().equals(tabSlide.getSlajd().getIme())){
                        sl.repaint();
                    }
                }
            }
            for(Component c:((TabPresentation)(tw.getJsp().getViewport().getView())).getComponents()){
                if(c instanceof TabSlide){


                    TabSlide ts= (TabSlide) c;
                    if(ts.getSlajd().getIme().equals(slide.getIme())){
                        ts.repaint();
                    }

                }

            }

        }

    }


}
