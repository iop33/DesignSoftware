package controller.myTree;

import controller.AbstractRuDokAction;
import model.RuNode;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.MyErrorHandler;
import view.dialogs.EditDialog;
import view.myTree.modal.MyTreeNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractRuDokAction {
    public EditAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(NAME,"Edit");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode sel= (MyTreeNode) MainFrame.getinstance().getMyTree().getLastSelectedPathComponent();
        if(sel.getNode() instanceof Presentation){
            EditDialog ed=new EditDialog((Presentation)sel.getNode());

        }
        else{
            MyErrorHandler.getInstance().errorSetting("GRESKA PRI EDITOVANJU","NISTE ODABRALI PREZENTACIJU","ODABERITE PREZENTACIJU",1);
        }

    }
}
