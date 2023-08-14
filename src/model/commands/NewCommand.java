package model.commands;

import model.RuNode;
import model.RuNodeComposite;
import model.Slot;
import model.factories.AbstractNodeFactory;
import model.factories.FactoryGenerator;
import model.nodeModels.Presentation;
import model.nodeModels.Slide;
import view.MainFrame;
import view.myTree.modal.MyTreeNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewCommand extends AbstractCommand{

    private MyTreeNode selektovani;
    private RuNode ruNode;
    private MyTreeNode dete;
    private ArrayList<Slot>slots = new ArrayList<>();

    public NewCommand(MyTreeNode selected, RuNode ruNode) {
        this.selektovani = selected;
        this.ruNode = ruNode;
    }

    @Override
    public void doCommand() {
        FactoryGenerator fg = new FactoryGenerator(selektovani.getNode());
        System.out.println(fg.getAbstractNodeFactory(selektovani.getNode()).getClass().getSimpleName());
        AbstractNodeFactory f = fg.getAbstractNodeFactory(selektovani.getNode());
        dete = new MyTreeNode(f.createNode(selektovani.getNode()));
        // ((RuNodeComposite)f.getNodeFromTree(selektovani)).addChild(dete.getMyNode());
        if (dete.getNode() instanceof Slide){
            ((Slide)dete.getNode()).getSlots().addAll(this.slots);
            System.out.println("Vracam slotove na slajd");
        }
        ((RuNodeComposite) selektovani.getNode()).add(dete.getNode());
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
        MainFrame.getinstance().getMyTree().expandPath(MainFrame.getinstance().getMyTree().getSelectionPath());
    }

    @Override
    public void undoCommand() {
        ((RuNodeComposite)ruNode).remove(dete.getNode());
        if (dete.getNode() instanceof Slide){
            for (Slot s : ((Slide) dete.getNode()).getSlots()){
                System.out.println("Punim slotove");
                slots.add(s);
            }
        }
        if (dete.getNode() instanceof Presentation){
            MainFrame.getinstance().setJMenuBar(MainFrame.getinstance().getMeni());
            MainFrame.getinstance().add(MainFrame.getinstance().getTulbar(), BorderLayout.NORTH);
            MainFrame.getinstance().revalidate();
            MainFrame.getinstance().repaint();
        }
        //  dete.getMyNode().setParent(null);
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());

    }
}
