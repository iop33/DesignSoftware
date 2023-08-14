package model.nodeModels;

import model.elemStates.AddState;
import model.elemStates.SlotState;
import model.presStates.PresentationState;
import model.presStates.ReturnState;
import model.RuNodeComposite;

import java.awt.*;
import java.io.Serializable;

public class Presentation extends RuNodeComposite implements Serializable {
    private boolean shared;
    private String autor;
    private transient Image slika;
    private PresentationState ps;
    private SlotState elementState;
    public Presentation(String name, RuNodeComposite parent,String autor,Image slika) {
        super(name, parent);
        this.autor=autor;
        this.slika=slika;
        this.ps=new ReturnState();
        this.elementState=new AddState();
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public SlotState getElementState() {
        return elementState;
    }

    public void setElementState(SlotState elementState) {
        this.elementState = elementState;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifySubscribers(this);
    }

    public Image getSlika() {
        return slika;
    }

    public void setSlika(Image slika) {
        this.slika = slika;
        notifySubscribers(this);
    }

    public PresentationState getPs() {
        return ps;
    }

    public void setPs(PresentationState ps) {
        this.ps = ps;
        this.ps.changeState(this);
    }

}
