package view.dialogs;

import com.sun.tools.javac.Main;
import model.RuNode;
import model.RuNodeComposite;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.myTree.modal.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShareDialog extends JDialog {
    Presentation presentation;
    private JPanel projectPanel;
    private JButton btOk;
    private JButton btCancel;
    private String selProject;

    public ShareDialog(Presentation presentation) {
        this.presentation = presentation;
        this.setLayout(new BorderLayout());
        this.setTitle("Deljenje "+presentation.getIme());
        projectPanel=new JPanel();
        for(int i =0;i< MainFrame.getinstance().getMyTree().getModel().getChildCount(MainFrame.getinstance().getMyTree().getModel().getRoot());i++){

            MyTreeNode node=(MyTreeNode) MainFrame.getinstance().getMyTree().getModel().getChild(MainFrame.getinstance().getMyTree().getModel().getRoot(),i);
            RuNode ruNode=node.getNode();
            RuNode presentationParent=this.presentation.getParent();
            if(!(ruNode.equals(presentationParent))){
                JButton projectButton=new JButton(ruNode.getIme());
                projectButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selProject=projectButton.getText();
                        System.out.println(selProject);
                        for(int k=0;k<MainFrame.getinstance().getMyTree().getModel().getChildCount(MainFrame.getinstance().getMyTree().getModel().getRoot());k++){
                            MyTreeNode m=(MyTreeNode) MainFrame.getinstance().getMyTree().getModel().getChild(MainFrame.getinstance().getMyTree().getModel().getRoot(),k);
                            RuNode pr=m.getNode();
                            if(pr.getIme().equals(selProject)){
                                ((RuNodeComposite)pr).add(presentation);
                                presentation.setShared(true);
                            }
                        }
                        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
                    }
                });
                projectPanel.add(projectButton);
            }

        }
        this.add(projectPanel,BorderLayout.CENTER);
        btCancel=new JButton("Done");
        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(presentation.isShared()){
                    presentation.setIme(presentation.getIme());
                }
                dispose();
            }
        });
        this.add(btCancel,BorderLayout.SOUTH);
        this.setLocationRelativeTo(MainFrame.getinstance().getSp());
        this.pack();
        this.setVisible(true);

    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
}
