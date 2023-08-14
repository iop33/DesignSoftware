package model.nodeModels;

import model.RuNode;
import model.RuNodeComposite;

import java.io.Serializable;

public class Workspace extends RuNodeComposite implements Serializable {
    public Workspace(String name, RuNodeComposite parent) {
        super(name, parent);
    }

}
