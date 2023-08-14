package controller;

import model.presStates.ShowState;
import model.nodeModels.Presentation;
import view.MainFrame;
import view.myTree.view.TabPresentation;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SlideCardShowAction extends AbstractRuDokAction{
    public SlideCardShowAction() {
        putValue(NAME,"SlideShow");
        putValue(SMALL_ICON,loadIcon("icons\\slideshow32x32.png"));
        putValue(SHORT_DESCRIPTION,"SlideShow");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getinstance().getSp().getRightComponent() instanceof TabWorkspace){
            TabWorkspace tw= (TabWorkspace) MainFrame.getinstance().getSp().getRightComponent();
            TabProject tp=tw.getTp();
            if(tp.getTabCount()>0){
                TabPresentation tabPresentation= (TabPresentation) ((JScrollPane)(tp.getSelectedComponent())).getViewport().getView();
                //Presentation p=tabPresentation.getP();
                //p.setPs(new ShowState());
                tabPresentation.setShowState();

            }
        }
    }
}
