package controller.myTree;

import com.sun.tools.javac.Main;
import model.RuNode;
import model.nodeModels.Project;
import view.MainFrame;
import view.MyErrorHandler;
import view.myTree.modal.MyTreeNode;
import view.myTree.view.MyTree;
import view.myTree.view.TabProject;
import view.myTree.view.TabWorkspace;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyDoubleClickListener extends MouseAdapter {

    private MyTree stablo;

    public MyDoubleClickListener(MyTree stablo) {
        this.stablo = stablo;
        stablo.addMouseListener(this);

    }
    public void mousePressed(MouseEvent e){

        if(e.getClickCount()==2){
            MyTreeNode selektovan= (MyTreeNode) MainFrame.getinstance().getMyTree().getLastSelectedPathComponent();
            if(selektovan.getNode() instanceof Project){
                //Da li je vec otvoren neki stari TabProject

                if(MainFrame.getinstance().getSp().getRightComponent() instanceof TabProject){
                    //Ako je otvoren onda uzmemo referencu za projekat sa tog starog i od njega skines subscribera koji je bas taj stari TabProject
                    TabProject old = (TabProject) MainFrame.getinstance().getSp().getRightComponent();
                    Project oldp = old.getPr();
                    oldp.removeSubscriber(old);
                    //Ovo se radi da TabProject za ugaseni prohekat ne prima obavestenja ,jer nema razloga posto nije projekat otvoren
                }


                if(((Project) selektovan.getNode()).getNodeChildren().isEmpty()){
                    MyErrorHandler.getInstance().errorSetting("GRESKA PRI OTVARANJU","Ne mozete otvoriti projekat "," Dodaj prezentaciju",0);
                    return;
                }
               MainFrame.getinstance().getSp().setRightComponent(new TabWorkspace(new TabProject((Project) selektovan.getNode())));

                SwingUtilities.updateComponentTreeUI(MainFrame.getinstance().getMyTree());

            }
        }

    }


}
