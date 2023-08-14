package controller;

import model.nodeModels.Project;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRuDokAction{
    public SaveProjectAction() {
        putValue(NAME,"Save");
        putValue(SMALL_ICON,loadIcon("icons\\save32x32.png"));
    }

    public void actionPerformed(ActionEvent arg0) {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        Project project= MainFrame.getinstance().getMyTree().getCurrentProject();
        File projectFile=null;

        if(project != null) {

            if (project.isChanged()) {
                return;
            }

            if (project.getProjectFile() == null) {
                if (jfc.showSaveDialog(MainFrame.getinstance()) == JFileChooser.APPROVE_OPTION) {
                    projectFile = jfc.getSelectedFile();

                } else {
                    return;
                }

            }
        } else {
            return;
        }


        ObjectOutputStream os;
        try {
            os = new ObjectOutputStream(new FileOutputStream(projectFile));
            os.writeObject(project);
            project.setProjectFile(projectFile);
            project.setChanged(false);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }





    }
}
