package controller;

import model.RuNode;
import model.RuNodeComposite;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.dialogs.ShareDialog;
import view.myTree.modal.MyTreeNode;

import java.awt.event.ActionEvent;

public class ShareAction extends AbstractRuDokAction{
    public ShareAction() {
        putValue(NAME,"Share");
        putValue(SMALL_ICON,loadIcon("icons\\share32x32.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(MainFrame.getinstance().getMyTree().getLastSelectedPathComponent() instanceof MyTreeNode){
            MyTreeNode m=(MyTreeNode) MainFrame.getinstance().getMyTree().getLastSelectedPathComponent();
            if(m.getNode() instanceof Presentation){
                RuNode n=m.getNode();
                Presentation p=(Presentation)n;
                ShareDialog shareDialog=new ShareDialog(p);
            }else{
                return;
            }
        }
    }
}
