package view.myTree.view;

import model.Slot;

import java.awt.*;
import java.io.Serializable;

public class TabSlot implements Serializable {
    private Slot slot;

    public TabSlot(Slot slot) {
        this.slot = slot;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public void paint(Graphics2D graphics2D){
        System.out.println("Crtam slot");
        graphics2D.setColor(slot.getColor());
        graphics2D.setPaint(slot.getColor());
        graphics2D.setStroke(slot.getStroke());
        graphics2D.drawRect((int)slot.getPosition().getX(),(int)slot.getPosition().getY(),slot.getWidth(),slot.getHeight());
        graphics2D.setPaint(slot.getColor());
        graphics2D.fillRect((int)slot.getPosition().getX(), (int)slot.getPosition().getY(), slot.getWidth(), slot.getHeight());
       // graphics2D.fill(slot.getShape());
    }

}
