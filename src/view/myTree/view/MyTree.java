package view.myTree.view;

import controller.myTree.MyTripleClickListener;
import model.RuNode;
import model.nodeModels.Project;
import view.MainFrame;
import view.myTree.controller.MyRenderer;
import view.myTree.modal.MyTreeModel;
import view.myTree.modal.MyTreeNode;

import javax.swing.*;

public class MyTree extends JTree {
    public MyTree() {
        setCellEditor(new MyTripleClickListener(this,null));
        setEditable(true);
        setCellRenderer(new MyRenderer());
        setEditable(true);
    }
    public Project getCurrentProject(){
        MyTreeNode mtn= (MyTreeNode) MainFrame.getinstance().getMyTree().getLastSelectedPathComponent();
        RuNode ruNode=mtn.getNode();
        if(ruNode instanceof Project){
            return (Project) ruNode;
        }
        else {
            return null;
        }
    }
    public void addProject(Project project){
        ((MyTreeModel)getModel()).addProject(project);
        SwingUtilities.updateComponentTreeUI(this);

    }
}
