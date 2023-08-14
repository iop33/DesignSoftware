package controller;

import model.nodeModels.Project;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OpenAction extends AbstractRuDokAction{
    public OpenAction() {
        putValue(NAME,"Undo");
        putValue(SMALL_ICON,loadIcon("icons\\open32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new ProjectFileFilter());

        if(jfc.showOpenDialog(MainFrame.getinstance())==JFileChooser.APPROVE_OPTION){
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));

                Project p=null;
                try {
                    p = (Project) os.readObject();
                } catch (Exception es) {
                    // TODO Auto-generated catch block
                    es.printStackTrace();
                }


                MainFrame.getinstance().getMyTree().addProject(p);


            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            } 


        }
    }
}
