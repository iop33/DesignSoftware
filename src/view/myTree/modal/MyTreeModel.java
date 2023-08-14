package view.myTree.modal;

import model.nodeModels.Project;
import model.nodeModels.Workspace;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class MyTreeModel extends DefaultTreeModel {

    public MyTreeModel(TreeNode root) {
        super(root);
    }
    public void addProject(Project project){
        MyTreeNode myTreeNode = (MyTreeNode) getRoot();
        Workspace w = (Workspace) myTreeNode.getNode();
        w.add(project);
        project.setParent(w);
    }

}
