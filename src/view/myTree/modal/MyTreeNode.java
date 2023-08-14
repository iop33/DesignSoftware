package view.myTree.modal;

import model.RuNode;
import model.RuNodeComposite;

import javax.swing.tree.TreeNode;
import java.util.Enumeration;

public class MyTreeNode implements TreeNode {

RuNode node;

    public MyTreeNode(RuNode node) {
        this.node = node;
    }

    public RuNode getNode() {
        return node;
    }

    public void setNode(RuNode node) {
        this.node = node;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if(node instanceof RuNodeComposite){
           RuNode rn=((RuNodeComposite) node).getNodeChildren().get(childIndex);
            return new MyTreeNode(rn);
        }
        else{
            return null;
        }
    }

    @Override
    public int getChildCount() {
        if(node instanceof RuNodeComposite){
            return ((RuNodeComposite) node).getNodeChildren().size();
        }
        else{
            return 0;
        }
    }

    @Override
    public TreeNode getParent() {
        return (TreeNode) node.getParent();
    }

    @Override
    public int getIndex(TreeNode node) {
        if(node instanceof RuNodeComposite){
            return ((RuNodeComposite) node).getNodeChildren().indexOf(node);
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean getAllowsChildren() {
        if(node instanceof RuNodeComposite){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isLeaf() {
        if(node instanceof RuNodeComposite){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Enumeration<? extends TreeNode> children() {
        return null;
    }

    @Override
    public String toString() {
        return node.getIme();
    }
}
