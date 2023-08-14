package model.commands;

import com.sun.tools.javac.Main;
import model.RuNode;
import model.RuNodeComposite;
import model.Slot;
import model.factories.AbstractNodeFactory;
import model.factories.FactoryGenerator;
import model.nodeModels.Presentation;
import model.nodeModels.Project;
import model.nodeModels.Slide;
import view.MainFrame;
import view.myTree.modal.MyTreeNode;
import view.myTree.view.TabSlide;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeleteCommand extends AbstractCommand{
    private RuNode ruNode;
    private RuNode parent;
    private ArrayList<Slot>slots=new ArrayList<>();
    private ArrayList<Project>projects=new ArrayList<>();
    private MyTreeNode selektovani;
    public DeleteCommand(MyTreeNode selektovani, RuNode ruNode) {
        this.selektovani = selektovani;
        this.ruNode = ruNode;
        this.parent = ruNode.getParent();
        if (ruNode instanceof Slide){
            for (Slot s : ((Slide) ruNode).getSlots()){
                System.out.println("Punim slotove");
                slots.add(s);
            }
        }
        if(ruNode instanceof Presentation){
            for(int i=0;i< MainFrame.getinstance().getMyTree().getModel().getChildCount(MainFrame.getinstance().getMyTree().getModel().getRoot());i++){
                MyTreeNode mtn=(MyTreeNode) MainFrame.getinstance().getMyTree().getModel().getChild(MainFrame.getinstance().getMyTree().getModel().getRoot(),i);
                RuNodeComposite n= (RuNodeComposite) mtn.getNode();
                if(n.getNodeChildren().contains(ruNode) && !(n.equals(parent))){
                    this.projects.add((Project) n);
                }

            }
        }
    }

    @Override
    public void doCommand() {
        ((RuNodeComposite)ruNode.getParent()).remove(ruNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());

        if (ruNode instanceof Project){
            System.out.println("Obrisan projekat");
            MainFrame.getinstance().getSp().setRightComponent(new JPanel());
            MainFrame.getinstance().setJMenuBar(MainFrame.getinstance().getMeni());
            MainFrame.getinstance().add(MainFrame.getinstance().getTulbar(), BorderLayout.NORTH);
            MainFrame.getinstance().revalidate();
            MainFrame.getinstance().repaint();
        }
        if(ruNode instanceof Presentation){
            for(int i=0;i<this.projects.size();i++){
                this.projects.get(i).getNodeChildren().remove(ruNode);
            }
        }
    }

    @Override
    public void undoCommand() {

        // ((RuNodeComposite)f.getNodeFromTree(selektovani)).addChild(dete.getMyNode());
        if (ruNode instanceof Slide){
            ((Slide)ruNode).getSlots().addAll(this.slots);
            System.out.println("Vracam slotove na slajd");
        }
        if(ruNode instanceof Presentation){
            for(int i=0;i<this.projects.size();i++){
                this.projects.get(i).getNodeChildren().add(ruNode);
            }
        }
        ((RuNodeComposite) parent).add(ruNode);
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());

    }
}
