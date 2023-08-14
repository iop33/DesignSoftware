package controller;

import model.RuNode;
import model.RuNodeComposite;
import model.commands.NewCommand;
import model.factories.AbstractNodeFactory;
import model.factories.FactoryGenerator;
import model.nodeModels.Presentation;
import model.nodeModels.Project;
import model.nodeModels.Slide;
import model.nodeModels.Workspace;
import view.MainFrame;
import view.MyErrorHandler;
import view.dialogs.AutorDialog;
import view.myTree.modal.MyTreeNode;
import view.myTree.view.MyTree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewAction extends AbstractRuDokAction {
    public NewAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons\\new32x32.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode mtn= (MyTreeNode) MainFrame.getinstance().getMyTree().getLastSelectedPathComponent();
        /*
        if(mtn==null){
            MyErrorHandler.getInstance().errorSetting("GRESKA PRI SELEKTOVANJU","Niste selektovali "," selektujte tekst",0);
            return;
        }
        RuNode rn=mtn.getNode();

        if(rn instanceof Workspace){
            Project p=new Project("Projekat",(Workspace) rn);
            ((Workspace)rn).add(p);
            SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
        }
        if(rn instanceof Project){
            AutorDialog ad=new AutorDialog(rn);
        }
        if(rn instanceof Presentation){
            Slide s=new Slide("Slide "+(((Presentation) rn).getNodeChildren().size()+1),(Presentation)rn);
            ((Presentation)rn).add(s);
            SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
        }
        if(rn instanceof Slide){
            MyErrorHandler.getInstance().errorSetting("GRESKA PRI SELEKTOVANJU","Ne mozete selektovati slajd "," Selektujte drugo",0);
        }
*/
        if(mtn==null){
            MyErrorHandler.getInstance().errorSetting("GRESKA PRI SELEKTOVANJU","Niste selektovali "," selektujte tekst",0);
            return;
        }
        RuNode ruNode=mtn.getNode();
        if(ruNode instanceof Slide){
            MyErrorHandler.getInstance().errorSetting("GRESKA PRI SELEKTOVANJU","Ne mozete selektovati slajd "," Selektujte drugo",0);
            return;
        }
        MainFrame.getinstance().getCommandManager().addCommand(new NewCommand(mtn,ruNode));
       /*
        FactoryGenerator factoryGenerator=new FactoryGenerator(ruNode);
        AbstractNodeFactory abstractNodeFactory=factoryGenerator.getAbstractNodeFactory(ruNode);
        MyTreeNode myTreeNode=new MyTreeNode(abstractNodeFactory.createNode(ruNode));
        ((RuNodeComposite)ruNode).add(myTreeNode.getNode());
        SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());
        */

    }

}
