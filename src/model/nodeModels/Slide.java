package model.nodeModels;

import model.RuNode;
import model.RuNodeComposite;
import model.Slot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slide extends RuNode implements Serializable {
    private List<Slot>slots;
    public Slide(String name, RuNodeComposite parent) {
        super(name, parent);
        slots=new ArrayList<>();
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
