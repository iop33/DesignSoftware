package controller;

import com.sun.tools.javac.Main;
import model.RuNode;
import model.RuNodeComposite;
import model.commands.DeleteCommand;
import model.nodeModels.Project;
import model.nodeModels.Workspace;
import view.MainFrame;
import view.MyErrorHandler;
import view.myTree.modal.MyTreeNode;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteNodeAction extends AbstractRuDokAction {
    public DeleteNodeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("icons\\deleteIcon.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");

    }


    @Override
    public void actionPerformed(ActionEvent e) {


        MyTreeNode zaBrisanje=( (MyTreeNode) MainFrame.getinstance().getMyTree().getLastSelectedPathComponent());
        RuNode del=zaBrisanje.getNode();
        if(!(del instanceof Workspace)) {
            MainFrame.getinstance().getCommandManager().addCommand(new DeleteCommand(zaBrisanje,del));
           /*
            RuNodeComposite par= (RuNodeComposite) del.getParent();
           par.remove(del);
           SwingUtilities.updateComponentTreeUI(MainFrame.getinstance());
            */

        }
        else{
            MyErrorHandler.getInstance().errorSetting("GRESKA PRI BRISANJU","Ne mozete brisati Workspace "," Odaberite drugi cvor",0);
        }


    }
}
