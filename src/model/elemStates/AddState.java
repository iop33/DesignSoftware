package model.elemStates;

import controller.SerializableStrokeAdapter;
import model.Slot;
import model.nodeModels.Slide;
import view.myTree.view.*;

import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.io.Serializable;

public class AddState implements SlotState, Serializable {
    Color color=new Color(18, 1, 253);
    @Override
    public void mousePressed(TabSlide tabSlide,MouseEvent mouseEvent) {
        System.out.println("Uso ispod if-a");
        int width=90;
        int height=50;
        SerializableStrokeAdapter stroke=new SerializableStrokeAdapter(new BasicStroke(3f));
        Point point=mouseEvent.getPoint();

        Slide slide=tabSlide.getSlajd();

        Slot slot=new Slot(point,getColor(),height,width,stroke);
        Shape shape = new GeneralPath();
        ((GeneralPath)shape).moveTo(point.x, point.y);
        ((GeneralPath)shape).lineTo(point.x+width, point.y);
        ((GeneralPath)shape).lineTo(point.x+width, point.y+height);
        ((GeneralPath)shape).lineTo(point.x, point.y+height);
        ((GeneralPath)shape).closePath();
        slot.setShape(shape);
        slide.getSlots().add(slot);

        TabSlot tabSlot=new TabSlot(slot);
        tabSlide.getTabSlots().add(tabSlot);

        System.out.println(tabSlide.getParent().getParent().getParent().getParent().getParent().getClass().getSimpleName());
        System.out.println(tabSlide.getParent().getParent().getParent().getParent().getClass().getSimpleName());
        System.out.println(tabSlide.getParent().getParent().getParent().getClass().getSimpleName());
        System.out.println("greska3");
        TabProject tp= (TabProject) tabSlide.getParent().getParent().getParent().getParent();
        TabWorkspace tw= (TabWorkspace) tp.getParent();
        JScrollPane sp = tp.getScp();
        TabPresentation tpp = (TabPresentation) sp.getViewport().getView();
        for(Component c:tpp.getComponents()){
            System.out.println("greska2");
            System.out.println(c.getClass().getSimpleName());
            if(c instanceof TabSlide){
                System.out.println("greska");
                TabSlide ts= (TabSlide) c;
                if(ts.getSlajd().getIme().equals(slide.getIme())){
                    if(!ts.getTabSlots().contains(tabSlot)){
                        ts.getTabSlots().add(tabSlot);
                        ts.repaint();
                    }
                }
            }
        }
        for(Component c:((TabPresentation)(tw.getJsp().getViewport().getView())).getComponents()){
            if(c instanceof TabSlide){


                    TabSlide ts= (TabSlide) c;
                    if(ts.getSlajd().getIme().equals(slide.getIme())){
                        if(!ts.getTabSlots().contains(tabSlot)){
                            ts.getTabSlots().add(tabSlot);
                            ts.repaint();
                        }
                    }

            }

        }
        tabSlide.repaint();

    }

    @Override
    public void mouseReleased(TabSlide tabSlide, MouseEvent e) {

    }

    @Override
    public void mouseDragged(TabSlide tabSlide, MouseEvent e) {

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
