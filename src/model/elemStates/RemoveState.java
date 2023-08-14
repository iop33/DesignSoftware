package model.elemStates;

import model.nodeModels.Slide;
import view.myTree.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class RemoveState implements SlotState, Serializable {
    @Override
    public void mousePressed(TabSlide tabSlide, MouseEvent mouseEvent) {
        TabSlot s=null;
        TabProject tp= (TabProject) tabSlide.getParent().getParent().getParent().getParent();
        TabWorkspace tw= (TabWorkspace) tp.getParent();
        Slide slide=tabSlide.getSlajd();
        for(TabSlot ts:tabSlide.getTabSlots()){
            if(ts.getSlot().getShape().contains(mouseEvent.getPoint())){
                s=ts;
                break;
            }
        }

        if(s!=null){
            System.out.println("Brisem slot!");
            tabSlide.getTabSlots().remove(s);
            tabSlide.getSlajd().getSlots().remove(s.getSlot());

            JScrollPane sp = tp.getScp();
            TabPresentation tpp = (TabPresentation) sp.getViewport().getView();
            for(Component c:tpp.getComponents()){
                if(c instanceof TabSlide) {
                    TabSlide ts = (TabSlide) c;
                    if (ts.getSlajd().getIme().equals(tabSlide.getSlajd().getIme())) {
                        ts.getTabSlots().remove(s);
                        ts.repaint();
                    }
                }
            }
            for(Component c:((TabPresentation)(tw.getJsp().getViewport().getView())).getComponents()){
                if(c instanceof TabSlide){


                    TabSlide ts= (TabSlide) c;
                    if(ts.getSlajd().getIme().equals(slide.getIme())){
                        if(ts.getTabSlots().contains(s)){
                            ts.getTabSlots().remove(s);
                            ts.repaint();
                        }
                    }

                }

            }

        } else {
            System.out.println("Nije uso u if za brisanje slota");
        }




        tabSlide.repaint();
    }

    @Override
    public void mouseReleased(TabSlide tabSlide, MouseEvent e) {

    }

    @Override
    public void mouseDragged(TabSlide tabSlide, MouseEvent e) {

    }


}
