package controller.myTree;

import model.RuNode;
import model.nodeModels.Presentation;
import model.nodeModels.Project;
import model.nodeModels.Slide;
import model.nodeModels.Workspace;
import view.myTree.modal.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MyTripleClickListener extends DefaultTreeCellEditor implements ActionListener {


    private Object objekat=null;
    private JTextField tekst=null;
    public MyTripleClickListener(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
        super.getTreeCellEditorComponent(tree,value,isSelected,expanded,leaf,row);
        objekat=  value;
        tekst=new JTextField(value.toString());
        tekst.addActionListener( this);
        return tekst;

    }

    @Override
    public boolean isCellEditable(EventObject event) {
        if(event instanceof MouseEvent)
            if(((MouseEvent)event).getClickCount()==3){
                return true;

            }
        return false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MyTreeNode mtn = (MyTreeNode) objekat;
        RuNode rn = mtn.getNode();

        if(rn instanceof Workspace){
            rn.setIme(e.getActionCommand());
            this.cancelCellEditing();
        }else if(rn instanceof Project){
            rn.setIme(e.getActionCommand());
            this.cancelCellEditing();
        }else if(rn instanceof Presentation){
           rn.setIme(e.getActionCommand());
            this.cancelCellEditing();
        }else if(rn instanceof Slide){
            rn.setIme(e.getActionCommand());
            this.cancelCellEditing();
        }


    }

}

