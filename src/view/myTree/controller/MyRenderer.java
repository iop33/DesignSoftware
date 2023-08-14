package view.myTree.controller;

import model.RuNode;
import model.nodeModels.Presentation;
import model.nodeModels.Project;
import model.nodeModels.Slide;
import model.nodeModels.Workspace;
import view.myTree.modal.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MyRenderer extends DefaultTreeCellRenderer {
    public MyRenderer() {
    }
    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row,hasFocus);



if(value instanceof MyTreeNode) {

    RuNode n=((MyTreeNode) value).getNode();

    if (n instanceof Workspace) {
        setIcon(loadIcon("treeIcons/workspace.png"));

    } else if (n instanceof Project) {
        setIcon(loadIcon("treeIcons/project.png"));

    } else if (n instanceof Presentation) {

        setIcon(loadIcon("treeIcons/presentation.png"));
    } else if (n instanceof Slide) {

        setIcon(loadIcon("treeIcons/slide.png"));

    }

    return this;
}
return this;
    }
    public Icon loadIcon(String fileName){

        URL imageURL=getClass().getResource(fileName);
        Icon icon=null;
        if(imageURL!=null){
            icon=new ImageIcon(imageURL);
        }
        else{
            System.err.println("Resource not found: "+ fileName);
        }
        return icon;
    }

}
