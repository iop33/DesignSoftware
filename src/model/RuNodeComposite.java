package model;

import model.nodeModels.Project;
import observer.Publisher;
import observer.Subscriber;

import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.UUID;

public class RuNodeComposite extends RuNode implements Serializable {

    private ArrayList<RuNode> nodeChildren;

    public RuNodeComposite(String ime, RuNode parent) {
        super(ime, parent);
        nodeChildren =new ArrayList<>();
    }
    public void add(RuNode n){
       this.nodeChildren.add(n);
       notifySubscribers(this);
    }
    public void remove(RuNode n){

        this.nodeChildren.remove(n);
        notifySubscribers(this);
    }


    public ArrayList<RuNode> getNodeChildren() {
        return nodeChildren;
    }

    public void setNodeChildren(ArrayList<RuNode> nodeChildren) {
        this.nodeChildren = nodeChildren;
    }
}
