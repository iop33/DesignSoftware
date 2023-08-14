package model.nodeModels;

import model.RuNodeComposite;
import view.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.Serializable;

public class Project extends RuNodeComposite implements Serializable {
    transient boolean changed;
    File projectFile;
    public Project(String name, RuNodeComposite parent) {
        super(name, parent);
    }
    public void setChanged(boolean changed) {
        if (this.changed!=changed){
            this.changed=changed;
            SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
        }
    }

    public boolean isChanged() {
        return changed;
    }

    public File getProjectFile() {
        return projectFile;
    }


    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }
}
